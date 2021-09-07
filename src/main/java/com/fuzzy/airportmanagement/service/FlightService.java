package com.fuzzy.airportmanagement.service;


import com.fuzzy.airportmanagement.domain.Airport;
import com.fuzzy.airportmanagement.domain.Company;
import com.fuzzy.airportmanagement.domain.Flight;
import com.fuzzy.airportmanagement.dto.request.FlightRequestDto;
import com.fuzzy.airportmanagement.dto.response.FlightResponseDto;
import com.fuzzy.airportmanagement.mapper.FlightMapper;
import com.fuzzy.airportmanagement.repository.AirportRepo;
import com.fuzzy.airportmanagement.repository.CompanyRepo;
import com.fuzzy.airportmanagement.repository.FlightRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepo flightRepo;
    private final FlightMapper flightMapper;
    private final AirportRepo airportRepo;
    private final CompanyRepo companyRepo;


    @Transactional
    public List<FlightResponseDto> getAllFlight() {
        log.info("getAllFlight service started");
        List<Flight> flightList = flightRepo.findAll();
        log.info("getAllFlight service completed");
        return flightMapper.toFlightResponseDtoList(flightList);
    }

    public FlightResponseDto createFlight(FlightRequestDto flightRequestDto) {
        log.info("createFlight service started");
        Flight flight = flightMapper.toFlight(flightRequestDto);
        if (flightRequestDto.getDepAirport_id() != null) {
            //Airport depAirport = airportRepo.findById(flightRequestDto.getDepAirport_id()).orElseThrow();
            Airport depAirport = airportRepo.findById(flightRequestDto.getDepAirport_id()).get();
            flight.setDepAirport(depAirport);
        }
        if (flightRequestDto.getArrAirport_id() != null) {
            //Airport arrAirport = airportRepo.findById(flightRequestDto.getArrAirport_id()).orElseThrow();
            Airport arrAirport = airportRepo.findById(flightRequestDto.getArrAirport_id()).get();
            flight.setArrAirport(arrAirport);
        }
        if (flightRequestDto.getCompany_id() != null) {
            //Company company = companyRepo.findById(flightRequestDto.getCompany_id()).orElseThrow();
            Company company = companyRepo.findById(flightRequestDto.getCompany_id()).get();
            flight.setCompany(company);
        }
        Flight createdFlight = flightRepo.save(flight);
        log.info("createFlight service completed");
        return flightMapper.toFlightResponseDto(createdFlight);
    }
}
