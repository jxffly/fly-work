package com.hadoop.test;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSMkdir {
	public static void main(String[] args) throws IOException {
		Configuration conf=new Configuration();
		FileSystem fs=FileSystem.get(conf);
		fs.mkdirs(new Path("/user/grid/test"));
		//Path source=new Path("/home/grid/input/test1.txt");
		Path source=new Path("d:\\data.txt");//
		Path dst=new Path("/user/grid/test");
		fs.copyFromLocalFile(source, dst);
	}
	
}

