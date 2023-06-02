package com.tourism.agency.entities.hotel.room;



import java.util.Date;

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

@Table(name = "date_rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DateRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "dates")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "room_id" , nullable = false)
	@JsonIgnore
	private Room room;
}
