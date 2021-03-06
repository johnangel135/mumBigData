package org.myorg.acima;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class Demo {

	public static class Map extends Mapper<LongWritable, Text, Text, Pair> {
		private HashMap<Text, Pair> H = null;
		
		@SuppressWarnings("rawtypes")
		protected void setup(Mapper.Context context) throws IOException, InterruptedException {
			   H  = new HashMap<Text, Pair>();
			 }

		public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString().trim();
			String[] strList = line.split(" ");
			String ip = strList[0].trim();
			Long quantity;
			if (strList[strList.length-1].trim().contains("-")||strList[strList.length-1].trim().length()==0)
				return;
			
			quantity = Long.valueOf(strList[strList.length-1]);
			
			if (H.containsKey(ip)){
				Pair p = H.get(ip);
				H.put(new Text(ip), new Pair(p.getSum()+quantity, p.getCount()+1));
			}
			else{
				H.put(new Text(ip), new Pair(quantity, 1));
			}
			
		}
		public void cleanup(Context context) throws IOException, InterruptedException{
			for (Text ip: H.keySet()) {
			    context.write(ip, H.get(ip));
			}		
		}
	} 

	public static class Reduce extends Reducer<Text, Pair, Text, FloatWritable> {

		public void reduce(Text key, Iterable<Pair> pVal, Context context) 
				throws IOException, InterruptedException 
 {
			Long sum = 0L;
			int count = 0;
			for (Pair pv : pVal) {
				sum += pv.getSum();
				count += pv.getCount();
			}
			context.write(key, new FloatWritable(sum.floatValue()/count));
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();

		System.out.println("========Average Computation In Mapper Algorithm========");
		Job job = new Job(conf, "acimalgorithm");

		int numReducers = 4;
		job.setNumReduceTasks(numReducers);
		
		job.setJarByClass(Demo.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Pair.class);

		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.waitForCompletion(true);

	}


}
