package com.oocl.test.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 10/13/14
 * Time: 9:15 AM
 */
public class Exception1 implements MyException {
    @Override
    public void run() {
        try {
            FileInputStream fis = new FileInputStream("D:\\123.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
