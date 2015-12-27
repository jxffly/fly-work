package com.hadoop.web;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class TestFastJson {
public static void main(String[] args) {
	String jsonStr="[{\"name\":\"userExperience\",\"status\":\"true\"}]"; 
	String jsonStr2="{\"name\":\"userExperience\",\"status\":\"true\"}";
	List<HashMap<String, Object>> mapList=new ArrayList<HashMap<String, Object>>();
	HashMap<String, Object> map=JSON.parseObject(jsonStr2,new TypeReference<HashMap<String, Object>>() {
    });
	System.out.println(map.get("name"));
	mapList = JSON.parseObject(jsonStr,
	          new TypeReference<List<HashMap<String, Object>>>() {
	          });
	for(HashMap<String,Object> configData : mapList){
	    String name = configData.get("name").toString();
	    String status=configData.get("status").toString();
	    System.out.println("name:" + name);  
	    System.out.println("status:" + status);  
	}  
}
}

