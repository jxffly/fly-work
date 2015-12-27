package com.hadoop.junit.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

import com.hadoop.wordcount.WordCountReducer;


public class ReducerTest {
	private Reducer reducer;
	private ReduceDriver reduceDriver;
	
	@Before
	public void init(){
		reducer=new WordCountReducer();
		reduceDriver=new ReduceDriver(reducer);
	}
	@Test
	public void test() throws IOException{
		String key="world";
		List<IntWritable> value=new ArrayList<IntWritable>();
		value.add(new IntWritable(2));
		value.add(new IntWritable(3));
		value.add(new IntWritable(4));
		reduceDriver.withInput(new Text(key), value)
		.withOutput(new Text(key), new IntWritable(9))
		.run();
		
	}

}
