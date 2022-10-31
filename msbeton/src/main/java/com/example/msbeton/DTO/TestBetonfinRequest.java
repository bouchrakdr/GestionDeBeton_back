package com.example.msbeton.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestBetonfinRequest {
    private String  observation;
    private float tempB;
    private float temAir;
}
