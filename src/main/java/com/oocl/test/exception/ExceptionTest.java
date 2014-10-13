package com.oocl.test.exception;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 10/13/14
 * Time: 9:15 AM
 */
public class ExceptionTest {
    public static void main(String[] args) {
        MyException e1 = new Exception1();
        MyException e2 = new Exception2();
        e1.run();
        e2.run();
    }
}
