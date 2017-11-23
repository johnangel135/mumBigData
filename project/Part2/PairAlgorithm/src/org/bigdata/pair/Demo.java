package org.bigdata.pair;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.bigdata.lib.Pair;


public class Demo {

	public static class Map extends Mapper<LongWritable, Text, Pair, LongWritable> {
		public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString().replace("  ", " ").trim();
			String[] productList = line.split(" ");
			int len = productList.length;
			if (len ==0 )
				return;

			for (int i = 0; i< len-1; i++){
				String p1 = productList[i];
				int j = i + 1;
				while (j<len){
					String p2 = productList[j];
					if (p1.equals(p2))
						break;
					Pair p = new Pair(p1, p2);
					context.write(new Pair(p1, "!"), new LongWritable(1L));
					context.write(p, new LongWritable(1L));
					j++;
				}
			}
		}
	} 

	public static class Reduce extends Reducer<Pair, LongWritable, Pair, FloatWritable> {		
		Long N = 0L;		
		protected void setup(Reducer.Context context) throws IOException, InterruptedException {			
			N = 0L;
		}
		public void reduce(Pair key, Iterable<LongWritable> values, Context context) 
				throws IOException, InterruptedException {
			Long sum = 0L;
			for (LongWritable val : values) {
				sum += val.get();
			}
			if (key.getProduct2().equals("!")) {
				N = sum;
			} else {
				Pair p = new Pair (key.getProduct1(), "!");
				context.write(key, new FloatWritable(sum.floatValue()/N));
			}
		}
	}

	//Partitioner class

	public static class PairPartitioner extends
	Partitioner < Pair, LongWritable >
	{
		@Override
		public int getPartition(Pair key, LongWritable value, int numReduceTasks) {

			return key.getProduct1().hashCode()%numReduceTasks;
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();

		System.out.println("========Pair Algorithm========");
		Job job = new Job(conf, "acalgorithm");

		int numReducers = 4;
		job.setNumReduceTasks(numReducers);
		job.setPartitionerClass(PairPartitioner.class);

		job.setJarByClass(Demo.class);

		job.setOutputKeyClass(Pair.class);
		job.setOutputValueClass(LongWritable.class);

		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.waitForCompletion(true);

	}
}
