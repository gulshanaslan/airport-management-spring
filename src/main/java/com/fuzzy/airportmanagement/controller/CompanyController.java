package com.fuzzy.airportmanagement.controller;


import com.fuzzy.airportmanagement.dto.request.CompanyRequestDto;
import com.fuzzy.airportmanagement.dto.response.CompanyResponseDto;
import com.fuzzy.airportmanagement.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public CompanyResponseDto create(@RequestBody CompanyRequestDto companyRequestDto) {
        return companyService.createCompany(companyRequestDto);
    }

}
