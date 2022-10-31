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
public class TableDebut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Date dateTest;
    private float temperature;
    private Long idCiment;

    public enum Etat{
        Debut,Terminer,EnCours
    }
    @Enumerated(EnumType.STRING)
    private TableDebut.Etat etat;
    @Transient
    private CimentDTO ciment;
}
