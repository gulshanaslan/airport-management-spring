package com.fuzzy.airportmanagement.dto.request;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightRequestDto {

    Date depDate;
    Date arrDate;
    Integer depAirport_id;
    Integer arrAirport_id;
    Integer company_id;
}
