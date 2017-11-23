package org.bigdata;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.bigdata.lib.myMapWriable;



public class InMapperStripeWordCount {

	public static class Map extends Mapper<LongWritable, Text, Text, myMapWriable> {
		private HashMap<Text, myMapWriable> hashMap;
		@Override
		public void setup(Context context){
			hashMap = new HashMap<Text, myMapWriable>();

		}

		@Override
		public void map(LongWritable key, Text value, Context context
				) throws IOException, InterruptedException {


			String line = value.toString().replace("  "," ").trim();

			String[] productList = line.split(" ");
			for (int i = 0; i<productList.length - 1; i++){
				int j = i+1;
				myMapWriable mapWritable;
				while (j < productList.length){
					if(productList[j].equals(productList[i])) break;
					Text k = new Text();
					k.set(productList[i]);
					if(!hashMap.containsKey(k)){
						mapWritable = new myMapWriable();
						System.out.printf("======New inside map");
					}
					else {
						mapWritable = hashMap.get(k);
						System.out.printf("=====Get the old hashmap: ====" + mapWritable.toString());
					}
					Text neighbor = new Text();
					neighbor.set(productList[j]);
					if(!mapWritable.containsKey(neighbor)){
						mapWritable.put(neighbor,new IntWritable(1));
					}

					else {
						int tmp = Integer.parseInt(mapWritable.get(neighbor).toString()) +1;
						mapWritable.put(neighbor,new IntWritable(tmp));
					}
					hashMap.put(k,mapWritable);
					j++;
				}

			}
		}

		@Override
		public void cleanup(Context context) throws IOException, InterruptedException {
			for (Text w:hashMap.keySet()){
				context.write(w, hashMap.get(w));
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

		@SuppressWarnings("deprecation")
		Job job = new Job(conf, "wordcount");

		job.setJarByClass(InMapperStripeWordCount.class);

		job.setNumReduceTasks(4);
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