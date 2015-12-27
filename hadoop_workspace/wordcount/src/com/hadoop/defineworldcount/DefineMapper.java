package com.hadoop.defineworldcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DefineMapper extends Mapper<LongWritable, Text, DefineModel, IntWritable>{
	private final static IntWritable one = new IntWritable(1);
	private final static DefineModel data=new DefineModel();
	@Override
	public void map(LongWritable key,Text value,Context context)
			throws IOException ,InterruptedException{
		String line=value.toString();
		char letterAttr[]=line.toCharArray();
		char letter;
		String letterStr=null;
		for (int i = 0; i < letterAttr.length; i++) {
			letter=letterAttr[i];
			letterStr=letter+"";
			if(letterStr.matches("^[a-zA-Z]*")){
				data.setTextKey(letterStr);
				data.setIntValue(1);
				context.write(data, one);
			}
		
		}
		
	}
}
	
	


