package org.bigdata.lib;

import org.apache.hadoop.io.MapWritable;

public class myMapWriable extends MapWritable {
    @SuppressWarnings({ "rawtypes" })
	@Override
    public String toString() {
        String result = "(";
        for ( Entry mapWritable:super.entrySet()){
            result+= "(" + mapWritable.getKey() + ", " + mapWritable.getValue() + "), ";
        }
        result = result.substring(0,result.length()-2);
        result += ")";
        return result;
    }
}
