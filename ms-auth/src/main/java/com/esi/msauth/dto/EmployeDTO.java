package com.esi.msauth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDTO {
        String nom;
        String prenom;
        @Email
        @NotEmpty(message = "Email is required")
        private String email;
        private String numero;
}
