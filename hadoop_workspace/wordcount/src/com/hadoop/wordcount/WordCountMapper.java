package com.hadoop.wordcount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<Object, Text, Text, IntWritable> {

	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();

	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		StringTokenizer token = new StringTokenizer(line,
				", ?.!:\"\"''\n()<>|-=*/+“”’‘");
		String letter = null;
 		while (token.hasMoreTokens()) {
			letter = token.nextToken();
			if(letter.matches("^[A-Za-z]+$"))
			{
				word.set(letter);
				context.write(word, one);
			}else {
				System.out.println("illeagel words! :"+letter);
			}
		}

	}
}
