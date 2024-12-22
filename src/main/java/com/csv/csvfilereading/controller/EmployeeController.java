package com.csv.csvfilereading.controller;

import java.sql.Array;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csv.csvfilereading.pojo.Employee;
import com.csv.csvfilereading.repo.EmployeeRepo;


@RequestMapping("/employee")
@RestController

public class EmployeeController {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	//int[] array=new int[4];
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Employee>> findAll(){
		return ResponseEntity.ok(employeeRepo.findAll());
		
	}
}
