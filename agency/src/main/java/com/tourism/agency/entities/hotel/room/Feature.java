package com.tourism.agency.entities.hotel.room;

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

@Table(name = "features")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Feature {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "property")
	private String property;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "active")
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	
}
