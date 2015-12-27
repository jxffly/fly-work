package com.hadoop.main;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.log4j.Logger;


public class LetterCountReducer extends Reducer<Text, IntWritable,TableWritable, TableWritable> {
		private static final Logger LOG=Logger.getLogger(LetterCountReducer.class);
		@Override
		public void reduce(Text key, Iterable<IntWritable> values,
				Context context)
				throws IOException,InterruptedException {
			 	int sum = 0;
	            for (IntWritable val : values) {
	                sum += val.get();
	            }
	            
	           
	           long time=System.currentTimeMillis();
	            context.write(new TableWritable(key.toString(),sum,time), null);	
		}
	
}
