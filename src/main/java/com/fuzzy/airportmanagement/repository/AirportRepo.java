package com.fuzzy.airportmanagement.repository;

import com.fuzzy.airportmanagement.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport, Integer> {
}
