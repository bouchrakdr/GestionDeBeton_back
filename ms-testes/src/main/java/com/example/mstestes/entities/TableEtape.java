package com.example.mstestes.entities;

import com.example.mstestes.DTO.CimentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableEtape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Date dateE;
    private float resistanceF;
    private float rune;
    private float rde;

    public enum Etape{
        Etape1,Etape2,Etape3
    }
    @Enumerated(EnumType.STRING)
    private TableEtape.Etape etape;
    private Long idCiment;

    @Transient
    private CimentDTO ciment;
}
