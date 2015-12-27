package com.hadoop.join;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class DefineMain {
	public static void RunHadoop(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		Configuration conf = new Configuration();
    	
		String otherArgs[] = new GenericOptionsParser(conf,args).getRemainingArgs();
		if (otherArgs.length != 3) {
			System.err.println("Usage: join <in><in> <out>");
			System.exit(2);
		}
        Job job = new Job(conf, "join");
        job.setJarByClass(DefineMain.class);
        
        
        job.setMapperClass(DefineMapper.class);
        job.setReducerClass(DefineReducer.class);
        
        job.setMapOutputKeyClass(DefineModel.class);
        job.setMapOutputValueClass(Text.class);
        
        job.setSortComparatorClass(TextIntComparator.class);
        job.setGroupingComparatorClass(TextCompare.class);
        job.setPartitionerClass(PartitionByText.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        
        
        
        
        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileInputFormat.addInputPath(job, new Path(otherArgs[1]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[2]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
		
	}

}
