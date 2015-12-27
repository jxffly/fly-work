package com.hadoop.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

public class TableOperator {
	private static final Logger LOG=Logger.getLogger(TableOperator.class);
	
	  /** 
     *  
     */  
    private static final long serialVersionUID = 1L;  
    private static HBaseAdmin admin=HBaseConnector.getHBaseAdmin();
    private static Configuration conf=HBaseConnector.getConfiguration();
    private static String INFO="";
       
    
        public String creatTable(String tableName, String[] familys) throws Exception {  
            if (admin.tableExists(tableName)) {  
                  
                return "{\"responseData\":\"table already exist\"}";  
                  
            } else {  
                HTableDescriptor tableDesc = new HTableDescriptor(tableName);  
                for(int i=0; i<familys.length; i++){  
                    tableDesc.addFamily(new HColumnDescriptor(familys[i]));  
                }  
                admin.createTable(tableDesc);  
                INFO="create table " + tableName + " ok.";
                return "{\"responseData\":\""+INFO+"\"}";
   
            }   
        }  
          
        /** 
         * 删除表 
         */  
        public  String deleteTable(String tableName) throws Exception {  
           
        	try {    
               admin.disableTable(tableName);//删除表前应当丢弃该表  
               admin.deleteTable(tableName); 
               INFO="delete table " + tableName + " ok.";
               return "{\"responseData\":\""+INFO+"\"}";  
           } catch (MasterNotRunningException e) {  
               e.printStackTrace();  
           } catch (ZooKeeperConnectionException e) {  
               e.printStackTrace();  
           }
        	   INFO="delete table " + tableName + " false.";
        	   return "{\"responseData\":\""+INFO+"\"}";  
           
			  
        }  
           
        /** 
         * 插入一行记录 
         */  
        public String addRecord (String tableName, String rowKey, String family, String qualifier, String value)  
                throws Exception{  
            try {  
                HTable table = new HTable(conf, tableName);  
                Put put = new Put(Bytes.toBytes(rowKey));  
                put.add(Bytes.toBytes(family),Bytes.toBytes(qualifier),Bytes.toBytes(value));  
                table.put(put);  
                INFO="insert recored " + rowKey + " to table " + tableName +" ok.";  
                return "{\"responseData\":\""+INFO+"\"}";  
            } catch (IOException e) {  
                e.printStackTrace();  
                INFO="insert recored " + rowKey + " to table " + tableName +" false.";  
            }
			 return "{\"responseData\":\""+INFO+"\"}"; 
        }  
       
        /** 
         * 删除一行记录 
         */  
        public  String delRecord (String tableName, String rowKey) throws IOException{  
            HTable table = new HTable(conf, tableName);  
            List <Delete>list = new ArrayList<Delete>();  
            Delete del = new Delete(rowKey.getBytes());  
            list.add(del);  
            table.delete(list);  
            
            INFO=getAllRecord(tableName);  
            return INFO;
        }  
           
        /** 
         * 查找一行记录 
         */  
        public  String getOneRecord (String tableName, String rowKey) throws IOException{  
            HTable table = new HTable(conf, tableName);  
            Get get = new Get(rowKey.getBytes());  
            Result rs = table.get(get);  
            List<Map<String, String>> mapList=new ArrayList<Map<String,String>>();
            
            
            INFO=null;
            for(KeyValue kv : rs.raw()){ 
            	Map<String,String> map=new HashMap<String, String>();
            	map.put("rowkey",new String(kv.getRow()));
            	map.put("family", new String(kv.getFamily()));
            	map.put("Qualifier".toLowerCase(), new String(kv.getQualifier()));
            	map.put("timestamp", kv.getTimestamp()+"");
            	map.put("value", new String(kv.getValue()));
            	mapList.add(map);
            	System.out.println(map.get("rowkey")+" "+map.get("family")+" "+map.get("Qualifier")+" "+map.get("timestamp")+" "+map.get("value"));
            }  
            INFO=JSONUtil.toJson(mapList);
            return "{\"responseData\":\""+INFO+"\"}";
        }  
           
        /** 
         * 显示所有数据 
         */  
        public  String getAllRecord (String tableName) {  
            try{  
                 HTable table = new HTable(conf, tableName);  
                 Scan s = new Scan();  
                 ResultScanner ss = table.getScanner(s);  
                 List<Map<String, String>> mapList=new ArrayList<Map<String,String>>();
                 INFO=null;
                for(Result r:ss ){
                	 for(KeyValue kv : r.raw()){ 
                		 Map<String,String> map=new HashMap<String, String>();
                      	map.put("rowkey",new String(kv.getRow()));
                    	map.put("family", new String(kv.getFamily()));
                    	map.put("Qualifier".toLowerCase(), new String(kv.getQualifier()));
                    	map.put("timestamp", kv.getTimestamp()+"");
                    	map.put("value", new String(kv.getValue()));
                      	mapList.add(map);
                      	System.out.println(new String(kv.getRow())+" "+new String(kv.getFamily())+" "+kv.getTimestamp()+" "+new String(kv.getValue()));
                      }  
                }
                 INFO=JSONUtil.toJson(mapList);
                 return "{\"responseData\":\""+INFO+"\"}";
            } catch (IOException e){  
                e.printStackTrace();  
                INFO="some things is wrong";
            }  
            return "{\"responseData\":\""+INFO+"\"}";
        }  
         
      
  
}
