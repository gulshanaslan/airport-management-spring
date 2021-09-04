package com.fuzzy.airportmanagement.repository;

import com.fuzzy.airportmanagement.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepo extends JpaRepository<Passenger, Integer> {

}
