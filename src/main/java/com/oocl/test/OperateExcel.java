package com.oocl.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 10/13/14
 * Time: 5:10 PM
 */
public class OperateExcel {

    private static String filePath = "D:\\test.csv";

    public static void main(String[] args) throws Exception {
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();
        String parentPath = absolutePath.substring(0, absolutePath.lastIndexOf("\\"));
        File failureData = new File(parentPath + "\\FailureData123.xls");
        OutputStream out = new FileOutputStream(failureData);
        PrintWriter pw = new PrintWriter(out);
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(file));
        br.readLine();
        String csvLine;
        while ((csvLine = br.readLine()) != null) {
            String lineData[] = csvLine.split(",");
            formatLineData(lineData);
        }
        pw.flush();
        pw.close();
        out.flush();
        out.close();
    }

    private static void formatLineData(String[] lineData) {
        for (int i = 0; i < lineData.length; i++) {
            lineData[i] = lineData[i].replace("\"", "").trim();
        }
    }


}
