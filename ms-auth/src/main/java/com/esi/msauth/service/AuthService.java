package com.esi.msauth.service;

import com.esi.msauth.Repositories.*;
import com.esi.msauth.dto.LoginRequest;
import com.esi.msauth.dto.LoginResponce;
import com.esi.msauth.exceptions.SpringRedditException;
import com.esi.msauth.entities.Compte;
import com.esi.msauth.model.VerificationToken;
import com.esi.msauth.repository.VerificationTokenRepository;
import com.esi.msauth.security.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final CompteRepository compteRepository;
    private final EmployeRepository employeRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final AdminRepository adminRepository;
    private final ConsultantRepository consultantRepository;

    public Compte ajouterCompte(String nom, String prenom, String type) {
        String username = nom + '.' + prenom;
        if (compteRepository.existsCompteByUsernameAndType(username, type)) {
            username = nom + "_" + prenom;
        }
        Compte compte = new Compte();
        compte.setUsername(username);
        compte.setPassword(passwordEncoder.encode("123"));
        compte.setType(type);
        compte.setCreated(Instant.now());
        compte.setEnabled(true);
        compteRepository.save(compte);
        generateVerificationToken(compte);
        //activer(compte.getIdCompte());
        System.out.println("compte ajouté");
        return compte;

    }

    public Compte modifierCompte(Long id, String nom, String prenom, Boolean enabled) {
        Compte compte = compteRepository.findByIdCompte(id);
        compte.setUsername(nom + "." + prenom);
        compte.setEnabled(enabled);
        return compte;
    }

    public String generateVerificationToken(Compte compte) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setCompte(compte);
        verificationTokenRepository.save(verificationToken);
        return token;
    }
    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        verificationToken.orElseThrow(() -> new SpringRedditException("Invalid Token"));
        fetchUserAndEnable(verificationToken.get());
    }

    @Transactional
    public void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getCompte().getUsername();
        Compte compte = compteRepository.findByUsername(username).orElseThrow(() -> new SpringRedditException("User not found  " + username));
        compte.setEnabled(true);
        compteRepository.save(compte);
    }

    @Transactional
    public void desactiver(Long idCompte) {
        Compte compte = compteRepository.findByIdCompte(idCompte);
        compte.setEnabled(false);
        compteRepository.save(compte);
    }

    @Transactional
    public void activer(Long idCompte) {
        Compte compte = compteRepository.findByIdCompte(idCompte);
        compte.setEnabled(true);
        compteRepository.save(compte);
    }

    public LoginResponce login(LoginRequest loginRequest) {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        //System.out.println("autontificateeeeeeeeeeeeeee"+authenticate);
        String token = jwtProvider.generateToken(authenticate);
        // System.out.println("tokeeeeeeeeeeeeeeeen"+token);
        LoginResponce loginResponce = new LoginResponce();
        String type = compteRepository.findCompteByUsername(loginRequest.getUsername()).getType();
        System.out.println(type);
        loginResponce.setType(type);
        loginResponce.setAuthenticationToken(token);
        Long idCompte = compteRepository.findCompteByUsername(loginRequest.getUsername()).getIdCompte();
        System.out.println("id compteeeeeeeeeee    " + idCompte);
        //  System.out.println("id hopitaaal   "+adminRepository.findAdminByCompte_IdCompte(idCompte).getHopital().getIdHopital());
     /*   switch (type){
            case "admin" : loginResponce.setIdHopital(adminRepository.findAdminByCompte_IdCompte(idCompte).getHopital().getIdHopital());
           // case "chef service":loginResponce.setIdHopital(serviceRepository.findServiceByChefService_IdChefService(chefServiceRepository.findChefServiceByCompte_IdCompte(idCompte).getIdChefService()).getHopital().getIdHopital());
            default: loginResponce.setIdHopital(500L);
        }
*/
       if (type.equals("employe")) {
            loginResponce.setNom(employeRepository.findEmployeByCompte_IdCompte(idCompte).getNom());
            loginResponce.setPrenom(employeRepository.findEmployeByCompte_IdCompte(idCompte).getPrenom());
            loginResponce.setEmail(employeRepository.findEmployeByCompte_IdCompte(idCompte).getEmail());
            loginResponce.setNumero(employeRepository.findEmployeByCompte_IdCompte(idCompte).getNumero());
            loginResponce.setUsername(employeRepository.findEmployeByCompte_IdCompte(idCompte).getCompte().getUsername());


        }

     else if (type.equals("consultant")) {
        loginResponce.setNom(consultantRepository.findConsultantByCompte_IdCompte(idCompte).getNom());
        loginResponce.setPrenom(consultantRepository.findConsultantByCompte_IdCompte(idCompte).getPrenom());
        loginResponce.setEmail(consultantRepository.findConsultantByCompte_IdCompte(idCompte).getEmail());
        loginResponce.setNumero(consultantRepository.findConsultantByCompte_IdCompte(idCompte).getNumero());
        loginResponce.setUsername(consultantRepository.findConsultantByCompte_IdCompte(idCompte).getCompte().getUsername());
        loginResponce.setFiliale(consultantRepository.findConsultantByCompte_IdCompte(idCompte).getFiliale());
     }
     else  if (type.equals("admin")) {
            loginResponce.setNom(adminRepository.findAdminByCompte_IdCompte(idCompte).getNom());
            loginResponce.setPrenom(adminRepository.findAdminByCompte_IdCompte(idCompte).getPrenom());
            loginResponce.setEmail(adminRepository.findAdminByCompte_IdCompte(idCompte).getEmail());
            loginResponce.setNumero(adminRepository.findAdminByCompte_IdCompte(idCompte).getNumero());
            loginResponce.setUsername(adminRepository.findAdminByCompte_IdCompte(idCompte).getCompte().getUsername());


        }

            // adminRepository.findAdminByCompte_IdCompte(idCompte).getHopital().getIdHopital()
            return loginResponce;
            //return new AuthenticationResponse(token, loginRequest.getUsername());


        }

    }







