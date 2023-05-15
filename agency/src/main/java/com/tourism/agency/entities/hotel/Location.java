package com.tourism.agency.entities.hotel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "locations")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")
	private int id;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "adress")
	private String adress;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "feature")
	private String feature;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;
	
	@OneToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	

}
