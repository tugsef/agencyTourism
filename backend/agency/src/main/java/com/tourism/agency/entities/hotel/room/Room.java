package com.tourism.agency.entities.hotel.room;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "rooms")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "type")
	private String type;

	@Column(name = "description")
	private String decsription;

	@Column(name = "capacity")
	private int capacity;
	
	@Column(name = "square_meters")
	private int squareMeters;

	@Column(name = "inventory")
	private int inventory;

	@Column(name = "number_of_beds" )
	private int  numberOfBeds; 
	
	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
	private List<Price> prices;

	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
	private List<Feature> features;
	
	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
	private List<RoomImages> roomImages;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_id" , nullable = false)
	@JsonIgnore
	private Hotel hotel;

	

}
