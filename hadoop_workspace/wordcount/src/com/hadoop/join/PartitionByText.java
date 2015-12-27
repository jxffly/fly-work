package com.hadoop.join;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class PartitionByText  extends Partitioner<DefineModel, Text>{

	@Override
	public int getPartition(DefineModel key, Text value, int numPartitions) {
		// TODO Auto-generated method stub
		return (key.getTextKey().hashCode()&Integer.MAX_VALUE%numPartitions);
	}

}
