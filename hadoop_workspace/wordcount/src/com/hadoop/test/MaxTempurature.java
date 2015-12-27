package com.hadoop.test;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class MaxTempurature {
	static class MaxTemperatureMapper extends MapReduceBase
	implements Mapper<LongWritable, Text, Text, IntWritable>{
		private static final int MISSING=9999;

		@Override
		public void map(LongWritable key, Text value,
				OutputCollector<Text, IntWritable> output, Reporter reporter)
				throws IOException {
			// TODO Auto-generated method stub
			String line=value.toString();
			String year=line.substring(0,4);
			int airTemperature=MISSING;
			if(line.charAt(4)=='+'){
				airTemperature=Integer.parseInt(line.substring(5, 7));
			}else {
				airTemperature=Integer.parseInt(line.substring(4, 7));
			}
			if(airTemperature!=MISSING){
				output.collect(new Text(year), new IntWritable(airTemperature));
			}
			
		}}
	
	static class MaxTemperatureReduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>
	{
		@Override
		public void reduce(Text key, Iterator<IntWritable> values,
				OutputCollector<Text, IntWritable> output, Reporter reportor)
				throws IOException {
			// TODO Auto-generated method stub
			int maxValue=Integer.MIN_VALUE;
			while (values.hasNext()) {
				maxValue=Math.max(maxValue, values.next().get());
			}
			output.collect(key, new IntWritable(maxValue));	
		}
	}
	public static void main(String[] args) {
		if(args.length!=2){
			System.err.println("NO INPUT OUT");
			System.exit(-1);
		}
		JobConf conf=new JobConf(MaxTempurature.class);
		conf.setJobName("Max Temperature");
		FileInputFormat.addInputPath(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		conf.setMapperClass(MaxTemperatureMapper.class);
		conf.setReducerClass(MaxTemperatureReduce.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		try {
			JobClient.runJob(conf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
