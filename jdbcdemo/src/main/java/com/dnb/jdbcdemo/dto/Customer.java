package com.dnb.jdbcdemo.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidGovernmentIdException;
import com.dnb.jdbcdemo.exceptions.InvalidIdException;
import com.dnb.jdbcdemo.exceptions.InvalidNameException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int customerID;
	private String customerName;
	private String customerContactNumber;
	private String customerAddress;
	private String customerPAN;
	private String customerUUID;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	//@JsonIgnore
	@JsonIgnoreProperties("customer")
	//@JsonIgnoreProperties({"customer", "hibernateLazyInitializer"})
	private List<Account> accountList = new ArrayList<>();
}

//	public Customer(int customerID, String customerName, String customerContactNumber, String customerAddress,
//			String customerPAN, String customerUUID) throws InvalidIdException, InvalidNameException, 
//	InvalidContactNumberException, InvalidAddressException, InvalidGovernmentIdException {
//		super();
//		this.setCustomerID(customerID);
//		this.setCustomerName(customerName);
//		this.setCustomerContactNumber(customerContactNumber);
//		this.setCustomerAddress(customerAddress);
//		this.setCustomerPAN(customerPAN);
//		this.setCustomerUUID(customerUUID);
//	}
//
//	public void setCustomerID(int customerID) throws InvalidIdException {
//		String regex = "^[0-9]$";
//		if (Pattern.compile(regex).matcher(Integer.toString(customerID)).find())
//			this.customerID = customerID;
//		else
//			throw new InvalidIdException("Given ID is not valid");
//	}
//
//	public void setCustomerName(String customerName) throws InvalidNameException {
//		String regex = "^[a-zA-Z]{2,}$";
//		if (Pattern.compile(regex).matcher(customerName).find())
//			this.customerName = customerName;
//		else
//			throw new InvalidNameException("name is not valid");
//	}
//
//	public void setCustomerContactNumber(String customerContactNumber) throws InvalidContactNumberException {
//		String regex = "^[1-9][0-9]{0,9}$";
//		if (Pattern.compile(regex).matcher(customerContactNumber).find())
//			this.customerContactNumber = customerContactNumber;
//		else
//			throw new InvalidContactNumberException("Contact number not valid");
//	}
//
//	public void setCustomerAddress(String customerAddress) throws InvalidAddressException {
//		String regex = "[A-Z][a-z]";
//
//		if (Pattern.compile(regex).matcher(customerAddress).find())
//
//			this.customerAddress = customerAddress;
//
//		else
//			throw new InvalidAddressException("Address is invalid");
//	}
//
//	public void setCustomerPAN(String customerPAN) throws InvalidGovernmentIdException {
//		String regex = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
//		//String regex = "[a-z]";
//		if (Pattern.compile(regex).matcher(customerPAN).find())
//			this.customerPAN = customerPAN;
//		else
//			throw new InvalidGovernmentIdException("PAN ID entered is not valid");
//	}
//
//	public void setCustomerUUID(String customerUUID) throws InvalidGovernmentIdException {
//		String regex = "^[0-9]{12}$";
//		if (Pattern.compile(regex).matcher(customerUUID).find())
//			this.customerUUID = customerUUID;
//		else
//			throw new InvalidGovernmentIdException("Aadhar ID entered is not valid");
//	}
