package com.hadoop.junit.test;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.junit.Before;
import org.junit.Test;

import com.hadoop.wordcount.WordCountMapper;
import com.hadoop.wordcount.WordCountReducer;


public class MapReduceTest {
	private Mapper mapper;
	private Reducer reducer;
	private MapReduceDriver driver;
	@Before
	public  void init(){
		mapper=new WordCountMapper();
		reducer=new WordCountReducer();
		driver=new MapReduceDriver(mapper, reducer);
	}
	
	@Test
	public  void test() throws IOException{
		String value="hello world hello hadoop";
		String value1="hello world hello java";
		driver.withInput(null, new Text(value))
		.withInput(null, new Text(value1))
		
		.withOutput(new Text("hadoop"), new IntWritable(1))
		.withOutput(new Text("hello"), new IntWritable(4))
		.withOutput(new Text("java"), new IntWritable(1))	
		.withOutput(new Text("world"), new IntWritable(2))
		
		
		.runTest();
				
	}

}
