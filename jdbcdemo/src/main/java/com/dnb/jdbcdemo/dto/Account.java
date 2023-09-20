package com.dnb.jdbcdemo.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;

import com.dnb.jdbcdemo.exceptions.InvalidAccountStatusException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountTypeException;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidDateException;
import com.dnb.jdbcdemo.exceptions.InvalidIdException;
import com.dnb.jdbcdemo.exceptions.InvalidNameException;
import com.dnb.jdbcdemo.exceptions.InvalidValueException;
import com.dnb.jdbcdemo.utils.CustomAccountIdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = "customer")
@Entity
public class Account {
	@Id
	@NotBlank(message = "account id should not be blank") //should not be empty
	@GeneratedValue(strategy = GenerationType.UUID)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq") //if generator is specified, then it'll know to use its wrapper class
//	@GenericGenerator(name = "account_seq", strategy = "com.dnb.jdbcdemo.utils.DatePrefixedSequenceIdGenerator",
//	parameters = {@Parameter(name =CustomAccountIdGenerator.INCREMENT_PARAM, value = "50"),
//			//@Parameter(name=CustomAccountIdGenerator.VALUE_PREFIX_PARAMETER, value = "A_"),
//			//@Parameter(name=CustomAccountIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
//	})
	
	private String accountId;
	@Column(nullable = false)
	//@NotBlank(message = "account holder name should not be blank")
	private String accountHolderName;
	private String accountType;
	
	//@Min(value = 0, message = "value should not be negative")
	private float balance;
	
	//@Length(min = 10, max =10)
	//@jakarta.validation.constraints.Pattern(regexp = "^[0-9]{10}$")
	private String contactNumber;
	private String address;
	// Local Date gives support with time zone as well
	
	//@jakarta.validation.constraints.Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}")
	private LocalDate accountCreatedDate = LocalDate.now();
	//@NotBlank(message = "dob is not valid")
	//@jakarta.validation.constraints.Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}")
	private LocalDate dob;
	private boolean accountStatus;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_ID", referencedColumnName = "customerID")
	//@JsonIgnore
	@JsonIgnoreProperties("accountList")
	//@JsonIgnoreProperties({"account", "hibernateLazyInitializer"})
	private Customer customer;
	//private int customerID;
	
}
