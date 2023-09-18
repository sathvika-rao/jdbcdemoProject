package com.dnb.jdbcdemo.utils;

import org.springframework.stereotype.Component;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.payload.request.AccountRequest;
import com.dnb.jdbcdemo.payload.request.CustomerRequest;

@Component //spring creates this class's object automatically
public class RequestToEntityMapper {
	//give request object and give back entity object
	public Account getAccountEntity(AccountRequest accountRequest) {
		Account account = new Account();
		account.setAccountHolderName(accountRequest.getAccountHolderName());
		account.setAccountType(accountRequest.getAccountType());
		account.setBalance(accountRequest.getBalance());
		account.setAddress(accountRequest.getAddress());
		account.setContactNumber(accountRequest.getContactNumber());
		account.setDob(accountRequest.getDob());
		//account.setCustomerID(accountRequest.getCustomerID());
		Customer customer = new Customer();
		customer.setCustomerID(accountRequest.getCustomerID());;
		account.setCustomer(customer);
		return account;
	}
	
	public Customer getCustomerEntity(CustomerRequest customerRequest) {
		Customer customer = new Customer();
		customer.setCustomerName(customerRequest.getCustomerName());
		customer.setCustomerAddress(customerRequest.getCustomerAddress());
		customer.setCustomerContactNumber(customerRequest.getCustomerContactNumber());
		customer.setCustomerPAN(customerRequest.getCustomerPAN());
		customer.setCustomerUUID(customerRequest.getCustomerUUID());
		return customer;
	}
}
