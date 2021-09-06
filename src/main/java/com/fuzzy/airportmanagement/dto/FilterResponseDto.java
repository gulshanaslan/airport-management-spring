package com.fuzzy.airportmanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilterResponseDto<T> {

    private T responseDto;
    private long totalElementsOnDatabase;
    private long returnedElementsToUI;


}
