package com.fuzzy.airportmanagement.controller;

import com.fuzzy.airportmanagement.dto.CityRequestDto;
import com.fuzzy.airportmanagement.dto.CityResponseDto;
import com.fuzzy.airportmanagement.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<CityResponseDto> getAll(){
        return cityService.getAllCity();
    }

    @GetMapping("/{id}")
    public CityResponseDto getCityById(@PathVariable("id") Integer id){
        return cityService.getCityById(id);
    }

    @PostMapping
    public CityResponseDto create (@RequestBody CityRequestDto cityRequestDto){
        return cityService.createCity(cityRequestDto);
    }

    @PutMapping("/{id}")
    public CityResponseDto updateCity (@PathVariable("id") Integer id, @RequestBody CityRequestDto cityRequestDto){
        return cityService.updateCity(id, cityRequestDto);
    }

}