package org.bigdata;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.bigdata.lib.myMapWriable;

public class StripeAlgorithm {

	public static class Map extends Mapper<LongWritable, Text, Text, myMapWriable> {

		@Override
		public void map(LongWritable key, Text value, Context context
				) throws IOException, InterruptedException {

			String line = value.toString().replace("  "," ").trim();
			Text k = new Text();
			String[] productList = line.split(" ");
			for (int i = 0; i<productList.length - 1; i++){
				int j = i+1;
				myMapWriable mapWritable = new myMapWriable();
				while (j < productList.length){
					if(productList[j].equals(productList[i])) break;
					k.set(productList[i]);
					Text neighbor = new Text();
					neighbor.set(productList[j]);
					if(mapWritable.get(neighbor) == null){
						mapWritable.put(neighbor,new IntWritable(1));
					}

					else {
						int tmp = Integer.parseInt(mapWritable.get(neighbor).toString()) +1;
						mapWritable.put(neighbor,new IntWritable(tmp));
					}
					j++;
				}

				context.write(k,mapWritable);

			}
		}
	} 

	public static class Reduce extends Reducer<Text, myMapWriable, Text, myMapWriable> {

		public void reduce(Text key, Iterable<myMapWriable> values, Context context)
				throws IOException, InterruptedException {
			myMapWriable mapWritable = new myMapWriable();
			for (MapWritable val : values) {
				for(Writable k:val.keySet()){
					if(!mapWritable.containsKey(k)){
						mapWritable.put(k,new IntWritable(Integer.parseInt(val.get(k).toString())));
					}
					else{
						int tmp = Integer.parseInt(mapWritable.get(k).toString()) + Integer.parseInt(val.get(k).toString());
						mapWritable.put(k,new IntWritable(tmp));
					}
				}
			}
			float sum = 0;
			for(Writable writable:mapWritable.keySet()){
				sum += Integer.parseInt(mapWritable.get(writable).toString());
			}

			for (Writable writable:mapWritable.keySet()){
				float tmp = Float.parseFloat(mapWritable.get(writable).toString())/sum;
				mapWritable.put(writable,new DoubleWritable(tmp));
			}

			context.write(key, mapWritable);
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		System.out.println("=======Stripe Word Count Algorithm================");
		@SuppressWarnings("deprecation")
		Job job = new Job(conf, "wordcount");

		job.setJarByClass(StripeAlgorithm.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(myMapWriable.class);

		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.waitForCompletion(true);
	}

}