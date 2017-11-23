package org.bigdata.lib;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class Pair implements WritableComparable<Pair>{
	private Text product1;
	private Text product2;
	
	public Pair(){
		this.product1 = new Text("");
		this.product2 = new Text("");	
	}

	public Pair(String p1, String p2) {
		this.product1 = new Text(p1);
		this.product2 = new Text(p2);
	}
	
	public String getProduct1() {
		return product1.toString();
	}

	public void setProduct1(Text product1) {
		this.product1 = product1;
	}

	public String getProduct2() {
		return product2.toString();
	}

	public void setProduct2(Text product2) {
		this.product2 = product2;
	}

	@Override
	public void readFields(DataInput arg0) throws IOException {
		product1.readFields(arg0);
		product2.readFields(arg0);		
	}
	@Override
	public void write(DataOutput arg0) throws IOException {
		product1.write(arg0);
		product2.write(arg0);
	}

	@Override
	public int compareTo(Pair o) {
		int k = this.getProduct1().compareTo(o.getProduct1());
		if (k==0)
			return (this.getProduct2().compareTo(o.getProduct2()));
		return k;
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product1 == null) ? 0 : product1.toString().hashCode());
		result = prime * result + ((product2 == null) ? 0 : product2.toString().hashCode());
		
		return result;
	}
	@Override
	public boolean equals(Object p) {
		return (this.toString().equals(p.toString()));
	}
	
	@Override
	public String toString(){
		return "===(" + this.getProduct1() + ", " + this.getProduct2() + ")===";
	}
}
