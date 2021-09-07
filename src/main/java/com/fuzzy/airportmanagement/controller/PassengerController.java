package com.fuzzy.airportmanagement.controller;


import com.fuzzy.airportmanagement.domain.Passenger;
import com.fuzzy.airportmanagement.dto.request.PassengerRequestDto;
import com.fuzzy.airportmanagement.dto.response.PassengerResponseDto;
import com.fuzzy.airportmanagement.service.PassengerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/passenger")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public List<PassengerResponseDto> getAll(){
        return passengerService.getPassengers();
    }

    @GetMapping("/{id}")
    public Passenger getPassengerById (@PathVariable("id") Integer id){
        return passengerService.getPassengerById(id);
    }

    @PostMapping
    public PassengerResponseDto create(@RequestBody PassengerRequestDto passengerRequestDto){
        return passengerService.createPassenger(passengerRequestDto);
    }

    @PutMapping("/{id}")
    public PassengerResponseDto updatePassenger(@PathVariable("id") Integer id, @RequestBody PassengerRequestDto passengerRequestDto){
        return passengerService.updatePassenger(id, passengerRequestDto);
    }

}
