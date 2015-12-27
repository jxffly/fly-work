package org.hadoop.temperature;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.Logger;



public class NewTempearture {
	private final static Logger LOG=Logger.getLogger(NewTempearture.class);
	public static void main(String[] args) throws Exception{
		Configuration conf=new Configuration();
		if(args.length!=2){
			System.err.println("NO INPUT OUT");
			System.exit(-1);
		}
		FileSystem fs=FileSystem.get(conf);
		if(fs.exists(new Path(args[1]))){
			LOG.info("目录存在，先删除");
			fs.delete(new Path(args[1]), true);
		}
		Job job=new Job();
		job.setJarByClass(NewTempMapper.class);
		job.setJobName("new  temperature");
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(NewTempMapper.class);
		job.setReducerClass(NewTemperatureReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.waitForCompletion(true);
		
	}

}
