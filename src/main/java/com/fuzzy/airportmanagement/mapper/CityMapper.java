package com.fuzzy.airportmanagement.mapper;

import com.fuzzy.airportmanagement.domain.City;
import com.fuzzy.airportmanagement.dto.CityRequestDto;
import com.fuzzy.airportmanagement.dto.CityResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityMapper {

    City toCity (CityRequestDto cityRequestDto);

    CityResponseDto toCityResponseDto (City city);

    List<CityResponseDto> toCityResponseDtoList(List<City> cityList);
}
