package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidGovernmentIdException;
import com.dnb.jdbcdemo.exceptions.InvalidIdException;
import com.dnb.jdbcdemo.exceptions.InvalidNameException;

public interface CustomerService {
	public Customer createCustomer(Customer customer) throws IdNotFoundException;

	public Optional<Customer> getCustomerById(int customerID) throws InvalidIdException, InvalidNameException, InvalidContactNumberException, InvalidAddressException, InvalidGovernmentIdException;

	public boolean deleteCustomerById(int customerID) throws InvalidIdException;

	public List<Customer> getAllCustomers() throws InvalidIdException, InvalidNameException, InvalidContactNumberException, InvalidAddressException, InvalidGovernmentIdException;
	
	public Optional<Customer> getCustomerByCustomerContactNumber(String customerContactNumber);
	
	public List<Customer> getAllCustomersByCustomerContactNumber(String customerContactNumber);
	
}
