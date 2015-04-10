package com.oocl.test.hash;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 3/6/15
 * Time: 4:15 PM
 */
public class MyHashTest {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        Teacher t1 = new Teacher("T1", 21, 1001);
        Teacher t2 = new Teacher("T2", 22, 1002);
        Teacher t3 = new Teacher("T2", 22, 1003);
        map.put(t1, "1");
        map.put(t2, "2");
        map.put(t3, "3");
    }

}
