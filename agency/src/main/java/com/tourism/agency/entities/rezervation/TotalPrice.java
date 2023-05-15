package com.tourism.agency.entities.rezervation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "total_prices")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class TotalPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "customer_type")
	private String customerType;
	
	@Column(name = "price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "rezervation_id")
	private Rezervation rezervation;
	
	
	
}
