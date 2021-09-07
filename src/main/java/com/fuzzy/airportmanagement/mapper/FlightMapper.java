package com.fuzzy.airportmanagement.mapper;


import com.fuzzy.airportmanagement.domain.Flight;
import com.fuzzy.airportmanagement.dto.request.FlightRequestDto;
import com.fuzzy.airportmanagement.dto.response.FlightResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FlightMapper {

    Flight toFlight(FlightRequestDto flightRequestDto);

    FlightResponseDto toFlightResponseDto (Flight flight);

    List<FlightResponseDto> toFlightResponseDtoList (List<Flight> list);

}
