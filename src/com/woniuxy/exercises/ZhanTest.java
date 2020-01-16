package com.woniuxy.exercises;

public class ZhanTest {

public static void main(String[] args) {
		
	Zhan<String> zhan = new Zhan<String>();
		zhan.add("1");
		zhan.add("2");
		zhan.add("3");
		zhan.add("4");
		zhan.add("5");
		
		for(int i=0;i<zhan.getCount();i++){
			
			System.out.println(zhan.get(i));
			
		}
	}
	
}
