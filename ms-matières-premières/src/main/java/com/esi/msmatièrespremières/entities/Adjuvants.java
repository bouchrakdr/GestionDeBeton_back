package com.esi.msmatièrespremières.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adjuvants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idAdjuvants;

    private  String nom;
    private String description;
    private Date dateCreation;
    private String type;
    private String Base_chimique;
    private float dosage;
    private float teneur;
    private String couleur;
    private float poids;
    private String fonctionP;
    private String fonctionS;
    private String fournisseur;

}

