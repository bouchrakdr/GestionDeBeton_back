package com.esi.msauth.service;

import com.esi.msauth.Repositories.*;
import com.esi.msauth.dto.AdminRegisterRequest;
import com.esi.msauth.dto.ConsultantRequest;
import com.esi.msauth.dto.EmployeRequest;
import com.esi.msauth.entities.*;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminPrincipaleService {
    private final PasswordEncoder passwordEncoder;

    private final CompteRepository compteRepository;

    private final MailService mailService;
    private final AuthService authService;
    private final EmployeRepository employeRepository;
    private final AdminRepository adminRepository;
    private final ConsultantRepository consultantRepository;

//*********************************************** Ajouter_Employe*******************************//
public String ajouterEmploye(EmployeRequest employeRequest) {
    if (employeRepository.existsEmployeByNomAndPrenom(employeRequest.getNom(), employeRequest.getPrenom())) {
        return "p";
    } else {
       Employe employe = new Employe();
        employe.setNom(employeRequest.getNom());
        employe.setPrenom(employeRequest.getPrenom());
       employe.setNumero(employeRequest.getNumero());
        employe.setEmail(employeRequest.getEmail());
       employe.setCompte(authService.ajouterCompte(employe.getNom(), employe.getPrenom(), "employe"));
        employeRepository.save(employe);


        return "s";

    }
}
    public List<Employe> findAllEmployes() {
        return employeRepository.findAll();
    }
    public List<Consultant> findAllConsultants() {
        return consultantRepository.findAll();
    }
//*********************************************** Ajouter_Admin*******************************//
    public String ajouterAdmin(AdminRegisterRequest adminRegisterRequest) {
        if (adminRepository.existsAdminByNomAndPrenom(adminRegisterRequest.getNom(), adminRegisterRequest.getPrenom())) {
            return "p";
        } else {
            Admin admin = new Admin();
            admin.setNom(adminRegisterRequest.getNom());
            admin.setPrenom(adminRegisterRequest.getPrenom());
            admin.setNumero(adminRegisterRequest.getNumero());
            admin.setEmail(adminRegisterRequest.getEmail());
            admin.setCompte(authService.ajouterCompte(admin.getNom(), admin.getPrenom(), "admin"));
            adminRepository.save(admin);

            return "s";

        }
    }
    //*********************************************** Ajouter_Consultant*******************************//
        public String ajouterConsultant(ConsultantRequest consultantRequest) {
        if (consultantRepository.existsConsultantByNomAndPrenom(consultantRequest.getNom(), consultantRequest.getPrenom())) {
            return "p";
        } else {
            Consultant consultant = new Consultant();
            consultant.setNom(consultantRequest.getNom());
            consultant.setPrenom(consultantRequest.getPrenom());
            consultant.setNumero(consultantRequest.getNumero());
            consultant.setEmail(consultantRequest.getEmail());
            consultant.setFiliale(consultantRequest.getFiliale());
            consultant.setCompte(authService.ajouterCompte(consultant.getNom(), consultant.getPrenom(), "consultant"));
            consultantRepository.save(consultant);
            return "s";

        }
    }






























}









