package com.hadoop.main;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.log4j.Logger;
	

public class Hadoop2Mysql {
	private static final Logger LOG=Logger.getLogger(Hadoop2Mysql.class);
	public static final Configuration conf=init();
	public static void start() throws Exception{
		LOG.info("开始执行运算分析+++++++++++++++++++++");
		DBConfiguration.configureDB(conf, "com.mysql.jdbc.Driver", "jdbc:mysql://10.52.7.11:3306/hadoop",
                "root", "123456");
		
		Job job=new Job(conf,"hadoop2mysql");
		
		DistributedCache.addFileToClassPath(new Path("/tmp/mysql-connector-java-5.1.30-bin.jar"), conf,FileSystem.get(conf));   
		job.setJarByClass(Hadoop2Mysql.class);
		FileInputFormat.addInputPath(job, new Path("/user/grid/logs"));
		FileInputFormat.addInputPath(job, new Path("/user/grid/input"));
		
		job.setMapperClass(LetterCountMapper.class);
		job.setReducerClass(LetterCountReducer.class);
		job.setCombinerClass(LetterCountCombine.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(DBOutputFormat.class);
		
		job.setOutputKeyClass(TableWritable.class);
		job.setOutputValueClass(TableWritable.class);
		
		String[] fields = { "letter", "count" ,"time"};
		
		
		DBOutputFormat.setOutput(job, "lettercount",fields);
		
		boolean status=job.waitForCompletion(true);
		if(status){
			LOG.info("ID : "+job.getJobID().toString()+" ,JOB name:"+ job.getJobName()+" 已经完成");
		}else{
			LOG.info(job.getJobName()+" 失败，请检查日志！");
		}
		
		
	}
	
	public static Configuration init(){
		LOG.info("开始初始化配置文件");
		Configuration conf=new 	Configuration();
		return conf;
	}
public static void main(String[] args) throws Exception {
	start();
}
}
