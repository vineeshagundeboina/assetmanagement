package com.csv.csvfilereading.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {

	
   @Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
//	private String accountName;
//	
//	private String accountCode;
//	
//	private double balance;
//
//	private boolean isSubAccount;
//	
//	private String parentAccount;
//	
//	private String accountDescription;
   
   
   
   private String accountName;
	
	private String accountCode;
	
	private String balance;

	private String isSubAccount;
	
	private String parentAccount;
	
	private String accountDescription;
}
