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
public class Sable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idSable;

    private  String nom;
    private String description;

    private Date dateCreation;
    private String nature;

    private String couleur;
    private String forme;
    private float poids;
    private float resistance;
    private String fournisseur;


    @ManyToOne
    private Wilaya wilaya;



}
