package com.csv.csvfilereading.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csv.csvfilereading.pojo.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
