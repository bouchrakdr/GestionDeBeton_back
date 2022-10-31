package com.esi.msmatièrespremières.helper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.esi.msmatièrespremières.entities.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.web.multipart.MultipartFile;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    //static String SHEET = "Liste des ciments";
    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static ByteArrayInputStream cimentsToExcel(List<Ciment> Lciments) throws  NullPointerException{
        String SHEET = "Liste des ciments";
        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // Creating header
            Cell cell = row.createCell(0);
            cell.setCellValue("Id Ciment");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(1);
            cell.setCellValue("Nom");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(2);
            cell.setCellValue("Description");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(3);
            cell.setCellValue("Date de creation");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(4);
            cell.setCellValue("Type");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(5);
            cell.setCellValue("Classification");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(6);
            cell.setCellValue("Poids");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(7);
            cell.setCellValue("Résistance");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(8);
            cell.setCellValue("Fournisseur");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(9);
            cell.setCellValue("Wilaya");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(10);
            cell.setCellValue("Etat");
            cell.setCellStyle(headerCellStyle);


            int rowIdx = 1;
            for (Ciment cim : Lciments) {
                Row datarow = sheet.createRow(rowIdx++);
                datarow.createCell(0).setCellValue(cim.getIdCiment());
                datarow.createCell(1).setCellValue(cim.getNom());
                datarow.createCell(2).setCellValue(cim.getDescription());
                datarow.createCell(3).setCellValue(cim.getDateCreation());
                datarow.createCell(4).setCellValue(cim.getTypeCiment());
                datarow.createCell(5).setCellValue(cim.getClassification());
                datarow.createCell(6).setCellValue(cim.getPoids());
                datarow.createCell(7).setCellValue(cim.getResistance());
                datarow.createCell(8).setCellValue(cim.getFournisseur());
                datarow.createCell(9).setCellValue(cim.getWilaya().getIdWilaya());
                datarow.createCell(10).setCellValue(cim.getEtat().name());
            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);
            sheet.autoSizeColumn(10);

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }



    public static ByteArrayInputStream AdjuvantToExcel(List<Adjuvants> Ladjuvants) {
        String SHEET = "Liste des adjuvants";
        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // Creating header
            Cell cell = row.createCell(0);
            cell.setCellValue("Id Adjuvants");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(1);
            cell.setCellValue("Nom");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(2);
            cell.setCellValue("Description");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(3);
            cell.setCellValue("Date de creation");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(4);
            cell.setCellValue("Type");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(5);
            cell.setCellValue("Base chimique");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(6);
            cell.setCellValue("dosage");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(7);
            cell.setCellValue("teneur");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(8);
            cell.setCellValue("couleur");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(9);
            cell.setCellValue("poids");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(10);
            cell.setCellValue("Fonction P");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(11);
            cell.setCellValue("Fonction S");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(12);
            cell.setCellValue("Fournisseur");
            cell.setCellStyle(headerCellStyle);


            int rowIdx = 1;
            for (Adjuvants adjuvants : Ladjuvants) {
                Row datarow = sheet.createRow(rowIdx++);
                datarow.createCell(0).setCellValue(adjuvants.getIdAdjuvants());
                datarow.createCell(1).setCellValue(adjuvants.getNom());
                datarow.createCell(2).setCellValue(adjuvants.getDescription());
                datarow.createCell(3).setCellValue(adjuvants.getDateCreation());
                datarow.createCell(4).setCellValue(adjuvants.getType());
                datarow.createCell(5).setCellValue(adjuvants.getBase_chimique());
                datarow.createCell(6).setCellValue(adjuvants.getDosage());
                datarow.createCell(7).setCellValue(adjuvants.getTeneur());
                datarow.createCell(8).setCellValue(adjuvants.getCouleur());
                datarow.createCell(9).setCellValue(adjuvants.getPoids());
                datarow.createCell(10).setCellValue(adjuvants.getFonctionP());
                datarow.createCell(11).setCellValue(adjuvants.getFonctionS());
                datarow.createCell(12).setCellValue(adjuvants.getFournisseur());

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);
            sheet.autoSizeColumn(10);
            sheet.autoSizeColumn(11);
            sheet.autoSizeColumn(12);

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }


    public static ByteArrayInputStream GravierToExcel(List<Gravier> Lgravier) {
        String SHEET = "Liste des graviers";
        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // Creating header
            Cell cell = row.createCell(0);
            cell.setCellValue("Id Gravier");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Nom");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("Description");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(3);
            cell.setCellValue("Date de creation");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(4);
            cell.setCellValue("Type");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(5);
            cell.setCellValue("Nature");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(6);
            cell.setCellValue("Forme");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(7);
            cell.setCellValue("Poids");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(8);
            cell.setCellValue("Résistance");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(9);
            cell.setCellValue("Fournisseur");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(10);
            cell.setCellValue("Wilaya");
            cell.setCellStyle(headerCellStyle);


            int rowIdx = 1;
            for (Gravier gravier : Lgravier) {
                Row datarow = sheet.createRow(rowIdx++);
                datarow.createCell(0).setCellValue(gravier.getIdGravier());
                datarow.createCell(1).setCellValue(gravier.getNom());
                datarow.createCell(2).setCellValue(gravier.getDescription());
                datarow.createCell(3).setCellValue(gravier.getDateCreation());
                datarow.createCell(4).setCellValue(gravier.getTypeGravier());
                datarow.createCell(5).setCellValue(gravier.getNature());
                datarow.createCell(6).setCellValue(gravier.getForme());
                datarow.createCell(7).setCellValue(gravier.getPoids());
                datarow.createCell(8).setCellValue(gravier.getResistance());
                datarow.createCell(9).setCellValue(gravier.getFournisseur());
                datarow.createCell(10).setCellValue(gravier.getWilaya().getIdWilaya());

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);
            sheet.autoSizeColumn(10);

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }


    public static ByteArrayInputStream EauToExcel(List<Eau> Leaux) {
        String SHEET = "Liste des eaux";
        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // Creating header
            Cell cell = row.createCell(0);
            cell.setCellValue("Id Eau");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Nom");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("Description");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(3);
            cell.setCellValue("Date de creation");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(4);
            cell.setCellValue("Type");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(5);
            cell.setCellValue("Couleur");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(6);
            cell.setCellValue("Poids");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(7);
            cell.setCellValue("teneur");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(8);
            cell.setCellValue("Fournisseur");
            cell.setCellStyle(headerCellStyle);


            int rowIdx = 1;
            for (Eau eau : Leaux) {
                Row datarow = sheet.createRow(rowIdx++);
                datarow.createCell(0).setCellValue(eau.getIdEau());
                datarow.createCell(1).setCellValue(eau.getNom());
                datarow.createCell(2).setCellValue(eau.getDescription());
                datarow.createCell(3).setCellValue(eau.getDateCreation());
                datarow.createCell(4).setCellValue(eau.getType());
                datarow.createCell(5).setCellValue(eau.getCouleur());
                datarow.createCell(6).setCellValue(eau.getPoids());
                datarow.createCell(7).setCellValue(eau.getTeneur());
                datarow.createCell(8).setCellValue(eau.getFournisseur());

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }



    public static ByteArrayInputStream SablesToExcel(List<Sable> Lsables) {
        String SHEET = "Liste des sables";
        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // Creating header
            Cell cell = row.createCell(0);
            cell.setCellValue("Id Sable");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Nom");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("Description");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(3);
            cell.setCellValue("Date de creation");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(4);
            cell.setCellValue("Nature");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(5);
            cell.setCellValue("Couleur");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(6);
            cell.setCellValue("Forme");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(7);
            cell.setCellValue("Poids");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(8);
            cell.setCellValue("Résistance");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(9);
            cell.setCellValue("Fournisseur");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(10);
            cell.setCellValue("Wilaya");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(10);
            cell.setCellValue("Etat");
            cell.setCellStyle(headerCellStyle);


            int rowIdx = 1;
            for (Sable sab : Lsables) {
                Row datarow = sheet.createRow(rowIdx++);
                datarow.createCell(0).setCellValue(sab.getIdSable());
                datarow.createCell(1).setCellValue(sab.getNom());
                datarow.createCell(2).setCellValue(sab.getDescription());
                datarow.createCell(3).setCellValue(sab.getDateCreation());
                datarow.createCell(4).setCellValue(sab.getNature());
                datarow.createCell(5).setCellValue(sab.getCouleur());
                datarow.createCell(6).setCellValue(sab.getForme());
                datarow.createCell(7).setCellValue(sab.getPoids());
                datarow.createCell(8).setCellValue(sab.getResistance());
                datarow.createCell(9).setCellValue(sab.getFournisseur());
                datarow.createCell(10).setCellValue(sab.getWilaya().getIdWilaya());


            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);
            sheet.autoSizeColumn(10);

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }

    public static List<Ciment> excelToCiments(InputStream is) throws ParseException {
        String SHEET = "Liste des ciments";

        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<Ciment> lciments = new ArrayList<>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                Ciment cim = new Ciment();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            cim.setIdCiment((long) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            cim.setNom(currentCell.getStringCellValue());
                            break;
                        case 2:
                            cim.setDescription(currentCell.getStringCellValue());
                            break;
                        case 3:
                            cim.setDateCreation(currentCell.getDateCellValue());
                            break;
                        case 4:
                            cim.setTypeCiment(currentCell.getStringCellValue());
                            break;
                        case 5:
                            cim.setClassification(currentCell.getStringCellValue());
                            break;
                        case 6:
                            cim.setPoids((float)currentCell.getNumericCellValue());
                            break;
                        case 7:
                            cim.setResistance((float) currentCell.getNumericCellValue());
                            break;
                        case 8:
                            cim.setFournisseur(currentCell.getStringCellValue());
                            cim.setEtat(Ciment.Etat.NonTester);
                            break;
                        /*case 9:
                            cim.setWilaya(currentCell.getStringCellValue());
                            break;*/
                        default:
                            break;
                    }
                    cellIdx++;
                }
                lciments.add(cim);
            }
            workbook.close();
            return lciments;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }



    public static List<Sable> excelToSables(InputStream is) throws ParseException {
        String SHEET = "Liste des sables";

        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<Sable> lsables = new ArrayList<>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                Sable sable = new Sable();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            sable.setIdSable((long) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            sable.setNom(currentCell.getStringCellValue());
                            break;
                        case 2:
                            sable.setDescription(currentCell.getStringCellValue());
                            break;
                        case 3:
                            sable.setDateCreation(currentCell.getDateCellValue());
                            break;
                        case 4:
                            sable.setNature(currentCell.getStringCellValue());
                            break;
                        case 5:
                            sable.setCouleur(currentCell.getStringCellValue());
                            break;
                        case 6:
                            sable.setForme(currentCell.getStringCellValue());
                            break;
                        case 7:
                            sable.setPoids((float) currentCell.getNumericCellValue());
                            break;
                        case 8:
                            sable.setResistance((float) currentCell.getNumericCellValue());
                            break;
                        case 9:
                            sable.setFournisseur(currentCell.getStringCellValue());
                            break;
                        /*case 9:
                            cim.setWilaya(currentCell.getStringCellValue());
                            break;*/
                        default:
                            break;
                    }
                    cellIdx++;
                }
                lsables.add(sable);
            }
            workbook.close();
            return lsables;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }


    public static List<Eau> excelToEau(InputStream is) throws ParseException {
        String SHEET = "Liste des eaux";

        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<Eau> leau = new ArrayList<>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                Eau eau = new Eau();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            eau.setIdEau((long) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            eau.setNom(currentCell.getStringCellValue());
                            break;
                        case 2:
                            eau.setDescription(currentCell.getStringCellValue());
                            break;
                        case 3:
                            eau.setDateCreation(currentCell.getDateCellValue());
                            break;
                        case 4:
                            eau.setType(currentCell.getStringCellValue());
                            break;
                        case 5:
                            eau.setCouleur(currentCell.getStringCellValue());
                            break;
                        case 6:
                            eau.setPoids((float) currentCell.getNumericCellValue());
                            break;
                        case 7:
                            eau.setTeneur((float) currentCell.getNumericCellValue());
                            break;
                        case 8:
                            eau.setFournisseur(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                leau.add(eau);
            }
            workbook.close();
            return leau;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

    public static List<Gravier> excelToGraviers(InputStream is) throws ParseException {
        String SHEET = "Liste des graviers";

        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<Gravier> lgraviers = new ArrayList<>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                Gravier gravier = new Gravier();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            gravier.setIdGravier((long) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            gravier.setNom(currentCell.getStringCellValue());
                            break;
                        case 2:
                            gravier.setDescription(currentCell.getStringCellValue());
                            break;
                        case 3:
                            gravier.setDateCreation(currentCell.getDateCellValue());
                            break;
                        case 4:
                            gravier.setTypeGravier(currentCell.getStringCellValue());
                            break;
                        case 5:
                            gravier.setNature(currentCell.getStringCellValue());
                            break;
                        case 6:
                            gravier.setForme(currentCell.getStringCellValue());
                            break;
                        case 7:
                            gravier.setPoids((float) currentCell.getNumericCellValue());
                            break;
                        case 8:
                            gravier.setResistance((float) currentCell.getNumericCellValue());
                            break;
                        case 9:
                            gravier.setFournisseur(currentCell.getStringCellValue());
                            break;
                        /*case 9:
                            cim.setWilaya(currentCell.getStringCellValue());
                            break;*/
                        default:
                            break;
                    }
                    cellIdx++;
                }
                lgraviers.add(gravier);
            }
            workbook.close();
            return lgraviers;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

    public static List<Adjuvants> excelToAdjuvants(InputStream is) throws ParseException {
        String SHEET = "Liste des adjuvants";

        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<Adjuvants> ladjuvants = new ArrayList<>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                Adjuvants adjuvants = new Adjuvants();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            adjuvants.setIdAdjuvants((long) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            adjuvants.setNom(currentCell.getStringCellValue());
                            break;
                        case 2:
                            adjuvants.setDescription(currentCell.getStringCellValue());
                            break;
                        case 3:
                            adjuvants.setDateCreation(currentCell.getDateCellValue());
                            break;
                        case 4:
                            adjuvants.setType(currentCell.getStringCellValue());
                            break;
                        case 5:
                            adjuvants.setBase_chimique(currentCell.getStringCellValue());
                            break;
                        case 6:
                            adjuvants.setDosage((float)currentCell.getNumericCellValue());
                            break;
                        case 7:
                            adjuvants.setTeneur((float) currentCell.getNumericCellValue());
                            break;
                        case 8:
                            adjuvants.setCouleur(currentCell.getStringCellValue());
                            break;
                        case 9:
                            adjuvants.setPoids((float)currentCell.getNumericCellValue());
                            break;
                        case 10:
                            adjuvants.setFonctionP(currentCell.getStringCellValue());
                            break;
                        case 11:
                            adjuvants.setFonctionS(currentCell.getStringCellValue());
                            break;
                        case 12:
                            adjuvants.setFournisseur(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                ladjuvants.add(adjuvants);
            }
            workbook.close();
            return ladjuvants;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}