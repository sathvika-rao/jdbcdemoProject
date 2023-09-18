package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

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

public interface AccountService {
	public Account createAccount(Account account) throws IdNotFoundException;//, InvalidIdException, InvalidNameException, InvalidContactNumberException, InvalidAddressException, InvalidGovernmentIdException;
	
	public Optional<Account> getAccountById(String accountId) throws InvalidNameException, InvalidDateException, InvalidIdException, InvalidAccountTypeException, InvalidValueException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException;
	
	public boolean deleteAccountById(String accountId);
	
	public List<Account> getAllAccounts() throws InvalidNameException, InvalidDateException, InvalidIdException, InvalidAccountTypeException, InvalidValueException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException;
	
	public Optional<Account> getAccountByContactNumber(String contactNumber);
	
	public List<Account> getAllAccountsByContactNumber(String contactNumber);
	
	
}
