package com.hadoop.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JSONUtil
{
	public static String toJson(Object obj)
	{
		return JSON.toJSONString(obj);
 	}
	public static List<HashMap<String, Object>> json2List(String json){
		
		return JSON.parseObject(json,
		          new TypeReference<List<HashMap<String, Object>>>() {
		          });
		
	}
	public static HashMap<String, Object> json2Map(String json){
		return JSON.parseObject(json,
		          new TypeReference<HashMap<String, Object>>() {
		          });
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Map<String,String> map=new HashMap<String, String>();
		map.put("aa","bb");
		String jsonStr="[{\"name\":\"middleware\",\"status\":\"true\",\"menus\":[\"\"]},{\"name\":\"userExperience\",\"status\":\"true\",\"menus\":[\"业务系统用户体验对比\",\"业务系统体验分析\"]}]"; 
		List<HashMap<String, Object>> mapList=new ArrayList<HashMap<String,Object>>();
		mapList=json2List(jsonStr);
		for(HashMap<String,Object> configData : mapList){
		    String name = configData.get("name").toString();
		    String status=configData.get("status").toString();
		    List<String> menus=(List<String>)configData.get("menus");
		    System.out.println("name:" + name);  
		    System.out.println("status:" + status);
		    System.out.println("menus:" + menus);  
		}  
		List<Map<String,String>> listMap=new ArrayList<Map<String,String>>();
		
		for(int i=0;i<5;i++){
			Map<String,String> hash=new HashMap<String, String>();
			hash.put("name", "test"+i);
			hash.put("age", "age"+i);
			hash.put("value", "value"+i);
			listMap.add(hash);
			System.out.println(hash.get("name"));
		}
		System.out.println(JSONUtil.toJson(listMap));
		
	

	}
}
