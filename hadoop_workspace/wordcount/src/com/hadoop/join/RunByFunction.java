package com.hadoop.join;

import java.io.IOException;

public class RunByFunction {
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		String Path[]={"hdfs://10.51.101.57:9000/user/grid/join/input/action.txt" ,
						"hdfs://10.51.101.57:9000/user/grid/join/input/alipay.txt",
						"hdfs://10.51.101.57:9000/user/grid/join/output" };
		DefineMain.RunHadoop(Path);
	}
	

}
