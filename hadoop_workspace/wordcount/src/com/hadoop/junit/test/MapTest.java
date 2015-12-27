package com.hadoop.junit.test;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Before;
import org.junit.Test;

import com.hadoop.wordcount.WordCountMapper;

public class MapTest {
	private Mapper mapper;
	private MapDriver driver;
	
	@Before
	public void init(){
		mapper=new WordCountMapper();
		driver=new MapDriver(mapper);
		
	}
	
	@Test
	public void test() throws IOException{
		String line ="��SCARLETT O��HARA was not beautiful, but men seldom realized it when caught by her charm as the Tarleton twins were. In her face were too sharply blended the delicate features of her mother, a Coast aristocrat of French descent, and the heavy ones of her florid Irish father. But it was an arresting face, pointed of chin, square of jaw. Her eyes were pale green without a touch of hazel, starred with bristly black lashes and slightly tilted at the ends. Above them, her thick black brows slanted upward, cutting a startling oblique line in her magnolia-white skin��that skin so prized by Southern women and so carefully guarded with bonnets, veils and mittens against hot Georgia suns.";
		driver.withInput(null, new Text(line))
			  .withOutput(new Text("Taobao"), new IntWritable(1))
			  .withOutput(new Text("is"), new IntWritable(1))
			  .withOutput(new Text("a"), new IntWritable(1))
			  .withOutput(new Text("great"), new IntWritable(1))
			  .withOutput(new Text("website"), new IntWritable(1))
			  .runTest();
	}

}
