package com.hadoop.combine;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

public class LetterCountReducer extends TableReducer<Text, IntWritable, NullWritable> {
		private static final Log LOG = LogFactory.getLog(LetterCountReducer.class);
		private IntWritable result = new IntWritable();
		@Override
		public void reduce(Text key, Iterable<IntWritable> values,
				Context context)
				throws IOException,InterruptedException {
			 	int sum = 0;
			 	LOG.info("调用reduce函数开始");
	            for (IntWritable val : values) {
	                sum += val.get();
	            }
	            result.set(sum);
	            Put put=new Put(Bytes.toBytes(key.toString()));
	            put.add(Bytes.toBytes("content"), Bytes.toBytes("count"), Bytes.toBytes(String.valueOf(sum)));
	            context.write(NullWritable.get(), put);	
		}
	
}
