package com.esi.msmatièrespremières.DTO;

import com.esi.msmatièrespremières.entities.Ciment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data@NoArgsConstructor@AllArgsConstructor
public class CimentDTO {
    private  String nom;
    private String description;
    private Date dateCreation;
    private String typeCiment;
    private String Classification;
    private float poids;
    private float resistance;
    private String fournisseur;
    private String wilaya;
    private Ciment.Etat etat;
}