package com.tourism.agency.dataAccess.abstracts.rezervation;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.agency.entities.rezervation.TotalPrice;

public interface TotalPriceRepository extends JpaRepository<TotalPrice, Integer> {

}
