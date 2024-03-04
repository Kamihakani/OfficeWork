package com.Officework.carMapper;
import com.Officework.Entity.Car;
import com.Officework.Entity.EngineDetails;
import com.Officework.dto.CarDto;
import com.Officework.dto.EngineDetailsDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CarMapper {
//
    public static ModelMapper modelMapper;


    public CarDto entityToDto(Car car) {
        try {

            return modelMapper.map(car, CarDto.class);
        }catch (Exception e){
           log.error("Error in entityToDto : {}",e);
            return new CarDto();
        }
    }

    public Car convertToEntity(CarDto dto) {
        try {
            return modelMapper.map(dto, Car.class);
        }catch (Exception e){
            log.error("Error in requestToEntity");
            return null;
        }
    }
}
