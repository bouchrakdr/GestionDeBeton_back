package com.example.msbeton.service;

import com.example.msbeton.DTO.FormuleRequest;
import com.example.msbeton.DTO.ResponceMsg;
import com.example.msbeton.DTO.TestBetondbRequest;
import com.example.msbeton.entities.Formule;
import com.example.msbeton.entities.TestBetondb;
import com.example.msbeton.repositories.FormuleRepository;
import com.example.msbeton.repositories.TestBetondbRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
@AllArgsConstructor
public class AdminService {

    private final FormuleRepository formuleRepository;

    private final TestBetondbRepository testBetondbRepository;


    public ResponceMsg ajouterFormule(FormuleRequest formuleRequest) throws ParseException {
        if (formuleRepository.existsFormuleByNom(formuleRequest.getNom())) {
            return new ResponceMsg("p1");

        } else {
            Formule formule = new Formule();
            formule.setNom(formuleRequest.getNom());
            formule.setDescription(formuleRequest.getDescription());
            formule.setDateC((new SimpleDateFormat("dd-MM-yyyy").parse(formuleRequest.getDateC())));
            formule.setTypeM(formuleRequest.getTypeM());
            formule.setTmg(formuleRequest.getTmg());
            formule.setSpG(formuleRequest.getSpG());
            formule.setUtilisation(formuleRequest.getUtilisation());
            formule.setUtilP(formuleRequest.getUtilP());
            formule.setRc28(formuleRequest.getRc28());
            formule.setCa(formuleRequest.getCa());
            formule.setCe(formuleRequest.getCe());
            formule.setRatio(formuleRequest.getRatio());
            formule.setRatioM(formuleRequest.getRatioM());
            formule.setContC(formuleRequest.getContC());
            formule.setVolume(formuleRequest.getVolume());
            formule.setAir(formuleRequest.getAir());
            formule.setAff(formuleRequest.getAff());

            formuleRepository.save(formule);
            ResponceMsg responceMsg = new ResponceMsg();

            responceMsg.setMsg("Formule ajouté avec succes");
            return responceMsg;

        }
    }

    public List<Formule> findAllformules() {
        return formuleRepository.findAll();
    }


    public ResponceMsg ajouterTestdb(TestBetondbRequest testBetondbRequest) throws ParseException {
        if (testBetondbRepository.existsTestBetondbByCode(testBetondbRequest.getCode())) {
            return new ResponceMsg("p1");

        } else {
            TestBetondb testBetondb = new TestBetondb();
            testBetondb.setCode(testBetondbRequest.getCode());
            testBetondb.setDateCol(new SimpleDateFormat("dd-MM-yyyy").parse(testBetondbRequest.getDateCol()));
            testBetondb.setClient(testBetondbRequest.getClient());
            testBetondb.setFc(testBetondbRequest.getFc());
            testBetondb.setDciment(testBetondbRequest.getDciment());
            testBetondb.setDmax(testBetondbRequest.getDmax());
            testBetondb.setNbEcy(testBetondbRequest.getNbEcy());
            testBetondb.setNbEc(testBetondbRequest.getNbEc());
            testBetondb.setRcm(testBetondbRequest.getRcm());
            testBetondb.setRce(testBetondbRequest.getRce());

            testBetondbRepository.save(testBetondb);
            ResponceMsg responceMsg = new ResponceMsg();
            responceMsg.setMsg("Test ajouté avec succes");
            return responceMsg;
        }
    }

    public List<TestBetondb> findAlltestesdb() {
        return testBetondbRepository.findAll();
    }
}



