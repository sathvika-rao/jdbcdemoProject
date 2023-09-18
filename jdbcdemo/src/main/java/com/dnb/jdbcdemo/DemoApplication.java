package com.dnb.jdbcdemo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
import com.dnb.jdbcdemo.service.AccountService;
import com.dnb.jdbcdemo.service.CustomerService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		SpringApplication.run(DemoApplication.class, args);
		
		/*DataSource dataSource = applicationContext.getBean(DataSource.class);
		System.out.println(dataSource!=null);
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
//		Account account2 = new Account();
//		AccountService accountService = applicationContext.getBean(AccountService.class);
		/*try {
			accountService.createAccount(account2);
			account2.setDob("09/12/2001");
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidContactNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidGovernmentIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
//		CustomerService customerService = applicationContext.getBean(CustomerService.class);
//		Customer customer;
//		
//		
//		
//		try {
//			account2 = new Account("Akhila", "Savings",50000, "9846422213", "Sirsila", LocalDate.now(),"09/12/2001",true, 1);
//			System.out.println("Account "+account2);
//			customer = new Customer(1,"Sravya", "9385937501", "Hyderabad", "JSOFR4728K", "372849502847");
//			System.out.println("Customer"+customer);
//			
//			Scanner sc = new Scanner(System.in);
//			
//			while(true) {
//				System.out.println("Enter your choice");
//				String str = sc.nextLine();
//				switch(str) {
//				case "createAccount" : 
//						accountService.createAccount(account2);
//					
//				break;
//				
//				case "getAccountById" : {
//					Optional<Account> acc;
//						acc = accountService.getAccountById("aa001");
//						System.out.println(acc.isPresent());
//					break;
//				}
//				
//				case "deleteAccountById" : {
//					System.out.println(accountService.deleteAccountById("aa001"));
//					break;
//				}
//				
//				case "getAllAccounts" : 
//						accountService.getAllAccounts().forEach(e->System.out.println(e));
//					
//				break;
//				
//				case "createCustomer" : customerService.createCustomer(customer);
//				break;
//				
//					
//				
//				case "exit" : System.exit(0);
//				}
//			
//			}
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidDateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidAccountTypeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidValueException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidContactNumberException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidAddressException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidAccountStatusException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidGovernmentIdException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
		
		/*account2.setAccountId("sa003");
		try {
			account2.setAccountHolderName("Sathvika");
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account2.setAccountStatus(true);
		account2.setAccountType("Savings");
		account2.setAddress("Hyderabad");
		account2.setBalance(60000);
		account2.setContactNumber("9036470222");
		try {
			account2.setDob(LocalDate.of(2001, 14, 9)) ;
		} catch (InvalidDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//account2.setCustomer(new Customer(1,"vaish", "9123489343", "Bangalore", "PDNJF42902", "37297207"));
 
		
	}

}
