package com.tourism.agency.entities.hotel.room;

import com.fasterxml.jackson.annotation.JsonIgnore;


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

@Table(name = "prices")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "type")
	private String type;

	@Column(name = "q1")
	private double q1;

	@Column(name = "q2")
	private double q2;

	@Column(name = "q3")
	private double q3;

	@Column(name = "q4")
	private double q4;

	@Column(name = "discount")
	private int discount;

	@ManyToOne
	@JoinColumn(name = "room_id")
	@JsonIgnore
	private Room room;
}
