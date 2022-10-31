package com.esi.msauth.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idCompte;
    String username;
    String password;
    String type;
    private Instant created;
    private boolean enabled;

@JsonIgnore
    @OneToOne (mappedBy = "compte")
    private Employe employe;


    @JsonIgnore
    @OneToOne (mappedBy = "compte")
    private Consultant consultant;

}
