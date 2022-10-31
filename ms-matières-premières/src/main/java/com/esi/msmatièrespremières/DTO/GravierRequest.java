package com.esi.msmatièrespremières.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class GravierRequest {
    private  String nom;
    private String description;
    private String dateCreation;
    private String typeGravier;
    private String Nature;
    private String Forme;
    private float poids;
    private float resistance;
    private  String  wilaya;
    private String fournisseur;

}
