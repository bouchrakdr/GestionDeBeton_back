package com.example.msbeton.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestBetondb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String code;
    private Date dateCol;
    private String client;
    private String fc;
    private int dciment;
    private int dmax;
    private int nbEcy;
    private int nbEc;
    private float rcm;
    private float rce;



}

