package com.example.mstestes.service;

import com.example.mstestes.DTO.*;
import com.example.mstestes.entities.*;
import com.example.mstestes.proxy.Proxy;
import com.example.mstestes.repositeries.*;
import com.sun.org.apache.xpath.internal.operations.And;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@AllArgsConstructor
public class  AdminService {
    private final TableDebutRepository tableDebutRepository;
    private final TableEtapeRepository tableEtapeRepository;
    private final TableFinRepository tableFinRepository;

    Proxy cimentProxy;



    //*****************************AJOUT******************************//
    public String ajouterTableDebut(Long idCiment, TableDebutRequest tableDebutRequest) throws ParseException {
        if (tableDebutRepository.existsTableDebutByIdCiment(idCiment)) {
            return "p";
        } else if (cimentProxy.existsCimentByIdCiment(idCiment)) {
            TableDebut tableDebut = new TableDebut();
            tableDebut.setDateTest(new SimpleDateFormat("dd-MM-yyyy").parse(tableDebutRequest.getDateTest()));
            tableDebut.setTemperature(tableDebutRequest.getTemperature());
            tableDebut.setIdCiment(idCiment);
            cimentProxy.modifierEtatById(idCiment);
            tableDebut.setEtat(TableDebut.Etat.Debut);

            tableDebutRepository.save(tableDebut);
            return "s";
        } else {
            return "s1";
        }


    }
    public TableDebut modifierEtatDebut(Long id) throws ParseException{
        TableDebut tableDebut = tableDebutRepository.findTableDebutByIdCiment(id);
        tableDebut.setEtat(TableDebut.Etat.EnCours);
        tableDebutRepository.save(tableDebut);
        return tableDebut;
    }
    public TableDebut modifierEtatFin(Long id) throws ParseException{
        TableDebut tableDebut = tableDebutRepository.findTableDebutByIdCiment(id);
        tableDebut.setEtat(TableDebut.Etat.Terminer);
        tableDebutRepository.save(tableDebut);
        return tableDebut;
    }

    public List<TableDebut> findAllTableDebuts() {
        return tableDebutRepository.findAll();
    }

    public String ajouterTableEtape(Long idCiment, TableEtapeRequest tableEtapeRequest) throws ParseException {
        if (cimentProxy.existsCimentByIdCiment(idCiment)) {

                TableEtape tableEtape = new TableEtape();
                tableEtape.setDateE(new SimpleDateFormat("dd-MM-yyyy").parse(tableEtapeRequest.getDateE()));
                tableEtape.setResistanceF(tableEtapeRequest.getResistanceF());
                tableEtape.setRune(tableEtapeRequest.getRune());
                tableEtape.setRde(tableEtapeRequest.getRde());
                tableEtape.setEtape(tableEtapeRequest.getEtape());
                tableEtape.setIdCiment(idCiment);
                modifierEtatDebut(idCiment);
                tableEtapeRepository.save(tableEtape);
                return "s";

        }
        else {return "s1";}
    }


    public TableEtape findTableEtapeById( Long id) {
        return tableEtapeRepository.findTableEtap2eById(id);
    }


    public String ajouterTableFin(Long idCiment, TableFinRequest tableFinRequest) throws ParseException {
        if (tableFinRepository.existsTableFinByIdCiment(idCiment)) {
            return "p";
        } else if (cimentProxy.existsCimentByIdCiment(idCiment)) {
            TableFin tableFin = new TableFin();
            tableFin.setResistanceComp(tableFinRequest.getResistanceComp());
            tableFin.setPoidPrisme(tableFinRequest.getPoidPrisme());
            tableFin.setConsistance(tableFinRequest.getConsistance());
            tableFin.setDebutPrise(tableFinRequest.getDebutPrise());
            tableFin.setFinPrise(tableFinRequest.getFinPrise());
            tableFin.setObservation(tableFinRequest.getObservation());
            tableFin.setIdCiment(idCiment);
            cimentProxy.modifierEtatFinById(idCiment);
            modifierEtatFin(idCiment);;
            tableFinRepository.save(tableFin);
            return "s";
        } else {
            return "s1";
        }
    }
}

   /* public String ajouterTestDejCiment(Long idCiment, CimentTest2jRequest cimentTest2jRequest) throws ParseException {
        if (testCiment2jRepository.existsTestCiment2jByIdCiment(idCiment)) {
            return "p";
        } else if (cimentProxy.existsCimentByIdCiment(idCiment)) {
            TableEtape tableEtape = new TableEtape();
            tableEtape.setDatec2(new SimpleDateFormat("dd-MM-yyyy").parse(cimentTest2jRequest.getDatec2()));
            tableEtape.setRf2(cimentTest2jRequest.getRf2());
            tableEtape.setRune2(cimentTest2jRequest.getRune2());
            tableEtape.setRde2(cimentTest2jRequest.getRde2());
            tableEtape.setIdCiment(idCiment);
            testCiment2jRepository.save(tableEtape);
            return "s";
        } else {
            return "s1";
        }
    }


    public String ajouterTestSeptCiment(Long idCiment, CimentTest7jRequest cimentTest7jRequest) throws ParseException {
        if (testCiment7jRepository.existsTestCiment7jByIdCiment(idCiment)) {
            return "p";
        } else if (cimentProxy.existsCimentByIdCiment(idCiment)) {
            TestCiment7j testCiment7j = new TestCiment7j();
            testCiment7j.setDatec7(new SimpleDateFormat("dd-MM-yyyy").parse(cimentTest7jRequest.getDatec7()));
            testCiment7j.setRf7(cimentTest7jRequest.getRf7());
            testCiment7j.setRune7(cimentTest7jRequest.getRune7());
            testCiment7j.setRde7(cimentTest7jRequest.getRde7());
            testCiment7j.setIdCiment(idCiment);
            testCiment7jRepository.save(testCiment7j);
            return "s";
        } else {
            return "s1";
        }
    }


    public String ajouterTestVhCiment(Long idCiment, TableEtapeRequest tableEtapeRequest) throws ParseException {
        if (tableEtapeRepository.existsTestCiment28jByIdCiment(idCiment)) {
            return "p";
        } else if (cimentProxy.existsCimentByIdCiment(idCiment)) {
            TestCiment28j testCiment28j = new TestCiment28j();
            testCiment28j.setDatec28(new SimpleDateFormat("dd-MM-yyyy").parse(tableEtapeRequest.getDatec28()));
            testCiment28j.setRf28(tableEtapeRequest.getRf28());
            testCiment28j.setRune28(tableEtapeRequest.getRune28());
            testCiment28j.setRde28(tableEtapeRequest.getRde28());
            testCiment28j.setIdCiment(idCiment);
            tableEtapeRepository.save(testCiment28j);
            return "s";
        } else {
            return "s1";
        }
    }


    public String ajouterTestFinCiment(Long idCiment, TableFinRequest cimentTestfinRequest) throws ParseException {
        if (testCimentFinRepository.existsTestCimentfinByIdCiment(idCiment)) {
            return "p";
        } else if (cimentProxy.existsCimentByIdCiment(idCiment)) {
            TableFin tableFin = new TableFin();
            tableFin.setResistanceComp(cimentTestfinRequest.getResistanceComp());
            tableFin.setPoidPrisme(cimentTestfinRequest.getPoidPrisme());
            tableFin.setConsistance(cimentTestfinRequest.getConsistance());
            tableFin.setDebutPrise(cimentTestfinRequest.getDebutPrise());
            tableFin.setFinPrise(cimentTestfinRequest.getFinPrise());
            tableFin.setObservation(cimentTestfinRequest.getObservation());
            tableFin.setIdCiment(idCiment);
            testCimentFinRepository.save(tableFin);
            return "s";
        } else {
            return "s1";
        }
    }
}
*/



