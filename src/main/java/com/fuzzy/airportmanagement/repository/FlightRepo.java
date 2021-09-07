package com.fuzzy.airportmanagement.repository;

import com.fuzzy.airportmanagement.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository<Flight, Integer> {


}
