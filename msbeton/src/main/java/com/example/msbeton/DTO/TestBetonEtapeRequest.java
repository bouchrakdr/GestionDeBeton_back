package com.example.msbeton.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestBetonEtapeRequest {
    private Date dateEcra;
    private float poidEv18;
    private float poidEv28;
    private float charge18;
    private float charge28;
    private int nbJour;
    private float rc18;
    private float rc28;
    private float rcm;
    private float rce;
}
