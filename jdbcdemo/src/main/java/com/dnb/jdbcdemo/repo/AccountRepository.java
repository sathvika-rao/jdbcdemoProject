package com.dnb.jdbcdemo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.exceptions.InvalidAccountStatusException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountTypeException;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidDateException;
import com.dnb.jdbcdemo.exceptions.InvalidIdException;
import com.dnb.jdbcdemo.exceptions.InvalidNameException;
import com.dnb.jdbcdemo.exceptions.InvalidValueException;

@Repository
//T is the entity type for the entity on which the operations need to be implemented, ID is type of primary key
public interface AccountRepository extends CrudRepository<Account, String>{
	public Optional<Account> findByContactNumber(String contactNumber);
	
	public List<Account> findAllByContactNumber(String contactNumber);
	
}
