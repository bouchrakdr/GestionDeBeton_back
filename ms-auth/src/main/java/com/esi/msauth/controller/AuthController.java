package com.esi.msauth.controller;


import com.esi.msauth.Repositories.CompteRepository;

import com.esi.msauth.dto.LoginRequest;
import com.esi.msauth.dto.LoginResponce;

import com.esi.msauth.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;


    private final CompteRepository compteRepository;



    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public LoginResponce login(@RequestBody LoginRequest loginRequest) {

        return authService.login(loginRequest);
    }



    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", OK);
    }



    @PostMapping("/activer/{idCompte}")
    public ResponseEntity<String> activer(@PathVariable Long idCompte) {
        authService.activer(idCompte);
        String var="compte active";
        return new ResponseEntity<>(var,
                HttpStatus.OK);
    }
    @PostMapping("/desactiver/{idCompte}")
    public ResponseEntity<String> desactiver(@PathVariable Long idCompte) {
        authService.desactiver(idCompte);
        return new ResponseEntity<>(
                HttpStatus.OK);
    }






}
