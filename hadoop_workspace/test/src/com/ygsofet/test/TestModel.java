package com.ygsofet.test;

import java.util.ArrayList;
import java.util.List;

public class TestModel {
	public static void main(String[] args) {
		List<model> data=new ArrayList<model>();
		data.add(new model(100, "远光"));
		data.add(new model(99, "远光"));
		data.add(new model(97, "远光"));
		
		for (model m:data) {
			System.out.println(m.getKey()+"  "+m.getValue());
		}
		
		int isCombine=0;
		for(int i=0;i<data.size();i++){
			for (int j = i+1; j < data.size(); j++) {
				if(data.get(i).getKey().indexOf(data.get(j).getKey())>=0){
					isCombine=10;
				}else if(data.get(j).getKey().indexOf(data.get(i).getKey())>=0){
					isCombine=-10;
				}else{
					isCombine=-1;
				}
				float percent=Math.min((float)data.get(i).getValue(), data.get(j).getValue())/Math.max(data.get(i).getValue(), data.get(j).getValue());
				if(percent>=0.9){
					if(isCombine==10){
						data.get(j).setKey("childletter");
					}else if(isCombine==-10){
						data.get(i).setKey("childletter");
					}
				}
			}
		}
		for (model m:data) {
			System.out.println("key : "+m.getKey()+"  value:"+m.getValue());
		}
	}

}
class model{
	private int value;
	private String key;
	
	public model(int value, String key) {
		
		this.value = value;
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}