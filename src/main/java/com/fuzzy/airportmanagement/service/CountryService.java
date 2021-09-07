package com.fuzzy.airportmanagement.service;

import com.fuzzy.airportmanagement.domain.Country;
import com.fuzzy.airportmanagement.dto.request.CountryRequestDto;
import com.fuzzy.airportmanagement.dto.response.CountryResponseDto;
import com.fuzzy.airportmanagement.dto.response.SuccessResponseDto;
import com.fuzzy.airportmanagement.mapper.CountryMapper;
import com.fuzzy.airportmanagement.repository.CountryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepo countryRepo;
    private final CountryMapper countryMapper;

    /*public CountryService(CountryRepo countryRepoo, CountryMapper countryMapper) {
        this.countryRepo = countryRepoo;
        this.countryMapper = countryMapper;
    }*/

    public CountryResponseDto createCountry(CountryRequestDto countryRequestDto) {
        log.info("createCountry service started");
        Country createdCountry = countryRepo.save(countryMapper.toCountryRequestDto(countryRequestDto));
        log.info("createCity service completed");
        return countryMapper.toCountryResponseDto(createdCountry);
    }

    public List<CountryResponseDto> getCountryList() {
        log.info("getCountryList service started");
        List<Country> countryList = countryRepo.findAll();
        log.info("getCountryList service completed");
        return countryMapper.toCountryResponseListDto(countryList);
    }

    public Country getCountryById(Integer id) {
        log.info("getCountryById service started");
        //Country country = countryRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Country not found with id:" + id));
        Country country = countryRepo.findById(id).get();
        log.info("getPassengerById service completed");
        return country;
    }

    public CountryResponseDto updateCountry(CountryRequestDto countryRequestDto, Integer id) {
        log.info("updateCountry service started");
        //Country country = countryRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Country not found with id:" + id));
        Country country = countryRepo.findById(id).get();
        if (countryRequestDto.getName() != null) {
            country.setName(countryRequestDto.getName());
        }
        Country updatedCountry = countryRepo.save(country);
        return countryMapper.toCountryResponseDto(updatedCountry);
    }

    public SuccessResponseDto deleteCountry(Integer id) {
        log.info("deleteCountry service started");
        countryRepo.deleteById(id);
        log.info("deleteCountry service completed");
        return new SuccessResponseDto(id, true, "Country successfully deleted");
    }

}
