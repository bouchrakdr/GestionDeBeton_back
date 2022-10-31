package com.esi.msmatièrespremières.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data@NoArgsConstructor@AllArgsConstructor
public class EauRequest {

    private  String nom;
    private String description;
    private String dateCreation;
    private String type;
    private String couleur;
    private float poids;
    private float teneur;
    private String fournisseur;
}
