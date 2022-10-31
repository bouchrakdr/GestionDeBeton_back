package com.esi.msauth.dto;

import com.esi.msauth.entities.Consultant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponce {
    private String authenticationToken;
    private String type;
    private String nom;
    private String prenom;
    private String email;
    private String numero;
    private String username;
    private Consultant.Filiale filiale;
    private Long idUser;
}
