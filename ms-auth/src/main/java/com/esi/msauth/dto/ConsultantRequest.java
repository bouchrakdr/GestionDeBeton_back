package com.esi.msauth.dto;

import com.esi.msauth.entities.Consultant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultantRequest {
   private String nom;
   private String prenom;
    private String email;
    private String numero;
    private Boolean compte;
    private Consultant.Filiale filiale;
}
