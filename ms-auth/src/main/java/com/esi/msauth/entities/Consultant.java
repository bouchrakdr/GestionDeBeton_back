package com.esi.msauth.entities;

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
public class Consultant {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long idConsultant;

        String nom;
        public String prenom;
        @Email
        @NotEmpty(message = "Email is required")
        private String email;
        private String numero;
        public enum Filiale{
            BTPH,TECNA
        }
        @Enumerated(EnumType.STRING)
        private com.esi.msauth.entities.Consultant.Filiale  filiale;

        @OneToOne
        private Compte compte;


    }
