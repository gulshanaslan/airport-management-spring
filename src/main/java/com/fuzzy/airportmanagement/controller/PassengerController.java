package com.fuzzy.airportmanagement.controller;


import com.fuzzy.airportmanagement.domain.Passenger;
import com.fuzzy.airportmanagement.dto.PassengerRequestDto;
import com.fuzzy.airportmanagement.dto.PassengerResponseDto;
import com.fuzzy.airportmanagement.service.PassengerService;
import org.springframework.web.bind.annotation.*;

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
