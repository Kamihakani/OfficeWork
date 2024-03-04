package com.Officework.service;

import com.Officework.Entity.Car;
import com.Officework.Entity.EngineDetails;
import com.Officework.Repository.CarRepo;
import com.Officework.Repository.EngineDetailsRepositary;
import com.Officework.carMapper.CarMapper;
import com.Officework.dto.CarDto;
import com.Officework.dto.EngineDetailsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarService {

    @Autowired
    private CarRepo carRepository;
    @Autowired
    private CarMapper carMapper;

    @Autowired
    private EngineDetailsRepositary engineDetailsRepository;
    public Car saveCar(CarDto carDTO) {
        log.info("Saving car: {}", carDTO);
        Car car = new Car();
        car.setCarName(carDTO.getCarName());

        car.setCompanyName(carDTO.getCompanyName());
        car.setTt(carDTO.getTt());
        car.setPrice(carDTO.getPrice());

        List<EngineDetailsDto> engineDetailsDtoList = carDTO.getEngineDetails();
        List<EngineDetails> engineDetailsList = new ArrayList<>();

        for (EngineDetailsDto engineDetailsDto : engineDetailsDtoList) {
            EngineDetails engineDetails = new EngineDetails();
            engineDetails.setEnginePower(engineDetailsDto.getEnginePower());
            engineDetails.setEngineType(engineDetailsDto.getEngineType());
            engineDetails.setMadeBy(engineDetailsDto.getMadeBy());
            engineDetails.setCar(car);

            engineDetailsList.add(engineDetails);
        }
       engineDetailsRepository.saveAll(engineDetailsList);

        car.setEngineDetails(engineDetailsList);
return car;
    }
    public List<Car> findAllByEngineAndTransmission(String enginePower, String engineType,String tt) {
        try {
            return carRepository.findAllByEngineAndTransmission(enginePower, engineType, tt);
        } catch (Exception e) {
            log.error("Error in findAllByEngineAndTransmission : {}", e);
            return null;
        }
    }

//    public List<CarDto> entitiesToDtos(List<Car> events) {
//        List<CarDto> carDtos = new ArrayList<>();
//        if(CollectionUtils.isEmpty(events)){
//            return carDtos;
//        }
//        for(Car event : events){
//            CarDto carDto = entityToDto(event);
//            carDtos.add(carDto);
//        }
//        return carDtos;
//    }
//    public CarDto entityToDto(Car event) {
//        try {
//            CarDto cartDto = carMapper.entityToDto(event);
////
//            return cartDto;
//        }catch (Exception e){
//            log.error("Error in entityToDto : {}",e);
//            return null;
//        }


}




   //public final Car car;
//
//   // public final CarMapper carMapper;
//
//    public CarService(Car carEntity, CarMapper carMapper) {
//        this.carEntity = carEntity;
//        this.carMapper = carMapper;
//    }

//    public Car save(Car event) {
//        try {
//            return carEntity.s
//        }catch (Exception e){
//            log.error("Error in save : {}",e);
//            return null;
//        }









