package com.example.tourismAgency.entities.hotels;

import org.hibernate.annotations.ManyToAny;

import com.example.tourismAgency.entities.agency.TourismAgency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name="name")
	private String name;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="rating")
	private int rating;
	
	@ManyToAny
	@JoinColumn(name= "tourismAgency_id")
	private TourismAgency tourismAgency;
	
//  private Location location;
//  private List<Feature> feature;
//  private Room room;	
	
}