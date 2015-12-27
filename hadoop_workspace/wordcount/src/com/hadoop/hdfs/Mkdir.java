package com.hadoop.hdfs;

import java.io.IOException;

import org.apache.hadoop.fs.Path;



public class Mkdir {
	public static void main(String[] args) throws IOException {
		String path3="/user/grid/testfs";
		String path4="/user/grid/testfs3/test.log";
		Path path=new Path("/user/grid/testfs");
		Path path2=new Path("/user/grid/testfs2");
		Path local=new Path("C://Users//jinxiaofei//Desktop//数据//test.txt");
		Path local2=new Path("C://Users//jinxiaofei//Desktop//数据");
		System.out.println(DFSUtiles.createNewFile(path4));
		//fs.copyFromLocalFile(local, path);
		//fs.copyToLocalFile(path, local2);
		
	
	}

}
