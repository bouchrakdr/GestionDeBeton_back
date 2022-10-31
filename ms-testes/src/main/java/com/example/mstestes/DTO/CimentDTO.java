package com.example.mstestes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CimentDTO {
    private  String nom;
    private String description;
    private Date dateCreation;
    private String typeCiment;
    private String Classification;
    private float poids;
    private float resistance;
    private String fournisseur;

    public enum Etat{
        Tester,NonTester,EnCours
    }
    @Enumerated(EnumType.STRING)
    private CimentDTO.Etat etat;
}


