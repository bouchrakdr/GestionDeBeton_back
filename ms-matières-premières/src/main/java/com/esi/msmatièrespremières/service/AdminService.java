package com.esi.msmatièrespremières.service;

import com.esi.msmatièrespremières.DTO.*;
import com.esi.msmatièrespremières.Repositories.*;
import com.esi.msmatièrespremières.entities.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private final CimentRepository cimentRepository;
    private final WilayaRepository wilayaRepository;
    private final GravierRepository gravierRepository;
    private final SableRepository sableRepository;
    private final EauRepository eauRepository;
    private final AdjuvantsRepository adjuvantsRepository;

    //******************************Ciment**********************************//

    public ResponceMsg ajouterCiment(CimentRequest cimentRequest) throws ParseException {
        if (cimentRepository.existsCimentByNomAndWilaya_Nom(cimentRequest.getNom(), cimentRequest.getWilaya())) {
            return new ResponceMsg("p1");

        } else {
            Ciment ciment = new Ciment();
            ciment.setNom(cimentRequest.getNom());
            ciment.setDescription(cimentRequest.getDescription());
            ciment.setDateCreation(new SimpleDateFormat("dd-MM-yyyy").parse(cimentRequest.getDateCreation()));
            ciment.setTypeCiment(cimentRequest.getTypeCiment());
            ciment.setClassification(cimentRequest.getClassification());
            ciment.setPoids(cimentRequest.getPoids());
            ciment.setResistance(cimentRequest.getResistance());
            ciment.setFournisseur(cimentRequest.getFournisseur());
            ciment.setWilaya(wilayaRepository.findWilayaByNom(cimentRequest.getWilaya()));
            ciment.setEtat(Ciment.Etat.NonTester);
            cimentRepository.save(ciment);
            ResponceMsg responceMsg = new ResponceMsg();
            responceMsg.setId(ciment.getIdCiment());
            responceMsg.setMsg("Ciment ajouté avec succes");
            return responceMsg;

        }
    }

    public List<Ciment> findAllciment() {
        return cimentRepository.findAll();
    }

    /*
        public Ciment modifierCiment(Long id, CimentRequest cimentRequest){
            Ciment ciment = cimentRepository.findCimentByIdCiment(id);
            ciment.setNom(cimentRequest.getNom());
            ciment.setDescription(cimentRequest.getDescription());
            ciment.setDateCreation(cimentRequest.getDateCreation());
            ciment.setTypeCiment(cimentRequest.getTypeCiment());
            ciment.setClassification(cimentRequest.getClassification());
            ciment.setPoids(cimentRequest.getPoids());
            ciment.setResistance(cimentRequest.getResistance());
            ciment.setWilaya(wilayaRepository.findWilayaByNom(cimentRequest.getWilaya()));
            cimentRepository.save(ciment);
            return ciment;

        }
        */
    public Ciment modifierEtatCiment(Long id) throws ParseException{
        Ciment ciment = cimentRepository.findCimentByIdCiment(id);
        ciment.setEtat(Ciment.Etat.EnCours);
        cimentRepository.save(ciment);
        return ciment;
    }
    public Ciment modifierEtatCimentFin(Long id) throws ParseException{
        Ciment ciment = cimentRepository.findCimentByIdCiment(id);
        ciment.setEtat(Ciment.Etat.Tester);
        cimentRepository.save(ciment);
        return ciment;
    }

    @Transactional
    public void supprimerCiment(Long id) {
        cimentRepository.deleteCimentByIdCiment(id);
    }

    //******************************Fournisseur**********************************//


    public String ajouterSable(SableRequest sableRequest) throws ParseException{
        String s = sableRequest.getNom();
        if (sableRepository.existsSableByNom(s)) {
            return "p";
        } else {
            Sable sable = new Sable();
            sable.setNom(sableRequest.getNom());
            sable.setDescription(sableRequest.getDescription());
            sable.setDateCreation(new SimpleDateFormat("dd-MM-yyyy").parse(sableRequest.getDateCreation()));
            sable.setNature(sableRequest.getNature());
            sable.setCouleur(sableRequest.getCouleur());
            sable.setForme(sableRequest.getForme());
            sable.setPoids(sableRequest.getPoids());
            sable.setResistance(sableRequest.getResistance());
            sable.setFournisseur(sableRequest.getFournisseur());
            sable.setWilaya(wilayaRepository.findWilayaByNom(sableRequest.getWilaya()));
            sableRepository.save(sable);
            ResponceMsg responceMsg = new ResponceMsg();
            responceMsg.setId(sable.getIdSable());
            responceMsg.setMsg("sable ajouté avec succes");
            return "s";
        }
    }

    public List<Sable> findAllsable() {
        return sableRepository.findAll();
    }

    public Sable modifierSable(Long id, SableRequest sableRequest) throws ParseException{
        Sable sable = sableRepository.findSableByIdSable(id);
        sable.setNom(sableRequest.getNom());
        sable.setDescription(sableRequest.getDescription());
        sable.setDateCreation(new SimpleDateFormat("dd-MM-yyyy").parse(sableRequest.getDateCreation()));
        sable.setNature(sableRequest.getNature());
        sable.setForme(sableRequest.getForme());
        sable.setPoids(sableRequest.getPoids());
        sable.setCouleur(sableRequest.getCouleur());
        sable.setFournisseur(sableRequest.getFournisseur());
        sable.setResistance(sableRequest.getResistance());
        sable.setWilaya(wilayaRepository.findWilayaByNom(sableRequest.getWilaya()));
        sableRepository.save(sable);
        return sable;

    }

    @Transactional
    public void supprimerSable(Long id) {
        sableRepository.deleteSableByIdSable(id);
    }

    //******************************Gravier**********************************//

    public String ajouterGravier(GravierRequest gravierRequest)throws ParseException {
        String s = gravierRequest.getNom();
        if (gravierRepository.existsGravierByNom(s)) {
            return "p";
        } else {
            Gravier gravier = new Gravier();
            gravier.setNom(gravierRequest.getNom());
            gravier.setDescription(gravierRequest.getDescription());
            gravier.setDateCreation(new SimpleDateFormat("dd-MM-yyyy").parse(gravierRequest.getDateCreation()));
            gravier.setNature(gravierRequest.getNature());
            gravier.setForme(gravierRequest.getForme());
            gravier.setTypeGravier(gravierRequest.getTypeGravier());
            gravier.setPoids(gravierRequest.getPoids());
            gravier.setResistance(gravierRequest.getResistance());
            gravier.setFournisseur(gravierRequest.getFournisseur());
            gravier.setWilaya(wilayaRepository.findWilayaByNom(gravierRequest.getWilaya()));
            gravierRepository.save(gravier);
            ResponceMsg responceMsg = new ResponceMsg();
            responceMsg.setId(gravier.getIdGravier());
            responceMsg.setMsg(" gravier ajouté avec succes");
            return "s";
        }
    }

    public List<Gravier> findAllgravier() {
        return gravierRepository.findAll();
    }

    public Gravier modifierGravier(Long id, GravierRequest gravierRequest) throws ParseException{
        Gravier gravier = gravierRepository.findGravierByIdGravier(id);
        gravier.setNom(gravierRequest.getNom());
        gravier.setDescription(gravierRequest.getDescription());
        gravier.setDateCreation(new SimpleDateFormat("dd-MM-yyyy").parse(gravierRequest.getDateCreation()));
        gravier.setNature(gravierRequest.getNature());
        gravier.setForme(gravierRequest.getForme());
        gravier.setPoids(gravierRequest.getPoids());
        gravier.setTypeGravier(gravierRequest.getTypeGravier());
        gravier.setResistance(gravierRequest.getResistance());
        gravier.setFournisseur(gravierRequest.getFournisseur());
        gravier.setWilaya(wilayaRepository.findWilayaByNom(gravierRequest.getWilaya()));
        gravierRepository.save(gravier);
        return gravier;

    }

    @Transactional
    public void supprimerGravier(Long id) {
        gravierRepository.deleteGravierByIdGravier(id);
    }

    //******************************Eau**********************************//

    public String ajouterEau(EauRequest eauRequest)throws ParseException {
        String s = eauRequest.getNom();
        if (eauRepository.existsEauByNom(s)) {
            return "p";
        } else {
            Eau eau = new Eau();
            eau.setNom(eauRequest.getNom());
            eau.setDescription(eauRequest.getDescription());
            eau.setDateCreation(new SimpleDateFormat("dd-MM-yyyy").parse(eauRequest.getDateCreation()));
            eau.setType(eauRequest.getType());
            eau.setPoids(eauRequest.getPoids());
            eau.setCouleur(eauRequest.getCouleur());
            eau.setTeneur(eauRequest.getTeneur());
            eau.setFournisseur(eauRequest.getFournisseur());
            eauRepository.save(eau);
            ResponceMsg responceMsg = new ResponceMsg();
            responceMsg.setId(eau.getIdEau());
            responceMsg.setMsg(" eau ajouté avec succes");
            return "s";
        }
    }

    public List<Eau> findAllEaux() {
        return eauRepository.findAll();
    }

    public Eau modifierEau(Long id, EauRequest eauRequest) throws ParseException{
        Eau eau = eauRepository.findEauByIdEau(id);
        eau.setNom(eauRequest.getNom());
        eau.setDescription(eauRequest.getDescription());
        eau.setDateCreation(new SimpleDateFormat("dd-MM-yyyy").parse(eauRequest.getDateCreation()));
        eau.setType(eauRequest.getType());
        eau.setTeneur(eauRequest.getTeneur());
        eau.setPoids(eauRequest.getPoids());
        eau.setFournisseur(eauRequest.getFournisseur());
        eau.setCouleur(eauRequest.getCouleur());
        eauRepository.save(eau);
        return eau;

    }

    @Transactional
    public void supprimerEau(Long id) {
        eauRepository.deleteEauByIdEau(id);
    }

    //******************************Adjuvants**********************************//

    public String ajouterAdjuvants(AdjuvantsRequest adjuvantsRequest)throws ParseException {
        String s = adjuvantsRequest.getNom();
        if (adjuvantsRepository.existsAdjuvantsByNom(s)) {
            return "p";
        } else {
            Adjuvants adjuvants = new Adjuvants();
            adjuvants.setNom(adjuvantsRequest.getNom());
            adjuvants.setDescription(adjuvantsRequest.getDescription());
            adjuvants.setDateCreation(new SimpleDateFormat("dd-MM-yyyy").parse(adjuvantsRequest.getDateCreation()));
            adjuvants.setType(adjuvantsRequest.getType());
            adjuvants.setPoids(adjuvantsRequest.getPoids());
            adjuvants.setCouleur(adjuvantsRequest.getCouleur());
            adjuvants.setTeneur(adjuvantsRequest.getTeneur());
            adjuvants.setBase_chimique(adjuvantsRequest.getBase_chimique());
            adjuvants.setDosage(adjuvantsRequest.getDosage());
            adjuvants.setFonctionP(adjuvantsRequest.getFonctionP());
            adjuvants.setFonctionS(adjuvantsRequest.getFonctionS());
            adjuvants.setFournisseur(adjuvantsRequest.getFournisseur());
            adjuvantsRepository.save(adjuvants);
            ResponceMsg responceMsg = new ResponceMsg();
            responceMsg.setId(adjuvants.getIdAdjuvants());
            responceMsg.setMsg(" Adjuvants ajouté avec succes");
            return "s";
        }
    }

    public List<Adjuvants> findAllAdjuvants() {
        return adjuvantsRepository.findAll();
    }

    public Adjuvants modifierAdjuvants(Long id, AdjuvantsRequest adjuvantsRequest) throws ParseException{
        Adjuvants adjuvants = adjuvantsRepository.findAdjuvantsByIdAdjuvants(id);
        adjuvants.setNom(adjuvantsRequest.getNom());
        adjuvants.setDescription(adjuvantsRequest.getDescription());
        adjuvants.setDateCreation(new SimpleDateFormat("dd-MM-yyyy").parse(adjuvantsRequest.getDateCreation()));
        adjuvants.setType(adjuvantsRequest.getType());
        adjuvants.setPoids(adjuvantsRequest.getPoids());
        adjuvants.setCouleur(adjuvantsRequest.getCouleur());
        adjuvants.setTeneur(adjuvantsRequest.getTeneur());
        adjuvants.setBase_chimique(adjuvantsRequest.getBase_chimique());
        adjuvants.setDosage(adjuvantsRequest.getDosage());
        adjuvants.setFonctionP(adjuvantsRequest.getFonctionP());
        adjuvants.setFonctionS(adjuvantsRequest.getFonctionS());
        adjuvantsRepository.save(adjuvants);
        return adjuvants;

    }

    @Transactional
    public void supprimerAdjuvants(Long id) {
        adjuvantsRepository.deleteAdjuvantsByIdAdjuvants(id);
    }

}



