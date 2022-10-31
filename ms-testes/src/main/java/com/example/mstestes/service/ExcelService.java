package com.example.mstestes.service;

import com.example.mstestes.entities.*;
import com.example.mstestes.helper.ExcelHelper;
import com.example.mstestes.repositeries.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class ExcelService {
    /*
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TableDebutRepository testdbrepository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TestCiment2jRepository test2reprository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TestCiment7jRepository test7reprository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TableEtapeRepository test28reprository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TableFinRepository testfinrepository;


    public ByteArrayInputStream loadTestCiments() {
        List<TableDebut> lcimdb = testdbrepository.findAll();
        List<TableEtape> lcim2 = test2reprository.findAll();
        List<TestCiment7j> lcim7 = test7reprository.findAll();
        List<TestCiment28j> lcim28 = test28reprository.findAll();
        List<TableFin> lcimfin = testfinrepository.findAll();
        ByteArrayInputStream in = ExcelHelper.cimentsTestToExcel(lcimdb, lcim2, lcim7, lcim28, lcimfin);

        return in;
    }


   /* public void saveTestCiments(MultipartFile file) {
        try {
            List<TestCiment2j> lcimdb = ExcelHelper.excelToTestCiments(file.getInputStream());
            //List<TestCiment2j> lcim2 = ExcelHelper.excelToTestCiments(file.getInputStream());
            //List<TestCiment7j> lcim7 = ExcelHelper.excelToTestCiments(file.getInputStream());
            //List<TestCiment28j> lcim28 = ExcelHelper.excelToTestCiments(file.getInputStream());
            //List<TestCimentfin> lcimfin = ExcelHelper.excelToTestCiments(file.getInputStream());
            testdbrepository.saveAll(lcimdb);
            //test2reprository.saveAll(lcim2);
            //test7reprository.saveAll(lcim7);
            //test28reprository.saveAll(lcim28);
            //testfinrepository.saveAll(lcimfin);
        } catch (IOException | ParseException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }*/
}
