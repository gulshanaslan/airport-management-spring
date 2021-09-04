package com.fuzzy.airportmanagement.controller;

import com.fuzzy.airportmanagement.domain.Country;
import com.fuzzy.airportmanagement.dto.CountryRequestDto;
import com.fuzzy.airportmanagement.dto.CountryResponseDto;
import com.fuzzy.airportmanagement.dto.SuccessResponseDto;
import com.fuzzy.airportmanagement.service.CountryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;


    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping
    public List<CountryResponseDto> getCountryList() {
        return countryService.getCountryList();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable("id") Integer id) {
        return countryService.getCountryById(id);
    }

    @PostMapping
    public CountryResponseDto create(@RequestBody CountryRequestDto countryRequestDto) {
        return countryService.createCountry(countryRequestDto);
    }

    @PutMapping("/{id}")
    public CountryResponseDto updateCountry(@RequestBody CountryRequestDto countryRequestDto,
                                            @PathVariable("id") Integer id) {
        return countryService.updateCountry(countryRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public SuccessResponseDto deleteCountry(@PathVariable("id") Integer id) {
        return countryService.deleteCountry(id);
    }

}
