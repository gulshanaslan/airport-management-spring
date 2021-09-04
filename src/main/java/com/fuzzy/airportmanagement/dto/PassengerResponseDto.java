package com.fuzzy.airportmanagement.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassengerResponseDto {


    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private Integer active;

}
