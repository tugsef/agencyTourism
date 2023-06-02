package com.tourism.agency.entities.rezervation;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tourism.agency.entities.customer.Customer;
import com.tourism.agency.entities.hotel.Hotel;
import com.tourism.agency.entities.hotel.room.Room;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "rezervations")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
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

	@Column(name = "childs")
	private int child;

	@Column(name = "adult")
	private int adult;

	@Column(name = "totalPrices")
	private double totalPrice;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "hotel_id" )
	@JsonIgnore
	private Hotel hotel;

	@OneToMany(mappedBy = "rezervation" , cascade = CascadeType.ALL)
	private List<Customer> customers;

	@OneToOne(mappedBy = "rezervation" , cascade = CascadeType.ALL)
	private ContactDetails contactDetails;
	
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "room_id")
	private Room room;

}
