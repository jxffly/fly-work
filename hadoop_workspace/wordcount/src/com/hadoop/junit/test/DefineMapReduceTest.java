package com.hadoop.junit.test;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.junit.Before;
import org.junit.Test;

import com.hadoop.definedatamodel.DefineMapper;
import com.hadoop.definedatamodel.DefineReducer;


public class DefineMapReduceTest {
	private Mapper mapper;
	private Reducer reducer;
	private MapReduceDriver driver;
	@Before
	public  void init(){
		mapper=new DefineMapper();
		reducer=new DefineReducer();
		driver=new MapReduceDriver(mapper, reducer);
	}
	
	@Test
	public  void test() throws IOException{
		String value="hello 1";
		String value1="hello 2";
		String value2="hello 15";
		String value3="hello 8";
		String value4="hello 7";
		String value5="hello 3";
		String value6="world 3";
		String value7="world 2";
		String value8="world 1";
		String value9="world 4";
		String value10="world 8";
		String value11="world 5";
		
		driver.withInput(null, new Text(value))
		.withInput(null, new Text(value1))
		.withInput(null, new Text(value2))
		.withInput(null, new Text(value3))
		.withInput(null, new Text(value4))
		.withInput(null, new Text(value5))
		.withInput(null, new Text(value6))
		.withInput(null, new Text(value7))
		.withInput(null, new Text(value8))
		.withInput(null, new Text(value9))
		.withInput(null, new Text(value10))
		.withOutput(new Text("world"), new Text("1,2,15,8,7,3"))
		.withOutput(new Text("hello"), new Text("3,2,1,4,8,5"))
		.runTest();
				
	}

}
