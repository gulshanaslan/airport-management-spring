package com.fuzzy.airportmanagement.mapper;


import com.fuzzy.airportmanagement.domain.Airport;
import com.fuzzy.airportmanagement.dto.request.AirportRequestDto;
import com.fuzzy.airportmanagement.dto.response.AirportResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AirportMapper {

    Airport toAirport (AirportRequestDto airportRequestDto);

    AirportResponseDto toAirportResponseDto(Airport airport);
}
