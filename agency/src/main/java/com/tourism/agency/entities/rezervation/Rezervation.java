package com.tourism.agency.entities.rezervation;

import java.util.List;

import com.tourism.agency.entities.customer.Customer;
import com.tourism.agency.entities.hotel.Hotel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "rezervations")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Rezervation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "due_date")
	private String dueDate;
	
	@Column(name = "day_time")
	private int daysTime;
	
	@OneToMany(mappedBy = "rezervation")
	private List<TotalPrice>  totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	@OneToMany(mappedBy = "rezervation")
	private List<Customer> customers;
	
	

}
