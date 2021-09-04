package com.fuzzy.airportmanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassengerRequestDto {

    private String name;
    private String surname;
    private String phone;
    private Integer active;

}
