package com.example.msbeton.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestBetondbRequest {
    private Long id;
    private String code;
    private String dateCol;
    private String client;
    private String fc;
    private int dciment;
    private int dmax;
    private int nbEcy;
    private int nbEc;
    private float rcm;
    private float rce;
}
