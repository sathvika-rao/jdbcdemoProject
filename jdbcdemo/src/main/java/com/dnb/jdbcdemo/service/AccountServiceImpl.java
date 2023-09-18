package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
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
import com.dnb.jdbcdemo.repo.AccountRepository;
import com.dnb.jdbcdemo.repo.CustomerRepository;

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	//@Qualifier("accountRepo2Impl")
	//AccountRepository accountRepository;
	AccountRepository accountRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Account createAccount(Account account) throws IdNotFoundException//, InvalidIdException, InvalidNameException,
			//InvalidContactNumberException, InvalidAddressException, InvalidGovernmentIdException 
	{
		Optional<Customer> customer = customerRepository.findById(account.getCustomer().getCustomerID());
		// TODO Auto-generated method stub
		if(customer.isPresent())
			return accountRepository.save(account);
		else
			customer.orElseThrow(() -> new IdNotFoundException("Customer Id is not valid"));
		return null;
	}

	@Override
	public Optional<Account> getAccountById(String accountId) throws InvalidNameException, InvalidDateException,
			InvalidIdException, InvalidAccountTypeException, InvalidValueException, InvalidContactNumberException,
			InvalidAddressException, InvalidAccountStatusException {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountId);
	}

	@Override
	public boolean deleteAccountById(String accountId) {
		// TODO Auto-generated method stub
		if(accountRepository.existsById(accountId)) {
			accountRepository.deleteById(accountId);
			return true;
		}
		else 
			//throw new IdNotFoundException("ID not found");
			return false;
	}

	@Override
	public List<Account> getAllAccounts() throws InvalidNameException, InvalidDateException, InvalidIdException,
			InvalidAccountTypeException, InvalidValueException, InvalidContactNumberException, InvalidAddressException,
			InvalidAccountStatusException {
		// TODO Auto-generated method stub
		return (List<Account>) accountRepository.findAll();
	}

	@Override
	public Optional<Account> getAccountByContactNumber(String contactNumber) {
		// TODO Auto-generated method stub
	
		return accountRepository.findByContactNumber(contactNumber);
	}

	@Override
	public List<Account> getAllAccountsByContactNumber(String contactNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findAllByContactNumber(contactNumber);
	}
	
	
	
	/*@Override
	public Account createAccount(Account account) throws IdNotFoundException, InvalidIdException, InvalidNameException, InvalidContactNumberException, InvalidAddressException, InvalidGovernmentIdException {
		// TODO Auto-generated method stub
		System.out.println(account.getCustomer().getCustomerID());
		Optional<Customer> optional = customerRepository.getCustomerById(account.getCustomer().getCustomerID());
		if(optional.isPresent())
		return accountRepo2Impl.createAccount(account);
		else 
			throw new IdNotFoundException("customerID not found");
	}

	@Override
	public Optional<Account> getAccountById(String accountId) throws InvalidNameException, InvalidDateException, InvalidIdException, InvalidAccountTypeException, InvalidValueException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException {
		// TODO Auto-generated method stub
		return accountRepo2Impl.getAccountById(accountId);
	}


	@Override
	public Optional<Account> deleteAccountById(String accountId) {
		// TODO Auto-generated method stub
		return accountRepo2Impl.deleteAccountById(accountId);
	}


	@Override
	public List<Account> getAllAccounts() throws InvalidNameException, InvalidDateException, InvalidIdException, InvalidAccountTypeException, InvalidValueException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException {
		// TODO Auto-generated method stub
		return accountRepo2Impl.getAllAccounts();
	}*/

}
