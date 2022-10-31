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
public class Gravier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idGravier;

    private  String nom;
    private String description;

    private Date dateCreation;
    private String typeGravier;

    private String nature;
    private String forme;
    private float poids;
    private float resistance;
    private String fournisseur;


    @ManyToOne
    private Wilaya wilaya;



}
