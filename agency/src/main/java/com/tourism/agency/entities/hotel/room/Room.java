package com.tourism.agency.entities.hotel.room;

import java.util.List;

import com.tourism.agency.entities.hotel.Hotel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	
	@Column(name = "inventory")
	private int inventory;
	
	@OneToMany(mappedBy = "room")
	private List<Price> prices;
	
	@OneToMany(mappedBy = "room")
	private List<Feature> features;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

}
