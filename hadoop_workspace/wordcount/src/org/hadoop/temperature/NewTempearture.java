package org.hadoop.temperature;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class NewTempearture {
	public static void main(String[] args) throws Exception{
		if(args.length!=2){
			System.err.println("NO INPUT OUT");
			System.exit(-1);
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
		
		System.exit(job.waitForCompletion(true)?0:1);
		
	}

}
