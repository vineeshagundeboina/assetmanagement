package com.csv.csvfilereading.controller;

import java.io.File;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csv.csvfilereading.service.AccountService;
import com.opencsv.exceptions.CsvValidationException;

import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/account")
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

//	@PostMapping("/create")
//	public ResponseEntity<?> create(@RequestBody Account account) throws CsvValidationException, NumberFormatException{
//		return ResponseEntity.ok(accountService.saveCSVDataToDatabase("/Downloads"));
//	}

//	@PostMapping("/bulk/create")

//	@Operation(summary = "Bulk Invoice creation")

//	public ResponseEntity bulkCreate(@RequestParam("file") MultipartFile multipartFile, HttpServletResponse response) {
// 
//		String originalFilename = multipartFile.getOriginalFilename();
//
//		System.out.println("originalFilename: "+originalFilename);
//
//		if (Objects.nonNull(originalFilename) && !originalFilename.isEmpty()) {
//
//			if (originalFilename.contains(".csv")) {
//
//				String filename = "invoice_import_result.csv";
// 
//				response.setContentType("text/csv");
//
//				response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");
//
//				boolean isSuccess = accountService.processCsv(multipartFile, response);
//
//				if (isSuccess) {
//
//					return ResponseEntity.ok().build();
//
//				} else {
//
//					return ResponseEntity.accepted().build();
//
//				}
//
//			} else {
//
//				return ResponseEntity.unprocessableEntity().build();
//
//			}
//
//		} else {
//
//			return ResponseEntity.unprocessableEntity().build();
//
//		}
//
////	}

	
	
	
	
	@PostMapping("/upload-csv")
	public String uploadCSV(@RequestParam("file") MultipartFile file)
			throws CsvValidationException, NumberFormatException {
		if (file.isEmpty()) {
			return "Please upload a valid CSV file.";
		}

		try {
			// Save the file locally
	            File localFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + file.getOriginalFilename());
	            file.transferTo(localFile);

				System.out.println(localFile.getAbsolutePath());

			// Process the CSV file
			accountService.saveCSVDataToDatabase(localFile.getAbsolutePath());

			return "File uploaded and data saved to database successfully.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error occurred while processing the file.";
		}
	}
	
}