package com.fuzzy.airportmanagement.service;


import com.fuzzy.airportmanagement.domain.Company;
import com.fuzzy.airportmanagement.dto.request.CompanyRequestDto;
import com.fuzzy.airportmanagement.dto.response.CompanyResponseDto;
import com.fuzzy.airportmanagement.mapper.CompanyMapper;
import com.fuzzy.airportmanagement.repository.CompanyRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepo companyRepo;
    private final CompanyMapper companyMapper;

    public CompanyResponseDto createCompany(CompanyRequestDto companyRequestDto) {
        log.info("createCompany service strated");
        Company company = companyRepo.save(companyMapper.toCompany(companyRequestDto));
        log.info("createCompany service completed");
        return companyMapper.toCompanyResponseDto(company);
    }
}
