package com.csv.csvfilereading.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csv.csvfilereading.pojo.Account;


@Repository
public interface AccountRepo extends JpaRepository<Account, Integer>{

}
