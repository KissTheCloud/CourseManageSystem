package com.ts.coursework.util;

import java.util.Random;

public class CodeCreater {
	public static String createCode(int length){
		StringBuilder sb=new StringBuilder();
		Random random=new Random();
		for(int i=0;i<length;i++) {
			int temp=random.nextInt(34)+1;
			if(temp>9) {
				temp+=7;
			}
			sb.append((char)('0'+temp));
		}
		return sb.toString();
	}
//	public static void main(String[] args) {
//		for(int i=0;i<100;i++) {
//			System.out.println(createCode(6));
//		}
//	}
}
