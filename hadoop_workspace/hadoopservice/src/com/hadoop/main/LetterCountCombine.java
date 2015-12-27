package com.hadoop.main;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.log4j.Logger;

public class LetterCountCombine extends
		Reducer<Text, IntWritable, Text, IntWritable> {
	private static final Logger LOG=Logger.getLogger(LetterCountCombine.class);
	private IntWritable result = new IntWritable();

	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
			int sum = 0;
		for (IntWritable val : values) {
			sum += val.get();
		}
		result.set(sum);
		context.write(key, new IntWritable(sum));
	}
}