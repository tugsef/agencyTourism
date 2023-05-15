package com.tourism.agency.dataAccess.abstracts.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
