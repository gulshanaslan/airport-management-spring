package com.fuzzy.airportmanagement.mapper;


import com.fuzzy.airportmanagement.domain.Country;
import com.fuzzy.airportmanagement.dto.CountryRequestDto;
import com.fuzzy.airportmanagement.dto.CountryResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CountryMapper {

    Country toCountryRequestDto(CountryRequestDto countryRequestDto);

    CountryResponseDto toCountryResponseDto(Country country);

    List<CountryResponseDto> toCountryResponseListDto (List<Country> countryList);

}
