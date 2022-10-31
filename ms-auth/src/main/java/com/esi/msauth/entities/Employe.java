package com.esi.msauth.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idEmploye;
    String nom;
    String prenom;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    private String numero;
    @OneToOne
    private Compte compte;



}
