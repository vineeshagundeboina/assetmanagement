package com.csv.csvfilereading.controller;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> al=new java.util.ArrayList<>();
		
		al.add(1);
		al.add(3);
		al.add(5);
		al.add(2);
		System.out.println(al);
	//	al.sort(null);
		
		Collections.sort(al);
		System.out.println();
		System.out.println(al);
		
		System.out.println();
		
		Collections.sort(al,Collections.reverseOrder());
		System.out.println("desc : "+al);
		
		
		for(int i=0;i<al.size();i++) {
			
		}

	}

}
