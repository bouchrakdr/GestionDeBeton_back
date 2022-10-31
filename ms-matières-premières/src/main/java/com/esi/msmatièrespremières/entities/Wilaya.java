package com.esi.msmatièrespremières.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wilaya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idWilaya;
    String nom;

    @JsonIgnore
    @OneToMany(mappedBy ="wilaya")
    private Collection<Ciment> ciments;

}
