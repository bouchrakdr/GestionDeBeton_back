package com.example.mstestes.controller;

import com.example.mstestes.DTO.*;
import com.example.mstestes.entities.TableDebut;
import com.example.mstestes.entities.TableEtape;
import com.example.mstestes.entities.TableFin;
import com.example.mstestes.proxy.Proxy;
import com.example.mstestes.repositeries.TableDebutRepository;
import com.example.mstestes.repositeries.TableEtapeRepository;
import com.example.mstestes.repositeries.TableFinRepository;
import com.example.mstestes.service.AdminService;
import com.example.mstestes.service.ExcelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("api/test")

@AllArgsConstructor
public class AdminController {
    private final Proxy proxy;
    private final TableDebutRepository tableDebutRepository;
    private final TableEtapeRepository tableEtapeRepository;
    private final AdminService adminService;
    private final TableFinRepository tableFinRepository;

    @GetMapping("/getciment/{idCiment}")
    public ResponseEntity<CimentDTO> findCimentById(@PathVariable Long idCiment) {
        CimentDTO cimentDTO = proxy.getCimentById(idCiment);

        return new ResponseEntity<>(cimentDTO,
                HttpStatus.OK);
    }

    @GetMapping("/getAdmin/{idAdmin}")
    public ResponseEntity<AdminDTO> findAdminById(@PathVariable Long idAdmin) {
        AdminDTO adminDTO = proxy.getAdminById(idAdmin);
        return new ResponseEntity<>(adminDTO,
                HttpStatus.OK);
    }

    @GetMapping("/cimentExist/{idCiment}")
    public Boolean existsCimentByIdCiment(@PathVariable Long idCiment) {
        boolean ci = proxy.existsCimentByIdCiment(idCiment);
        return ci;
    }
    @PutMapping("/modifierEtat/{idCiment}")
    public ResponseEntity<CimentDTO> ModifierEtatById(@PathVariable Long idCiment) {
        CimentDTO cimentDTO = proxy.modifierEtatById(idCiment);
        return new ResponseEntity<>(cimentDTO,
                HttpStatus.OK);
    }
    @PutMapping("/modifierEtatFin/{idCiment}")
    public ResponseEntity<CimentDTO> ModifierEtatFinById(@PathVariable Long idCiment) {
        CimentDTO cimentDTO = proxy.modifierEtatFinById(idCiment);
        return new ResponseEntity<>(cimentDTO,
                HttpStatus.OK);
    }


    @PostMapping("/ajouterTableDebut/{idCiment}")
    public ResponseEntity<ResponseMsg> ajouterTableDebut(@PathVariable Long idCiment, @RequestBody TableDebutRequest tableDebutRequest) throws ParseException {
        if (adminService.ajouterTableDebut(idCiment, tableDebutRequest).equals("p")) {
            return new ResponseEntity<>(new ResponseMsg(" ce ciment a deja un test debut"),
                    HttpStatus.CREATED);
        } else if (adminService.ajouterTableDebut(idCiment, tableDebutRequest).equals("s1")) {
            return new ResponseEntity<>(new ResponseMsg("Ciment n'existe pas"),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseMsg("test du debut  ajouté avec succés"),
                    HttpStatus.OK);
        }
    }

    @GetMapping("/TableDebuts")
    public List<TableDebut> getAllTableDebuts() {
        List<TableDebut> tableDebuts = tableDebutRepository.findAll();
        tableDebuts.forEach((e) -> {
            e.setCiment(proxy.getCimentById(e.getIdCiment()));

        });
        return tableDebuts;
    }


    @GetMapping("/TableDebut/{id}")
    public ResponseEntity<TableDebut> findTestCimentdbById(@PathVariable Long id) {
        TableDebut tableDebut = tableDebutRepository.findTableDebutById(id);
        CimentDTO cimentDTO = proxy.getCimentById(tableDebut.getIdCiment());
        tableDebut.setCiment(cimentDTO);
        return new ResponseEntity<>(tableDebut,
                HttpStatus.OK);
    }
    @GetMapping("/TableDe/{idCiment}")
    public ResponseEntity<Object> findTableDebutById(@PathVariable Long idCiment) {
        TableDebut tableDebut = tableDebutRepository.findTableDebutByIdCiment(idCiment);
        CimentDTO cimentDTO = proxy.getCimentById(tableDebut.getIdCiment());
        tableDebut.setCiment(cimentDTO);

        return new ResponseEntity<>(tableDebut,HttpStatus.OK);
    }


    @PostMapping("/ajouterTableEtape/{idCiment}")
    public ResponseEntity<ResponseMsg> ajouterTableEtape(@PathVariable Long idCiment, @RequestBody TableEtapeRequest tableEtapeRequest) throws ParseException {

        if (adminService.ajouterTableEtape(idCiment, tableEtapeRequest).equals("s1")) {
            return new ResponseEntity<>(new ResponseMsg("Ciment n'existe pas"),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseMsg("test  ajouté avec succés"),
                    HttpStatus.OK);
        }
    }

    @GetMapping("/TableEtapes")
    public List<TableEtape> getAllTableEtapes() {
        List<TableEtape> tableEtapes = tableEtapeRepository.findAll();
        tableEtapes.forEach((e) -> {
            e.setCiment(proxy.getCimentById(e.getIdCiment()));

        });
        return tableEtapes;
    }

    @GetMapping("/TableEtape/{idCiment}")
    public List<TableEtape> findTableEtapeById(@PathVariable Long idCiment) {
      List<TableEtape> tableEtape = tableEtapeRepository.findTableEtapeByIdCiment(idCiment);
        System.out.println(tableEtape);
        tableEtape.forEach((e) -> {
            e.setCiment(proxy.getCimentById(e.getIdCiment()));

        });
        return  tableEtape;

    }


    @PostMapping("/ajouterTableFin/{idCiment}")
    public ResponseEntity<ResponseMsg> ajouterTableFin(@PathVariable Long idCiment, @RequestBody TableFinRequest tableFinRequest) throws ParseException {
        if (adminService.ajouterTableFin(idCiment, tableFinRequest).equals("p")) {
            return new ResponseEntity<>(new ResponseMsg(" ce ciment a deja un test fin"),
                    HttpStatus.CREATED);
        } else if (adminService.ajouterTableFin(idCiment, tableFinRequest).equals("s1")) {
            return new ResponseEntity<>(new ResponseMsg("Ciment n'existe pas"),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseMsg("test du fin  ajouté avec succés"),
                    HttpStatus.OK);
        }
    }


    @GetMapping("/TableFins")
    public List<TableFin> getAllTableFins() {
        List<TableFin> tableFins = tableFinRepository.findAll();
        tableFins.forEach((e) -> {
            e.setCiment(proxy.getCimentById(e.getIdCiment()));

        });
        return tableFins;
    }

    @GetMapping("/TableFin/{id}")
    public ResponseEntity<TableFin> findTestCimentfinById(@PathVariable Long id) {
        TableFin tableFin = tableFinRepository.findTableFinById(id);
        CimentDTO cimentDTO = proxy.getCimentById(tableFin.getIdCiment());
       tableFin.setCiment(cimentDTO);
        return new ResponseEntity<>(tableFin,
                HttpStatus.OK);
    }
    @GetMapping("/TableFe/{idCiment}")
    public ResponseEntity<TableFin> findTableFinById(@PathVariable Long idCiment) {
        TableFin tableFin = tableFinRepository.findTableFinByIdCiment(idCiment);
        CimentDTO cimentDTO = proxy.getCimentById(tableFin.getIdCiment());
        tableFin.setCiment(cimentDTO);
        return new ResponseEntity<>(tableFin,
                HttpStatus.OK);
    }


   /* @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    ExcelService fileService;


   @GetMapping("/downloadTestCiment")
    public ResponseEntity<Resource> getFile() {
        String filename = "Liste des tests des ciments.xlsx";
        InputStreamResource file = new InputStreamResource(fileService.loadTestCiments());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }


   /* @PostMapping("/uploadTestCiment")
    public ResponseEntity<ResponseMessage> uploadFileCiment(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                fileService.saveTestCiments(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }*/

}
