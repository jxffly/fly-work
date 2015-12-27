package com.ygsofet.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Data {
	public static void main(String[] args) throws IOException {
		File f=new File("C:/Users/jinxiaofei/Desktop/数据/data3.txt");
		Random ran=new Random();
		FileWriter fw=new FileWriter(f);
		String str="";
		int year=0;
		int temp=0;
		for (int i = 0; i < 10000; i++) {
			year=ran.nextInt(100)+1900;
			temp=ran.nextInt(100);
			if(ran.nextInt(100)%2==0){
				str=year+"+wrong"+temp;
			}else {
				str=year+"-wrong"+temp;
			}
			fw.write(str+"\r\n");
			
		}
		fw.close();
	
	}

}
