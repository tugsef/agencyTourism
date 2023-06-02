package com.tourism.agency.dataAccess.abstracts.rezervation;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.rezervation.ContactDetails;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Integer>{

}
