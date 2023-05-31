package com.tourism.agency.entities.hotel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tourism.agency.entities.Agency;
import com.tourism.agency.entities.hotel.room.Room;

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

@Table(name = "hotels")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer" })

public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "type")
	private String type;

	@Column(name = "name")
	private String name;

	@Column(name = "decsription")
	private String decsription;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "rating")
	private float rating;

	@Column(name = "stars")
	private int star;

	@ManyToOne
	@JoinColumn(name = "agency_id", nullable = false)
	@JsonIgnore
	private Agency agency;

	@OneToOne(mappedBy = "hotel")
	private Location location;

	@OneToMany(mappedBy = "hotel")
	private List<HotelFeature> featuries;

	@OneToMany(mappedBy = "hotel")
	private List<Room> rooms;

//	@OneToMany(mappedBy = "hotel")
//	private List<Rezervation> rezervations;

}
