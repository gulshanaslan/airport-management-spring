package com.fuzzy.airportmanagement.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightResponseDto {

    Integer id;
    Date depDate;
    Date arrDate;
    AirportResponseDto depAirport;
    AirportResponseDto arrAirport;
    CompanyResponseDto company;
    Set<PassengerResponseDto> passengers;

}
