package com.Officework.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class EngineDetailsDto {
        private Long engineNo;
        private String enginePower;
        private String engineType;
        private String madeBy;
}
