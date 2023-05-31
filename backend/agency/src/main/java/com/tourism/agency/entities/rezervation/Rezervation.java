package com.tourism.agency.entities.rezervation;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tourism.agency.entities.customer.Customer;
import com.tourism.agency.entities.hotel.Hotel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "rezervations")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
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
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "hotel_id" , nullable = false)
//	@JsonIgnore
//	private Hotel hotel;
	
	@OneToMany(mappedBy = "rezervation")
	private List<Customer> customers;
	
	

}
