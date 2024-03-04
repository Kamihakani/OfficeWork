package com.Officework.controller;

import com.Officework.Entity.Car;
import com.Officework.dto.CarDto;
import com.Officework.enums.StatusCode;
import com.Officework.service.CarService;
import com.Officework.service.ServiceManagement;
import com.Officework.util.BaseResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/")
public class CarController {
private final CarService carService;
private final ServiceManagement serviceManagement;

    public CarController(CarService carService, ServiceManagement serviceManagement) {
        this.carService = carService;
        this.serviceManagement = serviceManagement;
    }

    @PostMapping("/save")
    public ResponseEntity<?> createEvent(@RequestBody CarDto carDTO) {


//        return new ResponseEntity<>(carData, HttpStatus.CREATED);
        try {
            log.info("Entry : createCar : {}",carDTO);
            if (ObjectUtils.isEmpty(carDTO) || ObjectUtils.isEmpty(carDTO.getCarName())) {
                ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
            }
            Car carData = carService.saveCar(carDTO);
            return ResponseEntity.ok().body(carData);

        } catch (Exception e) {
            log.error("Error in createEvent -> : {}", carDTO);
            log.error("Error in createEvent : {}", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/cars/{enginePower}/{engineType}/{tt}")
    public ResponseEntity<List<Car>> getCarsByEngineAndTransmission(
            @PathVariable String enginePower, @PathVariable String tt,
            @PathVariable String engineType) {
        try {
            if (StringUtils.isEmpty(enginePower) || StringUtils.isEmpty(engineType)) {
                return ResponseEntity.badRequest().build();
            }
            List<Car> allByEngineAndTransmission = carService.findAllByEngineAndTransmission(enginePower, engineType, tt);
            return new ResponseEntity<>(allByEngineAndTransmission, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error in getCarsByEngineAndTransmission -> ", enginePower, engineType);
            log.error("Error in getEventsForUser : {}", e);
            return ResponseEntity.ok((List<Car>) BaseResponseUtil.createBaseResponse(StatusCode.INTERNAL_SERVER_ERROR));
        }

    }
















//   // carService.saveCar(carDTO);
//            //return ResponseEntity.ok().body("Car Details Saved successfully!!");
//          // return ResponseEntity.ok().body(BaseResponseUtil.createBaseResponse(StatusCode.OK),);
























//        List<Car> allByEngineAndTransmission = carService.findAllByEngineAndTransmission(enginePower, engineType);
//        return new ResponseEntity<>(allByEngineAndTransmission,HttpStatus.OK);
//    }
//
}

