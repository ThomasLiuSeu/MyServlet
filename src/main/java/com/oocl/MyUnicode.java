package com.oocl;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 3/3/15
 * Time: 10:33 AM
 */
public class MyUnicode {

    public static void main(String[] args) {
        System.out.println(chinaToUnicode("é"));
    }

    private static String chinaToUnicode(String str){
        String result="";
        for (int i = 0; i < str.length(); i++){
            int chr1 = (char) str.charAt(i);
            if(true){//汉字范围 \u4e00-\u9fa5 (中文)
                result+="\\u" + Integer.toHexString(chr1);
            }else{
                result+=str.charAt(i);
            }
        }
        return result;
    }
}
