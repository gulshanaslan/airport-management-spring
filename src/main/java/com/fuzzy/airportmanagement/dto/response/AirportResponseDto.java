package com.fuzzy.airportmanagement.dto.response;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AirportResponseDto {

    Integer id;
    String name;
    CityResponseDto city;
    Integer active;


}
