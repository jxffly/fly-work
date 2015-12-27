package com.hadoop.test.mapreduce;

import java.util.Map.Entry;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class ConfigurationWriter extends Configured implements Tool{
	static{
		Configuration.addDefaultResource("hdfs-default.xml");
		Configuration.addDefaultResource("hdfs-site.xml");
		Configuration.addDefaultResource("mapred-defalut.xml");
		Configuration.addDefaultResource("mapred-site.xml");

	}
	@Override
	public int run(String[] as) throws Exception {
		Configuration conf =new Configuration();
		for(Entry<String, String> entry:conf){
			System.out.printf("%s=%s\n",entry.getKey(),entry.getValue());
		}
		return 0;
	}
	public static void main(String[] args) throws Exception {
		int exitCode=ToolRunner.run(new ConfigurationWriter(),args);
		System.exit(exitCode)
		;
		
	}
}
