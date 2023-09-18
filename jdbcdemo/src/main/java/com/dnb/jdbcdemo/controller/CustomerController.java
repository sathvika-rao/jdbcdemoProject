package com.dnb.jdbcdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.dnb.jdbcdemo.payload.request.CustomerRequest;
import com.dnb.jdbcdemo.service.CustomerService;
import com.dnb.jdbcdemo.utils.RequestToEntityMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer") //will be common
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	RequestToEntityMapper mapper;
	
	@GetMapping("/cid/{customerID}")// should help us get specific account details
	public ResponseEntity<?> getCustomerById(@PathVariable("customerID") int customerID) throws InvalidIdException, InvalidNameException, InvalidContactNumberException, InvalidAddressException, InvalidGovernmentIdException, IdNotFoundException {
		java.util.Optional<Customer> optional = customerService.getCustomerById(customerID);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new IdNotFoundException("invalid customer id");
		}
	}
	
	@GetMapping("/ccn/{customerContactNumber:^[0-9]{10}$}")// should help us get specific account details
	public ResponseEntity<?> getCustomerByCustomerContactNumber(@PathVariable("customerContactNumber") String customerContactNumber) throws InvalidContactNumberException{
		java.util.Optional<Customer> optional = customerService.getCustomerByCustomerContactNumber(customerContactNumber);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new InvalidContactNumberException("invalid customer contact number");
		}
	}
	
	
	@GetMapping("/allCustomers/{customerContactNumber}")
	public ResponseEntity<?> getAllCustomersByCustomerContactNumber(@PathVariable("customerContactNumber") String customerContactNumber) {
		List<Customer> customers = new ArrayList<>();
		customers = customerService.getAllCustomersByCustomerContactNumber(customerContactNumber);
		return ResponseEntity.ok(customers);
	}
	
	@GetMapping("/allCustomers")
	public ResponseEntity<?> getAllCustomers() throws InvalidNameException, InvalidDateException, InvalidIdException, InvalidAccountTypeException, InvalidValueException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException, InvalidGovernmentIdException {
		List<Customer> customers = new ArrayList<>();
		customers = customerService.getAllCustomers();
		return ResponseEntity.ok(customers);
		
	}
	
	
	
	@DeleteMapping("/{customerID}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerID") int customerID) throws IdNotFoundException, InvalidIdException {
		if(customerService.deleteCustomerById(customerID)) {
			return ResponseEntity.noContent().build();
		}
		else
			throw new IdNotFoundException("id not found");
			
	}
	
	
	@PostMapping("/createCustomer") //@RequestMapping + post method - from spring 4.3.x
	public ResponseEntity<?> createCustomer( @Valid @RequestBody CustomerRequest customer) {
		try {
			Customer customer2 = customerService.createCustomer(mapper.getCustomerEntity(customer));
			return new ResponseEntity<Customer>(customer2, HttpStatus.CREATED);
			
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	
	
}
