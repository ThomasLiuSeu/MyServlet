package com.oocl.test.excel;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 11/13/14
 * Time: 10:33 AM
 */
public class MyExportExcel {
    private static HSSFWorkbook wb = new HSSFWorkbook();
    private static List<String> columnHeaders = Lists.newArrayList("Transport Mode", "BOL Number", "Container Number",
            "Check Digit", "Rail Origin", "Rail Destination", "FND Code", "FND", "Routing", "Service Name",
            "Vessel Voyage", "POD Code", "Size Type", "Weight", "Notes", "Consignee", "Notify Party",
            "IT Number", "Rail Service", "Rail Contract", "Haz Indicator", "Reefer Indicator", "LCL Indicator",
            "Piece Count", "Commodity", "Import Date", "Report Date", "Bound or EP");


    public static void main(String[] args) {
        try {
            OutputStream outputStream = new FileOutputStream(new File("D:\\test.xls"));
//            PrintWriter pw = new PrintWriter(outputStream);
//            writeHeader(pw);
            Sheet s = wb.createSheet("NT Job Late4");
            Row r = s.createRow(0);
            HSSFCellStyle headerStyle = getHeaderStyle(wb);
//            r.setRowStyle(headerStyle);
            for (int cellnum = 0; cellnum < columnHeaders.size(); cellnum++) {
                Cell c = r.createCell(cellnum);
                c.setCellValue(columnHeaders.get(cellnum));
                c.setCellStyle(headerStyle);
            }
            wb.write(outputStream);
//            pw.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeHeader(PrintWriter pw) {
        List<String> columns = Lists.newArrayList("Transport Mode", "BOL Number", "Container Number",
                "Check Digit", "Rail Origin", "Rail Destination", "FND Code", "FND", "Routing", "Service Name",
                "Vessel Voyage", "POD Code", "Size Type", "Weight", "Notes", "Consignee", "Notify Party",
                "IT Number", "Rail Service", "Rail Contract", "Haz Indicator", "Reefer Indicator", "LCL Indicator",
                "Piece Count", "Commodity", "Import Date", "Report Date", "Bound or EP");
        pw.append(joinCsvLine(columns));
    }

    private static String joinCsvLine(List<String> columns) {
        StringBuilder sb = new StringBuilder();
        for (String item : columns) {
            sb.append(Strings.nullToEmpty(item));
            sb.append("\t");
        }
        sb.append("\r\n");
        return sb.toString();
    }

    private static HSSFCellStyle getHeaderStyle(HSSFWorkbook wb) {
        HSSFCellStyle headerStyle = wb.createCellStyle();
        headerStyle.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
        headerStyle.setFillBackgroundColor(HSSFColor.BLUE_GREY.index);
        setCommonCellStyle(headerStyle);
        HSSFFont headerFont = headerStyle.getFont(wb);
        headerFont.setColor(HSSFColor.YELLOW.index);
        headerStyle.setFont(headerFont);
        return headerStyle;
    }

    private static void setCommonCellStyle(HSSFCellStyle cs) {
        cs.setBottomBorderColor(HSSFColor.DARK_BLUE.index);
        cs.setTopBorderColor(HSSFColor.DARK_BLUE.index);
        cs.setLeftBorderColor(HSSFColor.DARK_BLUE.index);
        cs.setRightBorderColor(HSSFColor.DARK_BLUE.index);
        cs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cs.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cs.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cs.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cs.setBorderTop(HSSFCellStyle.BORDER_THIN);
    }
}
