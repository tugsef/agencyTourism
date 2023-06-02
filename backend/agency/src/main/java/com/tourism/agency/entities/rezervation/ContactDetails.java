package com.tourism.agency.entities.rezervation;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contacts")
@Entity
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    @Column(name = "telephones")
	private String telephone;
    
    @Column(name = "emails")
	private String email;
    
    @Column(name = "notes")
	private String rezervationNote;
    
    @OneToOne
    @JoinColumn(name =  "rezervation_id" )
    @JsonIgnore
    private Rezervation rezervation;
    
	
}
