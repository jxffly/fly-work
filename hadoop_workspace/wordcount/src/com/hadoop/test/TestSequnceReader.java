package com.hadoop.test;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.ReflectionUtils;

public class TestSequnceReader {
	public static void main(String[] args) throws IOException {
		String uri="hdfs://10.51.101.57:9000/user/grid/stream/output";
		Configuration conf=new Configuration();
		FileSystem fs=FileSystem.get(URI.create(uri),conf);
		Path path=new Path(uri);
		SequenceFile.Reader reader=null;
		try {
			reader=new SequenceFile.Reader(fs, path, conf);
			Writable key=(Writable)ReflectionUtils.newInstance(reader.getKeyClass(), conf);
			Writable value=(Writable)ReflectionUtils.newInstance(reader.getValueClass(), conf);
			long position=reader.getPosition();
			while (reader.next(key, value)) {
				String syncSeen=reader.syncSeen()?"*":"";
				System.out.printf("[%s%s]\t%s\t%s\n",position,syncSeen,key,value);
				position=reader.getPosition();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			IOUtils.closeStream(reader);
			
		}
	}

}
