package com.hadoop.web;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;
 
/**
 * @author a01513
 *
 */
public class HBaseConnector {
     
    //private static final String QUOREM = "10.51.101.57,10.51.101.58,10.51.101.59";
    //private static final String CLIENT_PORT = "2181";
    private static HBaseAdmin admin;
    private static Configuration conf;
     
     
    public static HBaseAdmin getHBaseAdmin(){
        getConfiguration();
        try {
            admin = new HBaseAdmin(conf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin; 
    }
     
    public static Configuration getConfiguration(){
        if(conf == null){
            conf = HBaseConfiguration.create();  
        }
        return conf;
       
    }
}