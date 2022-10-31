package com.esi.msmatièrespremières.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdjuvantsRequest {

    private  String nom;
    private String description;
    private String dateCreation;
    private String type;
    private String Base_chimique;
    private float dosage;
    private float teneur;
    private String couleur;
    private float poids;
    private String fonctionP;  private String fonctionS;
    private String fournisseur;

}
