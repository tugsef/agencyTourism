package com.tourism.agency.business.requests.hotels;

import java.util.List;

import com.tourism.agency.entities.customer.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRezervationRequest {
	private int id;
	private int hotelId;
	private int roomId;
	private String startDate;
	private String dueDate;
	private int daysTime;
	private int child;
	private int adult;
	private int totalPrice;
	private String contactDetailsTelephone;
	private String contactDetailsEmail;
	private String contactDetailsNote;
	private List<Customer> customers;
	
	
}
