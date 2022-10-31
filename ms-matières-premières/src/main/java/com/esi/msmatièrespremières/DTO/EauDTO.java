package com.esi.msmatièrespremières.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data@NoArgsConstructor
@AllArgsConstructor
public class EauDTO {
    private  String nom;
    private String description;
    private Date dateCreation;
    private String type;
    private String couleur;
    private float poids;
    private float teneur;
}
