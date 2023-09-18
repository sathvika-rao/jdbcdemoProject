package com.dnb.jdbcdemo.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {
	
	@NotBlank(message = "name should not be blank")
	private String customerName;
	@NotBlank(message = "Contact number should not be empty")
	private String customerContactNumber;
	@NotBlank(message = "Address should not be empty")
	private String customerAddress;
	@NotBlank(message = "PAN should not be empty")
	private String customerPAN;
	@NotBlank(message = "UUID should not be empty")
	private String customerUUID;
}
