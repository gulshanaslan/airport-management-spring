package com.fuzzy.airportmanagement.repository;

import com.fuzzy.airportmanagement.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Integer> {
}
