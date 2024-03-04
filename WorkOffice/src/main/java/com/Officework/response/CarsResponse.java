package com.Officework.response;

import com.Officework.dto.CarDto;

import java.util.List;

public class CarsResponse extends BaseResponse {
    private List<CarDto> cars;


    public CarsResponse(String carDtos) {
    }
}
