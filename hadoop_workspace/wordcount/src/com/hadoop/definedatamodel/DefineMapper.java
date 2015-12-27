package com.hadoop.definedatamodel;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DefineMapper extends Mapper<LongWritable, Text, DefineModel, IntWritable>{
	
	private final static DefineModel data=new DefineModel();
	private final static IntWritable intvalue=new IntWritable();
	@Override
	public void map(LongWritable key,Text value,Context context)
			throws IOException ,InterruptedException{
		String str[]=value.toString().split(" ");
		data.setTextKey(str[0]);
		data.setIntValue(Integer.parseInt(str[1]));
		intvalue.set(data.getIntValue());
		
		context.write(data, intvalue);
		}
		
			
	
	

}
