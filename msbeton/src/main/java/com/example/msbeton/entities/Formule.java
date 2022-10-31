package com.example.msbeton.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nom;
    private String description;
    private Date dateC;
    private String typeM;
    private String spG;
    private String utilisation;
    private String utilP;
    private float rc28;
    private String ca;
    private float tmg;
    private String ce;
    private float ratio;
    private float ratioM;
    private float contC;
    private float volume;
    private float air;
    private float aff;

    @JsonIgnore
    @OneToMany(mappedBy ="formule")
    private Collection<TestBetonfin> testBetonfins;




}
