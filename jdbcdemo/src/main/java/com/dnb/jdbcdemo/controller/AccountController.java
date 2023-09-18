package com.dnb.jdbcdemo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountStatusException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountTypeException;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidDateException;
import com.dnb.jdbcdemo.exceptions.InvalidGovernmentIdException;
import com.dnb.jdbcdemo.exceptions.InvalidIdException;
import com.dnb.jdbcdemo.exceptions.InvalidNameException;
import com.dnb.jdbcdemo.exceptions.InvalidValueException;
import com.dnb.jdbcdemo.payload.request.AccountRequest;
import com.dnb.jdbcdemo.service.AccountService;
import com.dnb.jdbcdemo.utils.RequestToEntityMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	RequestToEntityMapper mapper;
	
	
	
	
	@GetMapping("/aid/{accountId}")// should help us get specific account details
	public ResponseEntity<?> getAccountById(@PathVariable("accountId") String accountId) throws InvalidNameException, InvalidDateException, InvalidIdException, InvalidAccountTypeException, InvalidValueException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException, IdNotFoundException {
		java.util.Optional<Account> optional = accountService.getAccountById(accountId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
//			Map<String,String> map = new HashMap<>();
//			map.put("message", "id not found");
//			map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
//			ResponseEntity<?> responseEntity = new ResponseEntity(map, HttpStatus.NOT_FOUND);
//			return responseEntity; // gives clear message and not just httpstatus
			
	//		return responseEntity.notFound().build(); 
			throw new IdNotFoundException("invalid id");
		}
	}
	
	@GetMapping("/cn/{contactNumber:^[0-9]{10}$}")// should help us get specific account details
	public ResponseEntity<?> getAccountByContactNumber(@PathVariable("contactNumber") String contactNumber) throws InvalidContactNumberException{
		java.util.Optional<Account> optional = accountService.getAccountByContactNumber(contactNumber);
		
		if(optional.isPresent()) {
			System.out.println("hello from abhi");
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new InvalidContactNumberException("invalid contact number");
		}
	}
	
	
	@GetMapping("/allAccounts/{contactNumber}")
	public ResponseEntity<?> getAllAccountsByContactNumber(@PathVariable("contactNumber") String contactNumber) {
		List<Account> accounts = new ArrayList<>();
		accounts = accountService.getAllAccountsByContactNumber(contactNumber);
		return ResponseEntity.ok(accounts);
	}
	
	@GetMapping("/allAccounts")
	public ResponseEntity<?> getAllAccounts() throws InvalidNameException, InvalidDateException, InvalidIdException, InvalidAccountTypeException, InvalidValueException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException {
		List<Account> accounts = new ArrayList<>();
		accounts = accountService.getAllAccounts();
		return ResponseEntity.ok(accounts);
		
	}
	
	
	
	@DeleteMapping("/{accountId}")
	public ResponseEntity<?> deleteAccountById(@PathVariable("accountId") String accountId) throws IdNotFoundException {
		if(accountService.deleteAccountById(accountId)) {
			return ResponseEntity.noContent().build();
		}
		else
			throw new IdNotFoundException("id not found");
			
	}
	
	
	@PostMapping("/create") //@RequestMapping + post method - from spring 4.3.x
	public ResponseEntity<?> createAccount( @Valid 
			@RequestBody AccountRequest account) {
		//return ResponseEntity.ok(mapper.getAccountEntity(account));
		System.out.println("checking");
		Account acc = mapper.getAccountEntity(account);
		
		try {
			Account account2 = accountService.createAccount(acc);
			return new ResponseEntity(account2, HttpStatus.CREATED);
			
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	
	
	
}
