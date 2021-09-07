package com.fuzzy.airportmanagement.controller;

import com.fuzzy.airportmanagement.dto.request.FlightRequestDto;
import com.fuzzy.airportmanagement.dto.response.FlightResponseDto;
import com.fuzzy.airportmanagement.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public List<FlightResponseDto> getAllFlight(){
        return flightService.getAllFlight();
    }

        @PostMapping
    public FlightResponseDto createFlight(@RequestBody FlightRequestDto flightRequestDto) {
        return flightService.createFlight(flightRequestDto);
    }
}
