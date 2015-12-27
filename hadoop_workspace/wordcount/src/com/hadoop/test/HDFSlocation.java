package com.hadoop.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSlocation {
	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		FileSystem fs=FileSystem.get(conf);
		
		
		Path source=new Path("hdfs://10.51.101.57:9000/home/grid/input/");
		FileStatus filestatus=fs.getFileStatus(source);
		BlockLocation[] block=fs.getFileBlockLocations(filestatus, 0,3);
		for (int i = 0; i < block.length; i++) {
			String []hosts=block[i].getHosts();
			System.out.println("block_"+i+"_location:"+hosts[0]);
		}
		
	}

}
