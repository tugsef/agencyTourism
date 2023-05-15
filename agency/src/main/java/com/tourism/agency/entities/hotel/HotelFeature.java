package com.tourism.agency.entities.hotel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "hotal_features")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class HotelFeature {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "property")
	private String property;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "actives")
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

}
