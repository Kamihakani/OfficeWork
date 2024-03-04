package com.Officework.request;

import com.Officework.Entity.EngineDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {

    private String carName;
    private String companyName;
    private List<EngineDetails> engineDetails;
}
