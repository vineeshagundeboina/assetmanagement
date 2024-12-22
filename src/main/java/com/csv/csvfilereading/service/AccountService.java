package com.csv.csvfilereading.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.csv.csvfilereading.pojo.Account;
import com.csv.csvfilereading.repo.AccountRepo;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class AccountService {

	@Autowired
	private AccountRepo accountRepo;

	@Transactional
	public String saveCSVDataToDatabase(String filePath) throws CsvValidationException, NumberFormatException {
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			String[] nextLine;
			//reader=reader.withSkipLines(1).build();
			//CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
			while ((nextLine = reader.readNext()) != null) {
				Account account = new Account();
				account.setAccountName(nextLine[0]); // Assuming column1 is the first column
				account.setAccountCode(nextLine[1]);
				
				
				
				System.out.println("balance : "+nextLine[2]);
				// Assuming column2 is the second column
//				account.setBalance(Long.valueOf(nextLine[2]));
//				account.setSubAccount(Boolean.valueOf(nextLine[3]));
				
				
				account.setBalance(nextLine[2]);
				account.setIsSubAccount(nextLine[3]);
				
				account.setParentAccount(nextLine[4]);

				account.setAccountDescription(nextLine[5]);

				// Set other fields as needed

				accountRepo.save(account);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";

	}

	public boolean processCsv(MultipartFile file, HttpServletResponse response) {
		// TODO Auto-generated method stub

		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

			/*
			 * 
			 * Skipping the first row to avoid processing the headers
			 * 
			 */

			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
			System.out.println("csvReader : "+csvReader);

			String[] record;

			while ((record = csvReader.readNext()) != null) {

				System.out.println(record[0]);

			}

		} catch (Exception e) {

			e.printStackTrace();

			// throw new UnProcessableException("Error while processing CSV file " +
			// e.getMessage());

		}
		return true;

	}

}
