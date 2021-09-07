package com.fuzzy.airportmanagement.dto.request;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AirportRequestDto {

    String name;
    Integer city_id;
    Integer active;

}
