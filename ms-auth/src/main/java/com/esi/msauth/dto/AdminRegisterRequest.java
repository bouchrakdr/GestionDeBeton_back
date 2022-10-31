package com.esi.msauth.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRegisterRequest {
    private String nom;
    private String prenom;
    private String email;
    private String numero;
    private Boolean compte;


}

