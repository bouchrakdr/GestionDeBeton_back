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
public class Ciment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idCiment;
    private  String nom;
    private String description;
    private Date dateCreation;
    private String typeCiment;
    private String classification;
    private float poids;
    private float resistance;
    private String fournisseur;

    public enum Etat{
        Tester,NonTester,EnCours
    }
    @Enumerated(EnumType.STRING)
    private Ciment.Etat etat;


    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }


    @ManyToOne
    private Wilaya wilaya;

}
