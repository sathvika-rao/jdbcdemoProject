package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidGovernmentIdException;
import com.dnb.jdbcdemo.exceptions.InvalidIdException;
import com.dnb.jdbcdemo.exceptions.InvalidNameException;
import com.dnb.jdbcdemo.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) throws IdNotFoundException{
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> getCustomerById(int customerID) throws InvalidIdException, InvalidNameException,
			InvalidContactNumberException, InvalidAddressException, InvalidGovernmentIdException {
		return customerRepository.findById(customerID);
	}

	@Override
	public boolean deleteCustomerById(int customerID) throws InvalidIdException {
		if(customerRepository.existsById(customerID)) {
			customerRepository.deleteById(customerID);
			return true;
		}
		else
			return false;
	}

	@Override
	public List<Customer> getAllCustomers() throws InvalidIdException, InvalidNameException,
			InvalidContactNumberException, InvalidAddressException, InvalidGovernmentIdException {
		// TODO Auto-generated method stub
		return  (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomerByCustomerContactNumber(String customerContactNumber) {
		// TODO Auto-generated method stub
		return customerRepository.findByCustomerContactNumber(customerContactNumber);
	}

	@Override
	public List<Customer> getAllCustomersByCustomerContactNumber(String customerContactNumber) {
		// TODO Auto-generated method stub
		return customerRepository.findAllByCustomerContactNumber(customerContactNumber);
	}

	/*@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.createCustomer(customer);
	}

	@Override
	public Optional<Customer> getCustomerById(int customerID) throws InvalidIdException, InvalidNameException, InvalidContactNumberException, InvalidAddressException, InvalidGovernmentIdException {
		// TODO Auto-generated method stub
		return customerRepository.getCustomerById(customerID);
	}

	@Override
	public Optional<Customer> deleteCustomerById(int customerID) {
		// TODO Auto-generated method stub
		return customerRepository.deleteCustomerById(customerID);
	}

	@Override
	public List<Customer> getAllCustomers() throws InvalidIdException, InvalidNameException, InvalidContactNumberException, InvalidAddressException, InvalidGovernmentIdException {
		// TODO Auto-generated method stub
		return customerRepository.getAllCustomers();
	}*/
	
}
