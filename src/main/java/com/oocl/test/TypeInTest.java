package com.oocl.test;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 11/21/14
 * Time: 8:37 AM
 */
public class TypeInTest {
    public static void main(String[] args) {
        System.out.println("Please input value: \n");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
    }
}
