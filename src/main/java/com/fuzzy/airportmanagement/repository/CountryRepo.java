package com.fuzzy.airportmanagement.repository;

import com.fuzzy.airportmanagement.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Integer> {
}
