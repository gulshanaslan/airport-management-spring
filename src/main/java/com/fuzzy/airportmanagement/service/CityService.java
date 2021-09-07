package com.fuzzy.airportmanagement.service;


import com.fuzzy.airportmanagement.domain.City;
import com.fuzzy.airportmanagement.domain.Country;
import com.fuzzy.airportmanagement.dto.request.CityRequestDto;
import com.fuzzy.airportmanagement.dto.response.CityResponseDto;
import com.fuzzy.airportmanagement.dto.response.FilterResponseDto;
import com.fuzzy.airportmanagement.mapper.CityMapper;
import com.fuzzy.airportmanagement.repository.CityRepo;
import com.fuzzy.airportmanagement.repository.CountryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CityService {

    private final CityRepo cityRepo;

    private final CityMapper cityMapper;

    private final CountryRepo countryRepo;

    public List<CityResponseDto> getAllCity() {
        log.info("getAllCity service started");
        List<City> cityList = cityRepo.findAll();
        List<CityResponseDto> cityResponseDtoList = cityMapper.toCityResponseDtoList(cityList);
        log.info("getAllCity service completed");
        return cityResponseDtoList;
    }

    public FilterResponseDto<List<CityResponseDto>> getAllCityWithPage(Integer page, Integer size) {
        log.info("getAllCityWithPage service started with page : {} , size : {}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        List<City> city = cityRepo.findAll(pageable).getContent();
        List<CityResponseDto> list = cityMapper.toCityResponseDtoList(city);
        log.info("getAllCityWithPage service completed with page : {} , size : {}", page, size);
        return new FilterResponseDto<>(list, cityRepo.count(), list.size());
    }

    public CityResponseDto getCityById(Integer id) {
        log.info("getCityById service started");
        //City city = cityRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("City not found"));
        City city = cityRepo.findById(id).get();
        log.info("getCityById service completed");
        return cityMapper.toCityResponseDto(city);
    }

    public CityResponseDto createCity(CityRequestDto cityRequestDto) {
        log.info("creatCity service started");
        City city = cityMapper.toCity(cityRequestDto);
/*        Country country = countryRepo.findById(cityRequestDto.getCountry_id()).orElseThrow(
                () -> new EntityNotFoundException("Country not found with id: " + cityRequestDto.getCountry_id()));*/
        Country country = countryRepo.findById(cityRequestDto.getCountry_id()).get();
        city.setCountry(country);
        City createdCity = cityRepo.save(city);
        log.info("createCity service completed");
        return cityMapper.toCityResponseDto(createdCity);
    }

    public CityResponseDto updateCity(Integer id, CityRequestDto cityRequestDto) {
        log.info("updateCity service started");
        City city = cityRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("City not found"));
        city.setName(cityRequestDto.getName());
        if (cityRequestDto.getCountry_id() != null) {
            //Country country = countryRepo.findById(cityRequestDto.getCountry_id()).orElseThrow();
            Country country = countryRepo.findById(cityRequestDto.getCountry_id()).get();
            city.setCountry(country);
        }
        city.setActive(cityRequestDto.getActive());
        City updatedCity = cityRepo.save(city);
        log.info("updateCity service completed");
        return cityMapper.toCityResponseDto(updatedCity);
    }


}
