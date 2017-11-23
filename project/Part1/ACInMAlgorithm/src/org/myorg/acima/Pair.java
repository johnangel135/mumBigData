package org.myorg.acima;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Writable;

public class Pair implements Writable{
	private LongWritable sum;
	private IntWritable count;
	
	public Pair(){
		this.sum = new LongWritable(0);
		this.count = new IntWritable(0);	
	}

	public Pair(Long sum, Integer count) {
		this.sum = new LongWritable(sum);
		this.count = new IntWritable(count);
	}
	public Long getSum() {
		return sum.get();
	}
	public void setSum(Long sum) {
		this.sum.set(sum);
	}
	public Integer getCount() {
		return count.get();
	}
	public void setCount(Integer count) {
		this.count.set(count);
	}
	@Override
	public void readFields(DataInput arg0) throws IOException {
		sum.readFields(arg0);
		count.readFields(arg0);		
	}
	@Override
	public void write(DataOutput arg0) throws IOException {
		sum.write(arg0);
		count.write(arg0);
	}

}
