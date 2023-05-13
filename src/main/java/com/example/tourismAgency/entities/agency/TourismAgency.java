package com.example.tourismAgency.entities.agency;

import java.util.List;

import com.example.tourismAgency.entities.hotels.Hotel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="agencies")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TourismAgency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Column(name="agancy_name")
	private String agencyName;
	
	@OneToMany(mappedBy = "tourismAgency")
	private List<Hotel> hotels;
	
}