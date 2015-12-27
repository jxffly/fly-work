package com.hadoop.test.mapreduce;

import org.apache.hadoop.conf.Configuration;

public class ConfigurationTest {
	public static void main(String[] args) {
		Configuration conf=new Configuration();
		conf.addResource("hdfs://10.51.101.57:9000/user/grid/config/configuration-1.xml");
		conf.addResource("configuration-1.xml");
		System.out.println(conf.get("size"));
	}

}
