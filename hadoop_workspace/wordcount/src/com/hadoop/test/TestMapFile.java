package com.hadoop.test;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapFile;
import org.apache.hadoop.io.Text;

public class TestMapFile {
	private static final String[] DATA={
		"one,two,buckle my show",
		"three,for,shut the door",
		"five,six,pick up sticks",
		"seven,eight,lay them straight",
		"nine,ten,a big fat then"
	};
	public static void main(String[] args) throws IOException {
		String uri="hdfs://10.51.101.57:9000/user/grid/stream/map";
		Configuration conf=new Configuration();
		FileSystem fs=FileSystem.get(URI.create(uri),conf);
		IntWritable key=new IntWritable();
		Text value=new Text();
		MapFile.Writer writer=null;
		try {
			writer=new MapFile.Writer(conf, fs, uri, key.getClass(), value.getClass());
			for (int i = 0; i < 1024; i++) {
				key.set(i+1);
				value.set(DATA[i%DATA.length]);
				writer.append(key, value);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			IOUtils.closeStream(writer);
			
		}
		
	}

}
