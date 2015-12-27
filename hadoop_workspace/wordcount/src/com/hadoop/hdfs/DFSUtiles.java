package com.hadoop.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class DFSUtiles {
	private static final Configuration conf=new Configuration();
	private static final FileSystem fs=getFileSystem();
	private static FileSystem getFileSystem(){
		try {
			return FileSystem.get(conf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * 向远程机器拷贝文件
	 * @param local 本地路径
	 * @param dest 远程路径
	 * @return 成功否；
	 */
	public static String copyToDFS(String local,String dest){
			String message="success"; 
			try {
				if(fs==null){
				throw new Exception("初始化文件系统出错");
				}else {
					fs.copyFromLocalFile(new Path(local), new Path(dest));
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message=e.getMessage();
			}
			
		
		return message;
		
	}
	/**
	 * 从远程机器拷贝文件
	 * @param local 本地路径
	 * @param dest 远程路径
	 * @return 成功否；
	 */
	public static String copyFromDFS(String local,String dest){
			String message="success"; 
			try {
				if(fs==null){
				throw new Exception("初始化文件系统出错");
				}else {
					fs.copyToLocalFile(new Path(local), new Path(dest));
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message=e.getMessage();
			}
			
		
		return message;
		
	}
	
	/**
	 * 为文件重命名
	 * @param local 本地路径
	 * @param dest 远程路径
	 * @return 成功否；
	 */
	public static String renameDFS(String dest,String destRename){
			String message="success"; 
			try {
				if(fs==null){
				throw new Exception("初始化文件系统出错");
				}else {
					fs.moveFromLocalFile(new Path(dest), new Path(destRename));
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message=e.getMessage();
			}
			
		
		return message;
		
	}
	
	/**
	 * 删除文件系统；
	 * 
	 * @param dest 远程路径
	 * @return 成功否；
	 */
	public static String deleteDFSFiles(String dest){
			String message="success"; 
			try {
				if(fs==null){
				throw new Exception("初始化文件系统出错");
				}else {
					fs.deleteOnExit(new Path(dest));
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message=e.getMessage();
			}
			
		
		return message;
		
	}
	/**
	 * 创建远程文件夹；
	 * 
	 * @param dest 远程路径
	 * @return 成功否；
	 */
	public static String mkdir(String dest){
			String message="false"; 
			try {
				if(fs==null){
				throw new Exception("初始化文件系统出错");
				}else {
					boolean status=fs.mkdirs(new Path(dest));
					if(status){
						 message="true"; 
					}
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message=e.getMessage();
			}
			
		
		return message;
		
	}
	
	/**
	 * 创建远程文件；
	 * 
	 * @param dest 远程路径
	 * @return 成功否；
	 */
	public static String createNewFile(String dest){
			String message="false"; 
			try {
				if(fs==null){
				throw new Exception("初始化文件系统出错");
				}else {
					boolean status=fs.createNewFile(new Path(dest));
					
					if(status){
						 message="true"; 
					}
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message=e.getMessage();
			}
			
		
		return message;
		
	}
}
