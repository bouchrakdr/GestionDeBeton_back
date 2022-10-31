package com.esi.msmatièrespremières.controller;
import com.esi.msmatièrespremières.helper.ExcelHelper;
import com.esi.msmatièrespremières.message.ResponseMessage;
import com.esi.msmatièrespremières.proxy.Proxy;
import com.esi.msmatièrespremières.service.ExcelService;
import com.esi.msmatièrespremières.DTO.*;
import com.esi.msmatièrespremières.Repositories.*;
import com.esi.msmatièrespremières.entities.*;
import com.esi.msmatièrespremières.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@CrossOrigin(origins = "http://localhost:4200/")
//@CrossOrigin("*")
@RequestMapping("api/matieres")

@AllArgsConstructor
public class AdminController {

    private  final Proxy proxy;

    private final AdminService adminPrincipaleService;
    private final CimentRepository cimentRepository;
    private final GravierRepository gravierRepository;
    private final SableRepository sableRepository;
    private final EauRepository eauRepository;
    private final AdjuvantsRepository adjuvantsRepository;
    private final WilayaRepository wilayaRepository;

    @GetMapping("/getadmin/{idAdmin}")
    public ResponseEntity<AdminDTO> findAdminById(@PathVariable Long idAdmin) {
        AdminDTO adminDTO = proxy.getAdminById(idAdmin);
        return new ResponseEntity<>(adminDTO,
                HttpStatus.OK);
    }



// *******************************Ciment***************************************//

    @PostMapping("/ajouterCiment")
    public ResponseEntity<ResponceMsg> ajouterCiment(@RequestBody CimentRequest cimentRequest) throws ParseException {
        ResponceMsg responceMsg = adminPrincipaleService.ajouterCiment(cimentRequest);
        if (responceMsg.getMsg().equals("p1")) {
            return new ResponseEntity<>(new ResponceMsg("Ciment déja ajouté"),
                    HttpStatus.CREATED);
        } else if (responceMsg.getMsg().equals("p2")) {
            return new ResponseEntity<>(new ResponceMsg("This director already exist"),
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(responceMsg,
                    HttpStatus.OK);
        }
    }

    @GetMapping("/ciments")
    public ResponseEntity<List<Ciment>> getAllciment() {
        List<Ciment> ciments = adminPrincipaleService.findAllciment();
        return new ResponseEntity<>(ciments, HttpStatus.OK);
    }

    @GetMapping("/ciment/{idCiment}")
    public ResponseEntity<Ciment> findCimentById(@PathVariable Long idCiment) {
        Ciment ciment = cimentRepository.findCimentByIdCiment(idCiment);
        return new ResponseEntity<>(ciment,
                HttpStatus.OK);
    }
    @GetMapping("/cimentExist/{idCiment}")
   Boolean existsCimentByIdCiment(@PathVariable Long idCiment) {

       Boolean ci = cimentRepository.existsCimentByIdCiment(idCiment);

        return ci;
    }
/*
    @PutMapping("/modifierCiment/{idCiment}")
    public ResponseEntity<Ciment> updateCiment(@PathVariable Long idCiment, @RequestBody CimentRequest cimentRequest) {
        return new ResponseEntity<Ciment>(adminPrincipaleService.modifierCiment(idCiment, cimentRequest), HttpStatus.OK);
    }
*/
    @PutMapping("/modifierEtat/{idCiment}")
    public ResponseEntity<Ciment> updateEtatD(@PathVariable Long idCiment) throws ParseException{
    return new ResponseEntity<Ciment>(adminPrincipaleService.modifierEtatCiment(idCiment), HttpStatus.OK);
}
    @PutMapping("/modifierEtatFin/{idCiment}")
    public ResponseEntity<Ciment> updateEtatFin(@PathVariable Long idCiment) throws ParseException{
        return new ResponseEntity<Ciment>(adminPrincipaleService.modifierEtatCimentFin(idCiment), HttpStatus.OK);
    }

    @DeleteMapping("/supprimerCiment/{id}")
    public ResponseEntity<ResponceMsg> deleteCiment(@PathVariable("id") Long id) {
        adminPrincipaleService.supprimerCiment(id);
        return new ResponseEntity<ResponceMsg>(new ResponceMsg("ciment deleted successfully"), HttpStatus.OK);
    }

    @GetMapping("/nombreCiments")
    public ResponseEntity<Long> findnombreCiments() {
        return new ResponseEntity<>(cimentRepository.count(),
                HttpStatus.OK);
    }


    @Autowired
    ExcelService fileService;
    @GetMapping("/downloadCiment")
    public ResponseEntity<Resource> getFileciment() {
        String filename = "Liste des ciments.xlsx";
        InputStreamResource file = new InputStreamResource(fileService.loadCiments());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

    @PostMapping("/uploadCiment")
    public ResponseEntity<ResponseMessage> uploadFileCiment(@RequestParam("file") MultipartFile file) throws InterruptedException {
        String message = "";
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                fileService.saveCiments(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
    // *******************************Sable***************************************//

    @PostMapping("/ajouterSable")
    public ResponseEntity<ResponceMsg> ajouterSable(@RequestBody SableRequest sableRequest) throws ParseException{
        if (adminPrincipaleService.ajouterSable(sableRequest).equals("p")) {
            return new ResponseEntity<>(new ResponceMsg("Sable  déja ajouté"),
                    HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(new ResponceMsg("Sable ajouté avec succes"),
                    HttpStatus.OK);
        }


    }

    @GetMapping("/sables")
    public ResponseEntity<List<Sable>> getAllsable() {
        List<Sable> sables = adminPrincipaleService.findAllsable();
        return new ResponseEntity<>(sables, HttpStatus.OK);
    }

    @GetMapping("/sable/{idSable}")
    public ResponseEntity<Sable> findSableById(@PathVariable Long idSable) {

        Sable sable = sableRepository.findSableByIdSable(idSable);

        return new ResponseEntity<>(sable,
                HttpStatus.OK);
    }

    @PutMapping("/modifierSable/{idSable}")
    public ResponseEntity<Sable> updateSable(@PathVariable Long idSable, @RequestBody SableRequest sableRequest) throws ParseException{
        return new ResponseEntity<Sable>(adminPrincipaleService.modifierSable(idSable, sableRequest), HttpStatus.OK);

    }


        @DeleteMapping("/supprimerSable/{id}")
    public ResponseEntity<ResponceMsg> deleteSable(@PathVariable("id") Long id){
        adminPrincipaleService.supprimerSable(id);
        return new ResponseEntity<ResponceMsg>(new ResponceMsg("sable deleted successfully"),HttpStatus.OK);
    }

    @GetMapping("/nombreSables")
    public ResponseEntity<Long> findnombreSables() {
        return new ResponseEntity<>(sableRepository.count(),
                HttpStatus.OK);
    }

    @GetMapping("/downloadSable")
    public ResponseEntity<Resource> getFileSable() {
        String filename = "Liste des sables.xlsx";
        InputStreamResource file = new InputStreamResource(fileService.loadSables());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

    @PostMapping("/uploadSable")
    public ResponseEntity<ResponseMessage> uploadFileSable(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                fileService.saveSables(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
//*******************************Gravier***************************************//
@PostMapping("/ajouterGravier")
public ResponseEntity<ResponceMsg> ajouterGravier(@RequestBody GravierRequest gravierRequest) throws ParseException{
    if (adminPrincipaleService.ajouterGravier(gravierRequest).equals("p")) {
        return new ResponseEntity<>(new ResponceMsg("Gravier  déja ajouté"),
                HttpStatus.CONFLICT);
    } else {
        return new ResponseEntity<>(new ResponceMsg("Gravier ajouté avec succes"),
                HttpStatus.OK);
    }


}

    @GetMapping("/garviers")
    public ResponseEntity<List<Gravier>> getAllgravier() {
        List<Gravier> graviers= adminPrincipaleService.findAllgravier();
        return new ResponseEntity<>(graviers, HttpStatus.OK);
    }

    @GetMapping("/gravier/{idGravier}")
    public ResponseEntity<Gravier> findGravierById(@PathVariable Long idGravier) {

        Gravier gravier = gravierRepository.findGravierByIdGravier(idGravier);

        return new ResponseEntity<>(gravier,
                HttpStatus.OK);
    }

    @PutMapping("/modifierGravier/{idGravier}")
    public ResponseEntity<Gravier> updateGravier(@PathVariable Long idGravier, @RequestBody GravierRequest gravierRequest) throws ParseException{
        return new ResponseEntity<Gravier>(adminPrincipaleService.modifierGravier(idGravier, gravierRequest), HttpStatus.OK);

    }
    @DeleteMapping("/supprimerGravier/{id}")
    public ResponseEntity<ResponceMsg> deleteGravier(@PathVariable("id") Long id){
        adminPrincipaleService.supprimerGravier(id);
        return new ResponseEntity<ResponceMsg>(new ResponceMsg("gravier deleted successfully"),HttpStatus.OK);
    }

    @GetMapping("/nombreGraviers")
    public ResponseEntity<Long> findnombreGraviers() {
        return new ResponseEntity<>(gravierRepository.count(),
                HttpStatus.OK);
    }

    @GetMapping("/downloadGravier")
    public ResponseEntity<Resource> getFileGravier() {
        String filename = "Liste des graviers.xlsx";
        InputStreamResource file = new InputStreamResource(fileService.loadGraviers());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

    @PostMapping("/uploadGravier")
    public ResponseEntity<ResponseMessage> uploadFileGravier(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                fileService.saveGraviers(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
    // *******************************Eau***************************************//

    @PostMapping("/ajouterEau")
    public ResponseEntity<ResponceMsg> ajouterEau(@RequestBody EauRequest eauRequest) throws ParseException {
        if (adminPrincipaleService.ajouterEau(eauRequest).equals("p")) {
            return new ResponseEntity<>(new ResponceMsg(" Eau déja ajouté"),
                    HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(new ResponceMsg("Eau ajouté avec succes"),
                    HttpStatus.OK);
        }


    }

    @GetMapping("/eaux")
    public ResponseEntity<List<Eau>> getAllEaux() {
        List<Eau> eaux= adminPrincipaleService.findAllEaux();
        return new ResponseEntity<>(eaux, HttpStatus.OK);
    }

    @GetMapping("/eau/{idEau}")
    public ResponseEntity<Eau> findEauById(@PathVariable Long idEau) {

        Eau eau = eauRepository.findEauByIdEau(idEau);

        return new ResponseEntity<>(eau,
                HttpStatus.OK);
    }

    @PutMapping("/modifierEau/{idEau}")
    public ResponseEntity<Eau> updateEau(@PathVariable Long idEau, @RequestBody EauRequest eauRequest) throws ParseException {
        return new ResponseEntity<Eau>(adminPrincipaleService.modifierEau(idEau, eauRequest), HttpStatus.OK);

    }
    @DeleteMapping("/supprimerEau/{id}")
    public ResponseEntity<ResponceMsg> deleteEau(@PathVariable("id") Long id){
        adminPrincipaleService.supprimerEau(id);
        return new ResponseEntity<ResponceMsg>(new ResponceMsg("eau deleted successfully"),HttpStatus.OK);
    }

    @GetMapping("/downloadEau")
    public ResponseEntity<Resource> getFileEau() {
        String filename = "Liste des eaux.xlsx";
        InputStreamResource file = new InputStreamResource(fileService.loadEaux());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

    @PostMapping("/uploadEau")
    public ResponseEntity<ResponseMessage> uploadFileEau(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                fileService.saveEaux(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
    // *******************************Adjuvants***************************************//

    @PostMapping("/ajouterAdjuvants")
    public ResponseEntity<ResponceMsg> ajouterAdjuvants(@RequestBody AdjuvantsRequest adjuvantsRequest) throws ParseException {
        if (adminPrincipaleService.ajouterAdjuvants(adjuvantsRequest).equals("p")) {
            return new ResponseEntity<>(new ResponceMsg(" adjuvants déja ajouté"),
                    HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(new ResponceMsg("adjuvants ajouté avec succes"),
                    HttpStatus.OK);
        }
    }

    @GetMapping("/adjuvants")
    public ResponseEntity<List<Adjuvants>> getAllAdjuvants() {
        List<Adjuvants>  adjuvants= adminPrincipaleService.findAllAdjuvants();
        return new ResponseEntity<>(adjuvants, HttpStatus.OK);
    }

    @GetMapping("/adjuvants/{idAdjuvants}")
    public ResponseEntity<Adjuvants> findAdjuvantsById(@PathVariable Long idAdjuvants) {

      Adjuvants adjuvants = adjuvantsRepository.findAdjuvantsByIdAdjuvants(idAdjuvants);

        return new ResponseEntity<>(adjuvants,
                HttpStatus.OK);
    }

    @PutMapping("/modifierAdjuvants/{idAdjuvants}")
    public ResponseEntity<Adjuvants> updateAdjuvants(@PathVariable Long idAdjuvants, @RequestBody AdjuvantsRequest adjuvantsRequest) throws ParseException {
        return new ResponseEntity<Adjuvants>(adminPrincipaleService.modifierAdjuvants(idAdjuvants, adjuvantsRequest), HttpStatus.OK);

    }
    @DeleteMapping("/supprimerAdjuvants/{id}")
    public ResponseEntity<ResponceMsg> deleteAdjuvants(@PathVariable("id") Long id){
        adminPrincipaleService.supprimerAdjuvants(id);
        return new ResponseEntity<ResponceMsg>(new ResponceMsg("Adjuvants deleted successfully"),HttpStatus.OK);
    }

    @GetMapping("/nombreAdjuvants")
    public ResponseEntity<Long> findnombreAdjuvants() {
        return new ResponseEntity<>(adjuvantsRepository.count(),
                HttpStatus.OK);
    }

    @GetMapping("/downloadAdjuvant")
    public ResponseEntity<Resource> getFileAdjuvant() {
        String filename = "Liste des adjuvants.xlsx";
        InputStreamResource file = new InputStreamResource(fileService.loadAdjuvants());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

    @PostMapping("/uploadAdjuvant")
    public ResponseEntity<ResponseMessage> uploadFileAdjuvants(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                fileService.saveAdjuvants(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

//*********************************PROXY******************************************//
@GetMapping("/getCiment/{idCiment}")
public CimentDTO getCimentById(@PathVariable Long idCiment) {
 Ciment ciment = cimentRepository.findCimentByIdCiment(idCiment);
 CimentDTO cimentDTO =new CimentDTO();
    cimentDTO.setNom(ciment.getNom());
    cimentDTO.setDescription(ciment.getDescription());
    cimentDTO.setDateCreation(ciment.getDateCreation());
    cimentDTO.setTypeCiment(ciment.getTypeCiment());
    cimentDTO.setClassification(ciment.getClassification());
    cimentDTO.setPoids(ciment.getPoids());
    cimentDTO.setResistance(ciment.getResistance());
    cimentDTO.setFournisseur(ciment.getFournisseur());
    cimentDTO.setEtat(ciment.getEtat());
    cimentDTO.setWilaya(ciment.getWilaya().getNom());
    return cimentDTO;
}
//*****************************FIN******************************************//




    @GetMapping("/wilayas")
    public ResponseEntity<List<Wilaya>> findAllWilayas(){
        List<Wilaya> wilayas=wilayaRepository.findAll();
        return new ResponseEntity<>(wilayas, HttpStatus.OK);
    }








}
