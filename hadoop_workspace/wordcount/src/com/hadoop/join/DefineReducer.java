package com.hadoop.join;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DefineReducer extends Reducer<DefineModel, Text, Text, Text>{
	
	@Override	
	public void reduce(DefineModel key,Iterable<Text>values,Context context) throws IOException,InterruptedException{
		String productID=values.iterator().next().toString();
		while(values.iterator().hasNext()){
			String payID=values.iterator().next().toString();
			context.write(new Text(productID), new Text(payID));
		}
	}
			
		}

