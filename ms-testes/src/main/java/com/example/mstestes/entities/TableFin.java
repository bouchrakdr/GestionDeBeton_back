package com.example.mstestes.entities;

import com.example.mstestes.DTO.CimentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableFin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private float resistanceComp;
    private float poidPrisme;
    private String consistance;
    private String debutPrise;
    private String finPrise;
    private String observation;
    private Long idCiment;

    @Transient
    private CimentDTO ciment;
}
