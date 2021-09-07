package com.fuzzy.airportmanagement.controller;


import com.fuzzy.airportmanagement.dto.request.AirportRequestDto;
import com.fuzzy.airportmanagement.dto.response.AirportResponseDto;
import com.fuzzy.airportmanagement.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/airport")
public class AirportController {

    private final AirportService airportService;

    @PostMapping
    public AirportResponseDto create (@RequestBody AirportRequestDto airportRequestDto){
        return airportService.createAirport(airportRequestDto);
    }
}
