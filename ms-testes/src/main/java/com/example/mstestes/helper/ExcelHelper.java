package com.example.mstestes.helper;

import com.example.mstestes.entities.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }


   /* public static List<List<TestCimentdb>> excelToTestCiments(InputStream is) throws ParseException {
        String SHEET = "Liste des tests ciments";

        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<TestCimentdb> lcimdb = new ArrayList<>();
            List<TestCiment2j> lcim2 = new ArrayList<>();
            List<TestCiment7j> lcim7 = new ArrayList<>();
            List<TestCiment28j> lcim28 = new ArrayList<>();
            List<TestCimentfin> lcimfin = new ArrayList<>();
            int rowNumber = 1;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 1) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                TestCimentdb cimdb = new TestCimentdb();
                TestCiment2j cim2 = new TestCiment2j();
                TestCiment7j cim7 = new TestCiment7j();
                TestCiment28j cim28 = new TestCiment28j();
                TestCimentfin cimfin = new TestCimentfin();
                int cellIdx = 1;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 1:
                            cimdb.setId((long) currentCell.getNumericCellValue());
                            break;
                        case 2:
                            cimdb.setDateTest(currentCell.getDateCellValue());
                            break;
                        case 3:
                            cimdb.setTemperature((float) currentCell.getNumericCellValue());
                            break;
                        case 4:
                            cimdb.setIdCiment((long) currentCell.getNumericCellValue());
                            break;
                        case 6:
                            cim2.setDatec2(currentCell.getDateCellValue());
                            break;
                        case 7:
                            cim2.setRf2((float)currentCell.getNumericCellValue());
                            break;
                        case 8:
                            cim2.setRune2((float)currentCell.getNumericCellValue());
                            break;
                        case 9:
                            cim2.setRde2((float) currentCell.getNumericCellValue());
                            break;
                        case 11:
                            cim7.setDatec7(currentCell.getDateCellValue());
                            break;
                        case 12:
                            cim7.setRf7((float)currentCell.getNumericCellValue());
                            break;
                        case 13:
                            cim7.setRune7((float)currentCell.getNumericCellValue());
                            break;
                        case 14:
                            cim7.setRde7((float) currentCell.getNumericCellValue());
                            break;
                        case 16:
                            cim28.setDatec28(currentCell.getDateCellValue());
                            break;
                        case 17:
                            cim28.setRf28((float)currentCell.getNumericCellValue());
                            break;
                        case 18:
                            cim28.setRune28((float)currentCell.getNumericCellValue());
                            break;
                        case 19:
                            cim28.setRde28((float) currentCell.getNumericCellValue());
                            break;
                        case 20:
                            cimfin.setResistanceComp((float)currentCell.getNumericCellValue());
                            break;
                        case 21:
                            cimfin.setPoidPrisme((float) currentCell.getNumericCellValue());
                            break;
                        case 22:
                            cimfin.setConsistance(currentCell.getStringCellValue());
                            break;
                        case 23:
                            cimfin.setDebutPrise(currentCell.getStringCellValue());
                            break;
                        case 24:
                            cimfin.setFinPrise(currentCell.getStringCellValue());
                            break;
                        case 25:
                            cimfin.setObservation(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cellIdx++;

                }
                lcimdb.add(cimdb);
                lcim2.add(cim2);
                lcim7.add(cim7);
                lcim28.add(cim28);
                lcimfin.add(cimfin);
            }
            workbook.close();
            //return lcimdb;
            //return lcim2;
            //return lcim7;
            //return lcim28;
            //return lcimfin;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }*/
/*
    public static ByteArrayInputStream cimentsTestToExcel(List<TableDebut> Lcimdb, List<TableEtape> Lcim2, List<TestCiment7j> Lcim7, List<TestCiment28j> Lcim28, List<TableFin> Lcimfin) {
        String SHEET = "Liste des tests de ciments";
        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            int firstRow = 0;
            int lastRow = 0;
            int firstCol = 1;
            int lastCol = 2;
            sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));

            Row row = sheet.createRow((short)1);
            CellStyle header0CellStyle = workbook.createCellStyle();
            header0CellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            header0CellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle header1CellStyle = workbook.createCellStyle();
            header1CellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            header1CellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle header2CellStyle = workbook.createCellStyle();
            header2CellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            header2CellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle header3CellStyle = workbook.createCellStyle();
            header3CellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
            header3CellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle header4CellStyle = workbook.createCellStyle();
            header4CellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
            header4CellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle header5CellStyle = workbook.createCellStyle();
            header5CellStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
            header5CellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle header6CellStyle = workbook.createCellStyle();
            header6CellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
            header6CellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            Row rowlab = sheet.createRow(0);
            Cell cell1 = rowlab.createCell(1);
            cell1.setCellValue("LABORATOIRE :");
            cell1.setCellStyle(header6CellStyle);
            Cell cell2=rowlab.createCell(3);
            cell2.setCellValue(" SBA ");

            // Creating header
            Cell cell = row.createCell(1);
            cell.setCellValue("Id Test");
            cell.setCellStyle(header0CellStyle);
            cell = row.createCell(2);
            cell.setCellValue("Date de Test");
            cell.setCellStyle(header0CellStyle);
            cell = row.createCell(3);
            cell.setCellValue("Temperature");
            cell.setCellStyle(header0CellStyle);
            cell = row.createCell(4);
            cell.setCellValue("Id Ciment");
            cell.setCellStyle(header0CellStyle);
            cell = row.createCell(5);
            cell.setCellValue(">2j");
            cell.setCellStyle(header2CellStyle);
            cell = row.createCell(6);
            cell.setCellValue("Date Ecrasement");
            cell.setCellStyle(header2CellStyle);
            cell = row.createCell(7);
            cell.setCellValue("Résistance Flexion (MPa)");

            cell = row.createCell(8);
            cell.setCellValue("Résistance comparative N°1 (MPa)");
            cell.setCellStyle(header2CellStyle);
            cell = row.createCell(9);
            cell.setCellValue("Résistance comparative N°2 (MPa)");
            cell.setCellStyle(header2CellStyle);
            cell = row.createCell(10);
            cell.setCellValue(">7j");
            cell.setCellStyle(header3CellStyle);
            cell = row.createCell(11);
            cell.setCellValue("Date Ecrasement");
            cell.setCellStyle(header3CellStyle);
            cell = row.createCell(12);
            cell.setCellValue("Résistance Flexion (MPa)");
            //cell.setCellStyle(headerCellStyle);
            cell = row.createCell(13);
            cell.setCellValue("Résistance comparative N°1 (MPa)");
            cell.setCellStyle(header3CellStyle);
            cell = row.createCell(14);
            cell.setCellValue("Résistance comparative N°2 (MPa)");
            cell.setCellStyle(header3CellStyle);
            cell = row.createCell(15);
            cell.setCellValue(">28j");
            cell.setCellStyle(header4CellStyle);
            cell = row.createCell(16);
            cell.setCellValue("Date Ecrasement");
            cell.setCellStyle(header4CellStyle);
            cell = row.createCell(17);
            cell.setCellValue("Résistance Flexion (MPa)");
            //cell.setCellStyle(headerCellStyle);
            cell = row.createCell(18);
            cell.setCellValue("Résistance comparative N°1 (MPa)");
            cell.setCellStyle(header4CellStyle);
            cell = row.createCell(19);
            cell.setCellValue("Résistance comparative N°2 (MPa)");
            cell.setCellStyle(header4CellStyle);
            cell = row.createCell(20);
            cell.setCellValue("Résistance comparative Moyenne (MPa)");
            cell.setCellStyle(header4CellStyle);
            cell = row.createCell(21);
            cell.setCellValue("Poids prismes (gr)");
            //cell.setCellStyle(headerCellStyle);
            cell = row.createCell(22);
            cell.setCellValue("Consistance (g)");
            cell.setCellStyle(header5CellStyle);
            cell = row.createCell(23);
            cell.setCellValue("Debut de prise");
            cell.setCellStyle(header5CellStyle);
            cell = row.createCell(24);
            cell.setCellValue("Fin de prise");
            cell.setCellStyle(header5CellStyle);
            cell = row.createCell(25);
            cell.setCellValue("Observation");
            //cell.setCellStyle(headerCellStyle);

            int rowIdx = 2;


            for (TableDebut cimdb : Lcimdb ) {
                Row datarow = sheet.createRow(rowIdx++);
                datarow.createCell(1).setCellValue(cimdb.getId());
                datarow.createCell(2).setCellValue(cimdb.getDateTest());
                datarow.createCell(3).setCellValue(cimdb.getTemperature());
                datarow.createCell(4).setCellValue(cimdb.getIdCiment());
                for (TableEtape cim2 : Lcim2) {
                    //Row datarow = sheet.createRow(rowIdx++);
                  Cell cell11 = datarow.createCell(5);
                  cell11.setCellStyle(header2CellStyle);
                  cell11.setCellValue(">2J");
                    datarow.createCell(6).setCellValue(cim2.getDatec2());
                    datarow.createCell(7).setCellValue(cim2.getRf2());
                    datarow.createCell(8).setCellValue(cim2.getRune2());
                    datarow.createCell(9).setCellValue(cim2.getRde2());
                }
                for (TestCiment7j cim7 : Lcim7) {
                    Cell cell11 = datarow.createCell(10);
                    cell11.setCellStyle(header3CellStyle);
                    cell11.setCellValue(">7J");
                    //Row datarow = sheet.createRow(rowIdx++);
                    datarow.createCell(11).setCellValue(cim7.getDatec7());
                    datarow.createCell(12).setCellValue(cim7.getRf7());
                    datarow.createCell(13).setCellValue(cim7.getRune7());
                    datarow.createCell(14).setCellValue(cim7.getRde7());
                }
                for (TestCiment28j cim28 : Lcim28) {
                    Cell cell11 = datarow.createCell(15);
                    cell11.setCellStyle(header4CellStyle);
                    cell11.setCellValue(">28J");
                    //Row datarow = sheet.createRow(rowIdx++);
                    datarow.createCell(16).setCellValue(cim28.getDatec28());
                    datarow.createCell(17).setCellValue(cim28.getRf28());
                    datarow.createCell(18).setCellValue(cim28.getRune28());
                    datarow.createCell(19).setCellValue(cim28.getRde28());
                }
                for (TableFin cimfin : Lcimfin) {
                    //Row datarow = sheet.createRow(rowIdx++);
                    datarow.createCell(20).setCellValue(cimfin.getResistanceComp());
                    datarow.createCell(21).setCellValue(cimfin.getPoidPrisme());
                    datarow.createCell(22).setCellValue(cimfin.getConsistance());
                    datarow.createCell(23).setCellValue(cimfin.getDebutPrise());
                    datarow.createCell(24).setCellValue(cimfin.getFinPrise());
                    datarow.createCell(25).setCellValue(cimfin.getObservation());
                }
        }
            sheet.setColumnWidth(0, 2000);
            sheet.setColumnWidth(1, 2000);
            // sheet.autoSizeColumn(1);
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
            sheet.autoSizeColumn(13);
            sheet.autoSizeColumn(14);
            sheet.autoSizeColumn(15);
            sheet.autoSizeColumn(16);
            sheet.autoSizeColumn(17);
            sheet.autoSizeColumn(18);
            sheet.autoSizeColumn(19);
            sheet.autoSizeColumn(20);
            sheet.autoSizeColumn(21);
            sheet.autoSizeColumn(22);
            sheet.autoSizeColumn(23);
            sheet.autoSizeColumn(24);

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
*/
}
