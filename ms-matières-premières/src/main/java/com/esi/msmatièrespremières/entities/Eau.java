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
public class Eau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idEau;

    private  String nom;
    private String description;
    private Date dateCreation;
    private String type;
    private String couleur;
    private float poids;
    private float teneur;
    private String fournisseur;







}

