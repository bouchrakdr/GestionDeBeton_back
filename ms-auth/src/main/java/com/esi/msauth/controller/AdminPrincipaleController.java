package com.esi.msauth.controller;

import com.esi.msauth.Repositories.*;
import com.esi.msauth.dto.AdminRegisterRequest;
import com.esi.msauth.dto.ConsultantRequest;
import com.esi.msauth.dto.EmployeRequest;
import com.esi.msauth.dto.ResponceMsg;

import com.esi.msauth.entities.Admin;
import com.esi.msauth.entities.Consultant;
import com.esi.msauth.entities.Employe;
import com.esi.msauth.service.AdminPrincipaleService;
import com.esi.msauth.service.AuthService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.text.ParseException;
import java.util.List;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("api/auth")

@AllArgsConstructor
public class AdminPrincipaleController {

    private final AuthService authService;
    private final AdminPrincipaleService adminPrincipaleService;
    private final EmployeRepository employeRepository;
    private final CompteRepository compteRepository;
    private final AdminRepository adminRepository;
    private final ConsultantRepository consultantRepository;


    // ******************************* Ajout_Employe***************************************//

    @PostMapping("/ajouterEmploye")
    public ResponceMsg ajouterEmploye(@RequestBody EmployeRequest employeRequest) {
        if (adminPrincipaleService.ajouterEmploye(employeRequest).equals("p")) {
            return new ResponceMsg("Employe already added");
        } else {
            return new ResponceMsg("Employe successully added");
        }
    }
    @GetMapping("/employe/{idEmploye}")
    public ResponseEntity<Employe> findEmployeById(@PathVariable Long idEmploye) {

        Employe employe = employeRepository.findEmployeByIdEmploye(idEmploye);

        return new ResponseEntity<>(employe,
                HttpStatus.OK);
    }
        @GetMapping("/employes")
    public ResponseEntity<List<Employe>> getAllEmployes() {
        List<Employe>  employes= adminPrincipaleService.findAllEmployes();
        return new ResponseEntity<>(employes, HttpStatus.OK);
    }

// *******************************Ajout_Admin***************************************//
    @PostMapping("/ajouterAdmin")
    public ResponceMsg ajouterAdmin(@RequestBody AdminRegisterRequest adminRegisterRequest) {
    if (adminPrincipaleService.ajouterAdmin(adminRegisterRequest).equals("p")) {
        return new ResponceMsg("Admin already added");
    } else {
        return new ResponceMsg("Admine successully added");
    }
}
    @GetMapping("/admin/{idAdmin}")
    public ResponseEntity<Admin> findAdminById(@PathVariable Long idAdmin) {

            Admin admin = adminRepository.findAdminByIdAdmin(idAdmin);

        return new ResponseEntity<>(admin,
                HttpStatus.OK);
    }

    // *******************************Ajout_Consultant***************************************//
    @PostMapping("/ajouterConsultant")
    public ResponceMsg ajouterConsultant(@RequestBody ConsultantRequest consultantRequest) {
        if (adminPrincipaleService.ajouterConsultant(consultantRequest).equals("p")) {
            return new ResponceMsg("Consultant already added");
        } else {
            return new ResponceMsg("Consultant successully added");
        }
    }
    @GetMapping("/consultant/{idConsultant}")
    public ResponseEntity<Consultant> findConsultantById(@PathVariable Long idConsultant) {

        Consultant consultant = consultantRepository.findConsultantByIdConsultant(idConsultant);

        return new ResponseEntity<>(consultant,
                HttpStatus.OK);
    }

    @GetMapping("/consultants")
    public ResponseEntity<List<Consultant>> getAllConsultants() {
        List<Consultant>  consultants= adminPrincipaleService.findAllConsultants();
        return new ResponseEntity<>(consultants ,HttpStatus.OK);
    }
    @GetMapping("/nombreComptes")
    public ResponseEntity<Long> findComptes() {
        return new ResponseEntity<>(compteRepository.count(),
                HttpStatus.OK);
    }

//*****************************FIN******************************************//










}
