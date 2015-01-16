package com.oocl.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 1/5/15
 * Time: 2:51 PM
 */
public class GetEventIdUtils  {
    private static String LOG1_PATH = "D://Container Event//1.14//hist//filDebug_1.txt";
    private static String LOG2_PATH = "D://Container Event//1.14//hist//filDebug_2.txt";
    private static String OUT_PUT_PATH = "D://Container Event//1.14//0106//0110.txt";
    private static String TEMP_PATH = "D://temp.txt";
    private static String TEMP_OUTPUT_PATH = "D://tempOutput.txt";
    private int sum = 0;

    public static void main(String[] args) throws Exception {
        generateFile("10 Jan");
    }

    private static void generateFile (String dateStr) throws Exception {
        Pattern p = Pattern.compile(dateStr + ".*EEC Id:(\\d*)");
        File outputFile = new File(OUT_PUT_PATH);
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        bw.write(dateStr + "\n");
        String lineData;
        File file1 = new File(LOG1_PATH);
        BufferedReader bf1 = new BufferedReader(new FileReader(file1));
        while ((lineData = bf1.readLine()) != null) {
            Matcher m = p.matcher(lineData);
            if (m.find()) {
                bw.write(m.group(1) + "\n");
            }
        }

        File file2 = new File(LOG2_PATH);
        BufferedReader bf2 = new BufferedReader(new FileReader(file2));
        while ((lineData = bf2.readLine()) != null) {
            Matcher m = p.matcher(lineData);
            if (m.find()) {
                bw.write(m.group(1) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void generateFileTemp (String dateStr) throws Exception {
        Pattern p = Pattern.compile(dateStr + ".*EEC Id:(\\d*)");
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(TEMP_OUTPUT_PATH)));
        bw.write(dateStr + "\n");
        String lineData;
        File file1 = new File(TEMP_PATH);
        BufferedReader bf1 = new BufferedReader(new FileReader(file1));
        while ((lineData = bf1.readLine()) != null) {
            Matcher m = p.matcher(lineData);
            if (m.find()) {
                bw.write(m.group(1) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

}
