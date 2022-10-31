package com.example.msbeton.controller;
import com.example.msbeton.DTO.*;

import com.example.msbeton.entities.Formule;
import com.example.msbeton.entities.TestBetondb;
import com.example.msbeton.proxy.Proxy;
import com.example.msbeton.repositories.*;
import com.example.msbeton.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("api/beton")


@AllArgsConstructor
public class AdminController {

    private final Proxy proxy;

    private final AdminService adminPrincipaleService;
    private final FormuleRepository formuleRepository;


    @GetMapping("/getadmin/{idAdmin}")
    public ResponseEntity<AdminDTO> findAdminById(@PathVariable Long idAdmin) {

        AdminDTO adminDTO = proxy.getAdminById(idAdmin);

        return new ResponseEntity<>(adminDTO,
                HttpStatus.OK);
    }

    @PostMapping("/ajouterFormule")
    public ResponseEntity<ResponceMsg> ajouterFormule(@RequestBody FormuleRequest formuleRequest) throws ParseException {
        ResponceMsg responceMsg = adminPrincipaleService.ajouterFormule(formuleRequest);
        if (responceMsg.getMsg().equals("p1")) {
            return new ResponseEntity<>(new ResponceMsg("Formule déja ajouté"),
                    HttpStatus.CREATED);
        } else if (responceMsg.getMsg().equals("p2")) {
            return new ResponseEntity<>(new ResponceMsg("This director already exist"),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(responceMsg,
                    HttpStatus.OK);
        }
    }

    @GetMapping("/formules")
    public ResponseEntity<List<Formule>> getAllformules() {
        List<Formule> formules = adminPrincipaleService.findAllformules();
        return new ResponseEntity<>(formules, HttpStatus.OK);
    }

    @GetMapping("/formule/{idFormule}")
    public ResponseEntity<Formule> findFormuleById(@PathVariable Long idFormule) {

        Formule formule = formuleRepository.findFormuleById(idFormule);

        return new ResponseEntity<>(formule,
                HttpStatus.OK);
    }

    @GetMapping("/nombreFormulrs")
    public ResponseEntity<Long> findnombreFormules() {
        return new ResponseEntity<>(formuleRepository.count(),
                HttpStatus.OK);
    }

    @PostMapping("/ajouterTestdb")
    public ResponseEntity<ResponceMsg> ajouterTestdb(@RequestBody TestBetondbRequest testBetondbRequest) throws ParseException {
        ResponceMsg responceMsg = adminPrincipaleService.ajouterTestdb(testBetondbRequest);
        if (responceMsg.getMsg().equals("p1")) {
            return new ResponseEntity<>(new ResponceMsg("Test debut déja ajouté"),
                    HttpStatus.CREATED);
        } else if (responceMsg.getMsg().equals("p2")) {
            return new ResponseEntity<>(new ResponceMsg("Test existe"),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(responceMsg,
                    HttpStatus.OK);
        }
    }

    @GetMapping("/testsdb")
    public ResponseEntity<List<TestBetondb>> getAlltestesdb() {
        List<TestBetondb> testBetondbs = adminPrincipaleService.findAlltestesdb();
        return new ResponseEntity<>(testBetondbs, HttpStatus.OK);
    }


}


