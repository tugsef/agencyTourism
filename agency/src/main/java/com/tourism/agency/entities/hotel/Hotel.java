package com.tourism.agency.entities.hotel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tourism.agency.entities.Agency;
import com.tourism.agency.entities.hotel.room.Room;
import com.tourism.agency.entities.rezervation.Rezervation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Table(name="hotels")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","rooms","hotal_features" , "rezervations"})


public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "decsription")
	private String decsription;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="rating")
	private int rating;
	
	@ManyToOne
	@JoinColumn(name= "agency_id")
	private Agency agency;
	
	
	@OneToOne(mappedBy = "hotel")
    private Location locations;
	
	@OneToMany(mappedBy = "hotel")
	private List<HotelFeature> featuries;
	
	@OneToMany(mappedBy = "hotel")
	private List<Room> rooms;	
	
	@OneToMany(mappedBy = "hotel")
	private List<Rezervation> rezervations;
	
}
