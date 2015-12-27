package com.hadoop.combine;

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
	public static void main(String[] args) throws Exception{
		String table="wordcount";
		Configuration conf=new Configuration();
		conf.set(TableOutputFormat.OUTPUT_TABLE,table);
		creatTable(table);
		Job job=new Job(conf,"hbase createTable");
		job.setJarByClass(LetterCountMapper.class);
		FileInputFormat.addInputPath(job, new Path("hdfs://10.51.101.57:9000/user/grid/logs"));
		//FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(LetterCountMapper.class);
		job.setReducerClass(LetterCountReducer.class);
		job.setCombinerClass(LetterCountCombine.class);
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
		System.exit(job.waitForCompletion(true)?0:1);
		
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

}

	

	

