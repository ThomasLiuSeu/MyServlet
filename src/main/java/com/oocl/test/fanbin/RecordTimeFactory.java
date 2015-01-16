package com.oocl.test.fanbin;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 12/26/14
 * Time: 9:47 AM
 */
public class RecordTimeFactory {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        QuickSort.main(new String[1]);
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end -start) + "毫秒");
    }
}
