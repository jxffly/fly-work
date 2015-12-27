package com.hadoop.test;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.util.ReflectionUtils;

public class TestCompress {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		String codecClass="d:/data.txt";
		Class<?> codeClass=Class.forName(codecClass);
		Configuration conf=new Configuration();
		CompressionCodec codec=(CompressionCodec)ReflectionUtils.newInstance(codeClass, conf);
		CompressionOutputStream out=codec.createOutputStream(System.out);
		IOUtils.copyBytes(System.in, out, 4096,false);
		out.finish();
	}

}
