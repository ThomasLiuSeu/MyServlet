package com.oocl.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 10/10/14
 * Time: 11:13 AM
 */
public class ReadProperties {

    private static final String filePath = "D:\\1.properties";

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Properties properties = new Properties();
        properties.load(fis);
        properties.setProperty("bbb", "222");
        FileOutputStream fos = new FileOutputStream(filePath);
        properties.store(fos, filePath);
    }
}
