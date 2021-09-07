package com.fuzzy.airportmanagement.mapper;


import com.fuzzy.airportmanagement.domain.Passenger;
import com.fuzzy.airportmanagement.dto.request.PassengerRequestDto;
import com.fuzzy.airportmanagement.dto.response.PassengerResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PassengerMapper {

    PassengerResponseDto toPassengerResponseDto(Passenger passenger);

    List<PassengerResponseDto> toPassengerResponseDtoList(List<Passenger> passengerList);

    Passenger toPassengerRequestDto(PassengerRequestDto passengerRequestDto);



}
