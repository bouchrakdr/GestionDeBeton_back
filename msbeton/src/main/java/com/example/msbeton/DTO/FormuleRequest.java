package com.example.msbeton.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormuleRequest {
    private String nom;
    private String description;
    private String dateC;
    private String typeM;
    private String spG;
    private String utilisation;
    private String utilP;
    private float rc28;
    private String ca;
    private float tmg;
    private String ce;
    private float ratio;
    private float ratioM;
    private float contC;
    private float volume;
    private float air;
    private float aff;
}
