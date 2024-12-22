package com.csv.csvfilereading.controller;

import java.util.HashSet;
import java.util.Set;

class Employee1 {
	private String name;

	
	 Employee1 (String name) {
		    this.name = name;

	 }


	public static void main(String[] args) {
		
		Set<Employee1> employees = new HashSet<>();
		employees.add(new Employee1("Jon"));
		employees.add(new Employee1("Jon"));
		employees.add(new Employee1("Ron"));
		employees.add(new Employee1("Jon"));

		System.out.println(employees.size());
	}



	

  

	public String getName() {
		return name;
	}



}

