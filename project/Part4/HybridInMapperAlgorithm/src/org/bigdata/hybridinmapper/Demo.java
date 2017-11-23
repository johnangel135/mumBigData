package org.bigdata.hybridinmapper;


import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.bigdata.lib.Pair;
import org.bigdata.lib.myMapWriable;


public class Demo {

	public static class Map extends Mapper<LongWritable, Text, Pair, LongWritable> {
		HashMap<Pair, Long> H = new HashMap<Pair, Long>();
		@SuppressWarnings("rawtypes")
		protected void setup(Mapper.Context context) throws IOException, InterruptedException {
			H  = new HashMap<Pair, Long>();
		}
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
					if (H.containsKey(p)){
						Long c = H.get(p) + 1L;
						H.put(p, c);
					}
					else {
						H.put(p, 1L);
					}
					j++;
				}
			}
		}
		public void cleanup(Context context) throws IOException, InterruptedException{
			for (Pair p: H.keySet()) {
				context.write(p, new LongWritable(H.get(p)));				
			}		
		}
	} 

	public static class Reduce extends Reducer<Pair, LongWritable, Text, myMapWriable> {		
		Long sum = 0L;
		String wPrev;
		myMapWriable H;
		protected void setup(Reducer.Context context) throws IOException, InterruptedException {			
			H = new myMapWriable();
			wPrev = "";
		}
		public void reduce(Pair key, Iterable<LongWritable> values, Context context) 
				throws IOException, InterruptedException {
			if ((!key.getProduct1().equals(wPrev)) && (wPrev.length()!=0)){
				for (Writable u: H.keySet()) {
					//sum += Long.valueOf(H.get(u).toString());
					H.put(u, new FloatWritable(Float.valueOf(H.get(u).toString())/sum));

				}
				context.write(new Text(wPrev), H);
				H.clear();
				sum = 0L;

			}
			Long total = 0L;
			for (LongWritable val : values) {
				total += val.get();
			}
			sum+=total;
			H.put(new Text(key.getProduct2()), new LongWritable(total));
			wPrev = key.getProduct1();
		}
		public void cleanup(Context context) throws IOException, InterruptedException{
			for (Writable u: H.keySet()) {
				//sum += Long.valueOf(H.get(u).toString());
				H.put(u, new FloatWritable(Float.valueOf(H.get(u).toString())/sum));

			}
			context.write(new Text(wPrev), H);
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

		System.out.println("========Hybrid In Mapper Algorithm========");
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
