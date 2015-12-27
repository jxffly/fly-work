package com.hadoop.join;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class DefineMapper extends Mapper<LongWritable, Text, DefineModel, Text>{
	private final static IntWritable one = new IntWritable(1);
	private final static DefineModel data=new DefineModel();
	@Override
	public void map(LongWritable key,Text value,Context context)
			throws IOException ,InterruptedException{
		FileSplit fileSplit=(FileSplit)context.getInputSplit();
		String path=fileSplit.getPath().toString();
		String[] line=value.toString().split(" ");
		if(line.length!=2){
			return;
		}
		DefineModel df=new DefineModel();
		Text kv=new Text();
		if(path.indexOf("action")>=0){
			df.setIntValue(0);
			df.setTextKey(line[0]);
			df.setSecondValue(line[1]);
			kv.set(line[1]);
		}else if(path.indexOf("alipay")>=0){
			df.setIntValue(1);
			df.setTextKey(line[0]);
			df.setSecondValue(line[1]);
			kv.set(line[1]);
		}
		context.write(df, kv);
		
	}
}
	
	


