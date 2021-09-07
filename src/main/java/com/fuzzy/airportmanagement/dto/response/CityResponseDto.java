package com.fuzzy.airportmanagement.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityResponseDto {

    private Integer id;
    private String name;
    private CountryResponseDto country;
    private Integer active;
}
