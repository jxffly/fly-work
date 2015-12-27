package com.ygsofet.test;

public class TestSame {
	public static void main(String[] args) {
		String a="智能电力";
		String b="的智能";
		boolean isSame=false;
		for(int i=0;i<a.length()-1;i++){
			String splita=a.substring(i,i+2);
			if(b.indexOf(splita)>=0){
				isSame=true;
			}
		}
		for(int j=0;j<b.length()-1;j++){
			String splitb=b.substring(j,j+2);
			if(a.indexOf(splitb)>=0){
				isSame=true;
			}
		}
		System.out.println(isSame);
	}

}
