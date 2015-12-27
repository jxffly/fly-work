package com.ygsofet.test;

import java.util.Random;

public class TestPI {
	public static void main(String[] args) {
		Random rand=new Random();
		float total=100000;
		long inner=0;
		float x=0,y=0;
		boolean isIN=false;
		for (int i = 0; i < 100000		; i++) {
			x=rand.nextFloat();
			y=rand.nextFloat();
			isIN=isBellow(x, y);
			System.out.println("x="+x+" y="+y);
			if(isIN){
				inner++;
			}
			
		}
		System.out.println(inner*4/total);
	}
	public static boolean isBellow(float x,float y){
		if(Math.sqrt(x*x+y*y)>=1){
			return false;
		}else {
			return true;
		}
	}

}
