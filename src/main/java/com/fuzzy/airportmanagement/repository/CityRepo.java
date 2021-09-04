package com.fuzzy.airportmanagement.repository;

import com.fuzzy.airportmanagement.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Integer> {

}
