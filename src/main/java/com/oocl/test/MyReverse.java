package com.oocl.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 8/8/14
 * Time: 3:58 PM
 */
public class MyReverse {
    private static enum SHPEventTypeEnum {
        GateIn("Gate in", "Gate In");
        private String shpType;
        private String spsType;
        SHPEventTypeEnum(String s1, String s2) {
            this.shpType = s1;
            this.spsType = s2;
        }
    };

    private static Map SHPEventMap = new HashMap();
    public static void main(String args[]) {
        String dscEvent = "Gate in";
        System.out.println(SHPEventTypeEnum.valueOf(dscEvent));
    }
}
