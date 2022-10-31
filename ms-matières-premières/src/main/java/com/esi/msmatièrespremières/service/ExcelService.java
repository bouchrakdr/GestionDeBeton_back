package com.esi.msmatièrespremières.service;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.List;

import com.esi.msmatièrespremières.Repositories.*;
import com.esi.msmatièrespremières.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esi.msmatièrespremières.helper.ExcelHelper;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class ExcelService {
    @Autowired
    CimentRepository cimentRepository;
    public ByteArrayInputStream loadCiments() {
        List<Ciment> lciment = cimentRepository.findAll();
        ByteArrayInputStream in = ExcelHelper.cimentsToExcel(lciment);
        return in;
    }

    public void saveCiments(MultipartFile file) {
        try {
            List<Ciment> lciments = ExcelHelper.excelToCiments(file.getInputStream());
            cimentRepository.saveAll(lciments);
        } catch (IOException | ParseException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }


    @Autowired
    AdjuvantsRepository adjuvantsRepository;
    public ByteArrayInputStream loadAdjuvants() {
        List<Adjuvants> ladjuvant = adjuvantsRepository.findAll();
        ByteArrayInputStream in = ExcelHelper.AdjuvantToExcel(ladjuvant);
        return in;
    }

    public void saveAdjuvants(MultipartFile file) {
        try {
            List<Adjuvants> ladjuvant = ExcelHelper.excelToAdjuvants(file.getInputStream());
            adjuvantsRepository.saveAll(ladjuvant);
        } catch (IOException | ParseException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    @Autowired
    GravierRepository gravierRepository;
    public ByteArrayInputStream loadGraviers() {
        List<Gravier> lgravier = gravierRepository.findAll();
        ByteArrayInputStream in = ExcelHelper.GravierToExcel(lgravier);
        return in;
    }

    public void saveGraviers(MultipartFile file) {
        try {
            List<Gravier> lgravier = ExcelHelper.excelToGraviers(file.getInputStream());
            gravierRepository.saveAll(lgravier);
        } catch (IOException | ParseException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    @Autowired
    EauRepository eauRepository;
    public ByteArrayInputStream loadEaux() {
        List<Eau> leau = eauRepository.findAll();
        ByteArrayInputStream in = ExcelHelper.EauToExcel(leau);
        return in;
    }

    public void saveEaux(MultipartFile file) {
        try {
            List<Eau> leau = ExcelHelper.excelToEau(file.getInputStream());
            eauRepository.saveAll(leau);
        } catch (IOException | ParseException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    @Autowired
    SableRepository sableRepository;
    public ByteArrayInputStream loadSables() {
        List<Sable> lsable = sableRepository.findAll();
        ByteArrayInputStream in = ExcelHelper.SablesToExcel(lsable);
        return in;
    }

    public void saveSables(MultipartFile file) {
        try {
            List<Sable> lsable = ExcelHelper.excelToSables(file.getInputStream());
            sableRepository.saveAll(lsable);
        } catch (IOException | ParseException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

}