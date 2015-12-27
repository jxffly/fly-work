package com.hadoop.defineworldcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class DefineReducer extends Reducer<DefineModel, IntWritable, DefineModel, IntWritable>{
	
	@Override	
	public void reduce(DefineModel key,Iterable<IntWritable>values,Context context) throws IOException,InterruptedException{
		int sum=0;
		for (IntWritable intWritable : values) {
			int value=intWritable.get();
			sum+=value;
		}
		key.setIntValue(sum);
		context.write(key, new IntWritable(key.getIntValue()));
	}
			
		}

