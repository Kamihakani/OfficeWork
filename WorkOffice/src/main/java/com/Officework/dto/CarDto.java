package com.Officework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
  private Long carId;
    private String carName;
    private String companyName;
    private String price;
    private String tt;

    private List<EngineDetailsDto> engineDetails;
}
