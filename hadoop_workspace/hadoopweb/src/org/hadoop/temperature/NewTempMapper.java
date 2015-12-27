package org.hadoop.temperature;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class NewTempMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	public enum Temp{
		WRONG
	}
	private Temperature tem=new Temperature();
	@Override
	public void map(LongWritable key,Text value,Context context)
			throws IOException ,InterruptedException{
			tem.setValue(value.toString());
			if(tem.isValid()){
				context.write(new Text(tem.getYear()), new IntWritable(tem.getTemp()));
			}else{
				context.getCounter(Temp.WRONG).increment(1);
			}
		context.getCounter("TemperatureQuality", "Air Temperature record").increment(1);
		
	}
	

	
		
		
	}
