package com.esi.msmatièrespremières.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CimentInfo {
    private  String nom;
    private String description;
    private Date dateCreation;
    private String typeCiment;
    private String classification;
    private float poids;
    private float resistance;
    private String wilaya;
}
