package com.hadoop.counter;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.hadoop.temperature.NewTempMapper.Temp;

public class GetCounter extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
		String jobID="job_201505200939_0001";
		JobClient jobClient=new JobClient(new JobConf(getConf()));
		RunningJob job=jobClient.getJob(JobID.forName(jobID));
		if(job==null){
			System.err.println("No job with ID:"+jobID+"found");
			return -1;
		}
		Counters  counter=job.getCounters();
		long wrong=counter.getCounter(Temp.WRONG);
		long total=counter.getCounter(Task.Counter.MAP_INPUT_RECORDS);
		System.out.println("错误的数据的百分比是："+100.0*wrong/total);
		return 0;
	}
	public static void main(String[] args) throws Exception {
		int exitCode=ToolRunner.run(new GetCounter(), args);
		System.exit(exitCode);
	}
}
