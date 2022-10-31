package com.example.msbeton.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestBeton3_7j {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Date dateEcra;
    private float poidEv18;
    private float poidEv28;
    private float charge18;
    private float charge28;
    private int nbJour;
    private float rc18;
    private float rc28;
    private float rcm;
    private float rce;
}
