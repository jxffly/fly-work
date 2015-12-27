package com.hadoop.lettercount;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class LetterCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	private static final Log LOG = LogFactory.getLog(LetterCountMapper.class);
	private final static IntWritable one = new IntWritable(1);
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
				context.write(new Text(letterStr), one);
			}else{
				context.write(new Text("other words"), one);
			}
			
		}
		
			
		
		
		
	}
	

	
		
		
	}
