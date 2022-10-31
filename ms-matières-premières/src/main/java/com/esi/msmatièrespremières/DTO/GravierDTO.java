package com.esi.msmatièrespremières.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GravierDTO {
    private  String nom;
    private String description;

    private Date dateCreation;
    private String typeGravier;

    private String Nature;
    private String Forme;
    private float poids;
    private float resistance;
}

