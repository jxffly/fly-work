package com.hadoop.lettercount;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.mapreduce.TableOutputFormat;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;


public class LetterCount {
	private static final Log LOG = LogFactory.getLog(LetterCount.class);
	public static final Configuration conf=init();
	public static void run() throws Exception{
		String table="wordcountforweb";		
		conf.set(TableOutputFormat.OUTPUT_TABLE,table);
		creatTable(table);
		Job job=new Job(conf,"hbase createTable");
		job.setJarByClass(LetterCount.class);
		FileInputFormat.addInputPath(job, new Path("hdfs://10.51.101.57:9000/user/grid/logs"));
		//FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(LetterCountMapper.class);
		job.setReducerClass(LetterCountReducer.class);
		//当使用table作为输出的时候，不能再用reduce函数；
		//job.setCombinerClass(LetterCountReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TableOutputFormat.class);
		//job.setNumReduceTasks(3);
		
		
		//FileOutputFormat.setCompressOutput(job, true);
		//对输出进行压缩；
		//FileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);
		boolean status=job.waitForCompletion(true);
		if(status){
			LOG.info("ID : "+job.getJobID().toString()+" ,JOB name:"+ job.getJobName()+" 已经完成");
		}else{
			LOG.info(job.getJobName()+" 失败，请检查日志！");
		}
		
	}
	
	public static void creatTable(String name) throws IOException{
		HTableDescriptor htd=new HTableDescriptor(name);
		HColumnDescriptor col=new HColumnDescriptor("content");
		htd.addFamily(col);
		Configuration conf=HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum","10.51.101.57,10.51.101.58,10.51.101.59");
		conf.set("hbase.zookeeper.property.clientPort","2181");
		HBaseAdmin hadmin=new HBaseAdmin(conf);
		if(hadmin.tableExists(name)){
			LOG.info("创建的表已经存在，删除之后再重建！！");
			hadmin.disableTable(name);
			hadmin.deleteTable(name);
			hadmin.createTable(htd);
			
		}else{
			LOG.info("创建新表：！！"+name);
			hadmin.createTable(htd);
		}
	}
public static Configuration init(){
		Configuration conf=new 	Configuration();
		//conf.set("mapred.job.tracker", "10.51.101.57:9001");  
		//conf.set("fs.default.name","GRIS-PT57:9000");
		//conf.setBoolean("mapreduce.app-submission.cross-platform", true);
	    //String flag=conf.get("mapreduce.app-submission.cross-platform");
	    //conf.set("mapred.job.tracker", "10.51.101.57:9001");
	   // System.out.println(flag);
 	    System.out.println(conf.size());
	    return conf;
}
}

	

	

