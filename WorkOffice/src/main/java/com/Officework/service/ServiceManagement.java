package com.Officework.service;

import com.Officework.Entity.Car;
import com.Officework.carMapper.CarMapper;
import com.Officework.dto.CarDto;
import com.Officework.enums.StatusCode;
import com.Officework.response.CarsResponse;
import com.Officework.util.BaseResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ServiceManagement {

    private final CarMapper carMapper;
    private final CarService carService;
    private List<com.Officework.dto.CarDto> CarDto;

    public ServiceManagement(CarMapper carMapper, CarService carService) {
        this.carMapper = carMapper;
        this.carService = carService;
    }

}


//

