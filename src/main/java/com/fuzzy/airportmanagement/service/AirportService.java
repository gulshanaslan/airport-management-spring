package com.fuzzy.airportmanagement.service;


import com.fuzzy.airportmanagement.domain.Airport;
import com.fuzzy.airportmanagement.domain.City;
import com.fuzzy.airportmanagement.dto.request.AirportRequestDto;
import com.fuzzy.airportmanagement.dto.response.AirportResponseDto;
import com.fuzzy.airportmanagement.mapper.AirportMapper;
import com.fuzzy.airportmanagement.repository.AirportRepo;
import com.fuzzy.airportmanagement.repository.CityRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@Slf4j
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepo airportRepo;

    private final AirportMapper airportMapper;

    private final CityRepo cityRepo;

    public AirportResponseDto createAirport (AirportRequestDto airportRequestDto){
        log.info("createAirport service started");
        Airport airport = airportMapper.toAirport(airportRequestDto);
        //City city = cityRepo.findById(airportRequestDto.getCity_id()).orElseThrow(() -> new EntityNotFoundException("City not found"));
        City city = cityRepo.findById(airportRequestDto.getCity_id()).get();
        airport.setCity(city);
        Airport createdAirport = airportRepo.save(airport);
        log.info("createAirport service completed");
        return airportMapper.toAirportResponseDto(createdAirport);
    }

}
