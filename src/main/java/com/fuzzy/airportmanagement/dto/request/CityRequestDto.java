package com.fuzzy.airportmanagement.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityRequestDto {

    private String name;
    private Integer country_id;
    private Integer active;

}
