package com.hadoop.searchcombine;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DefineReducer extends Reducer<DefineModel, IntWritable, Text, Text>{
	
	@Override	
	public void reduce(DefineModel key,Iterable<IntWritable>values,Context context) throws IOException,InterruptedException{
		StringBuffer combineValue=new StringBuffer();
		for (IntWritable intWritable : values) {
			int value=intWritable.get();
			combineValue.append(value+",");
		}
		if(combineValue.length()>0){
			combineValue.deleteCharAt(combineValue.length()-1);
		}
		context.write(new Text(key.getTextKey()), new Text(combineValue.toString()));
	}
			
		}

