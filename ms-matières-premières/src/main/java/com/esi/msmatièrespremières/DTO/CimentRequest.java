package com.esi.msmatièrespremières.DTO;

import com.esi.msmatièrespremières.entities.Ciment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CimentRequest {
    private  String nom;
    private String description;
    private String dateCreation;
    private String typeCiment;
    private String classification;
    private float poids;
    private float resistance;
    private String fournisseur;
    private  String  wilaya;
    private Ciment.Etat etat;
}
