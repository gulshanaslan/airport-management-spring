package com.fuzzy.airportmanagement.mapper;

import com.fuzzy.airportmanagement.domain.Company;
import com.fuzzy.airportmanagement.dto.request.CompanyRequestDto;
import com.fuzzy.airportmanagement.dto.response.CompanyResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {

    Company toCompany (CompanyRequestDto companyRequestDto);

    CompanyResponseDto toCompanyResponseDto (Company company);

    List<CompanyResponseDto> toCompanyListDto (List<Company> list);

}
