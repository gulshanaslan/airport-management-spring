package com.fuzzy.airportmanagement.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SuccessResponseDto {

    private Integer id;
    private Boolean status;
    private String message;

   /* public SuccessResponseDto(Integer id, Boolean status, String message) {
        this.id = id;
        this.status = status;
        this.message = message;
    }*/
}
