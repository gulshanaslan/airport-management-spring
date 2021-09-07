package com.fuzzy.airportmanagement.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PassengerResponseDto {

    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private Integer active;

}
