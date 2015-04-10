package com.oocl.test.MyMuitiParam;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 3/6/15
 * Time: 4:40 PM
 */
public class MyMultiParam {
    public static void main(String[] args) {
        test("aaa");
        test("aaa", "bbb");
        test("aaa", "bbb", "ccc");
    }

//    public static void test(String... args) {
//        System.out.println(args.getClass());
//        for (String arg : args) {
//            System.out.println(arg);
//        }
//    }

    public static void test(String arg, String... args) {
        System.out.println(arg);
        System.out.println("----------------");
        for (String s : args) {
            System.out.println(s);
        }
    }
}
