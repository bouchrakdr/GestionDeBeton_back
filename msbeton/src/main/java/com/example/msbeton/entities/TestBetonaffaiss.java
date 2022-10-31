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
public class TestBetonaffaiss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
private float at0;
    private float at1;
    private float at2;
    private float at3;
    private float at4;


}
