package com.esi.msauthldap;

import com.esi.msauthldap.config.SecurityConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;
@RequestMapping("api")
@RestController
class LoginController {


    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) throws Exception {
        System.out.println("***************************************************************");
       
            return new ResponseEntity("succecfully", OK);
        }

    }
