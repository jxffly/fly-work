package com.hadoop.hbasse;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class ExampleClient {
	public static void main(String[] args) throws IOException {
		Configuration config=HBaseConfiguration.create();
		//config.set("hbase.master", "10.51.101.57:60000");
		HBaseAdmin admin=new HBaseAdmin(config);
		HTableDescriptor htd=new HTableDescriptor("test");
		HColumnDescriptor hcd=new HColumnDescriptor("data");
		htd.addFamily(hcd);
		admin.createTable(htd);
		byte [] tablename=htd.getName();
		HTableDescriptor[]tables=admin.listTables();
		if(tables.length!=1&&Bytes.equals(tablename, tables[0].getName())){
			throw new IOException("failed to create table");
		}
		HTable table=new HTable(config, tablename);
		byte[]row1=Bytes.toBytes("row1");
		Put p1=new Put(row1); 
		byte[]databytes=Bytes.toBytes("data");
		p1.add(databytes, Bytes.toBytes("name"),Bytes.toBytes("zhangsan"));
		table.put(p1);
		Get g=new Get(row1);
		Result result=table.get(g);	
		System.out.println("Get:"+result);
		Scan scan=new Scan();
		ResultScanner scanner=table.getScanner(scan);
		try {
			for(Result scannerresult:scanner){
				System.out.println("scan:"+scannerresult);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			scanner.close();
		}
		admin.disableTable(tablename);
		admin.deleteTable(tablename);
		
	}
	

}
