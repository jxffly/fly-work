package com.hadoop.searchcombine;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class PartitionByText  extends Partitioner<DefineModel, IntWritable>{

	@Override
	public int getPartition(DefineModel key, IntWritable value, int numPartitions) {
		// TODO Auto-generated method stub
		return (key.getTextKey().hashCode()&Integer.MAX_VALUE%numPartitions);
	}

}
