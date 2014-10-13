package com.oocl.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 8/21/14
 * Time: 1:44 PM
 */
public class MyRegex {

    public static void main(String[] args) {
        String testStr = "<p class=\"c6\"></p>\n" +
                "<p class=\"c7\"><span class=\"c8\">支綫航路運輸委託書</span></p>\n" +
                "<p class=\"c9\"></p>\n" +
                "<table class=\"c33\">\n" +
                "<col width=\"100.0%\"/>\n" +
                "<tr class=\"c10\">\n" +
                "<td valign=\"top\" class=\"c11\"><table class=\"c33\">\n" +
                "<col width=\"49.981%\"/>\n" +
                "<col width=\"50.018%\"/>\n" +
                "<tr class=\"c12\">\n" +
                "<td valign=\"top\" class=\"c13\"><table class=\"c22\">\n" +
                "<col width=\"27.723%\"/>\n" +
                "<col width=\"72.276%\"/>\n" +
                "<tr class=\"c14\">\n" +
                "<td valign=\"top\" class=\"c15\"><p class=\"c16\"><span class=\"c17\"><b>委托方:</b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c18\"><p class=\"c19\"><span class=\"c20\">OOCL (Singapore) Pte Ltd</span><span class=\"c21\"> </span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c14\">\n" +
                "<td valign=\"top\" class=\"c15\"><p class=\"c16\"><span class=\"c17\"><b>預約時間：</b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c18\"><p class=\"c19\"><span class=\"c20\">10 Apr 2013, 00:00</span><span class=\"c21\"> </span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c14\">\n" +
                "<td valign=\"top\" class=\"c15\"><p class=\"c16\"><span class=\"c17\"><b>操作員:</b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c18\"><p class=\"c19\"><span class=\"c20\">LICH6</span><span class=\"c21\"> </span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<p class=\"c23\"></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c24\"><table class=\"c31\">\n" +
                "<col width=\"33.37%\"/>\n" +
                "<col width=\"66.629%\"/>\n" +
                "<tr class=\"c25\">\n" +
                "<td valign=\"top\" class=\"c26\"><p class=\"c27\"><span class=\"c17\"><b>委托單號: </b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c28\"><p class=\"c29\"><span class=\"c20\">1010001198</span><span class=\"c21\"> </span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c25\">\n" +
                "<td valign=\"top\" class=\"c26\"><p class=\"c27\"><span class=\"c17\"><b>創建時間: </b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c28\"><p class=\"c29\"><span class=\"c20\">23 Jan 2014, 14:07</span><span class=\"c21\"> </span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c25\">\n" +
                "<td valign=\"top\" class=\"c26\"><p class=\"c27\"><span class=\"c17\"><b> </b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c28\"><p class=\"c30\"><span class=\"c21\"> </span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<p class=\"c32\"></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<p class=\"c23\"></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c34\">\n" +
                "<td valign=\"top\" class=\"c11\"></td>\n" +
                "</tr>\n" +
                "<tr class=\"c35\">\n" +
                "<td valign=\"top\" class=\"c36\"></td>\n" +
                "</tr>\n" +
                "<tr class=\"c34\">\n" +
                "<td valign=\"top\" class=\"c37\"></td>\n" +
                "</tr>\n" +
                "<tr class=\"c38\">\n" +
                "<td valign=\"top\" class=\"c39\"><p class=\"c40\"><span class=\"c21\"><b> </b></span><span class=\"c41\">提/卸貨點信息</span></p>\n" +
                "<table class=\"c55\">\n" +
                "<col width=\"29.99%\"/>\n" +
                "<col width=\"49.953%\"/>\n" +
                "<col width=\"20.055%\"/>\n" +
                "<tr class=\"c42\">\n" +
                "<td valign=\"top\" class=\"c43\"><p class=\"c44\"><span class=\"c45\"><b>提/卸貨點</b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c46\"><p class=\"c47\"><span class=\"c45\"><b>運輸地點</b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c48\"><p class=\"c49\"><span class=\"c45\"><b>預計離開/到達時間</b></span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c50\">\n" +
                "<td valign=\"top\" class=\"c51\"><p class=\"c44\"><span class=\"c52\"> </span><span class=\"c20\">Empty Pickup</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c53\"><p class=\"c47\"><span class=\"c20\">SIN03</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c54\"><p class=\"c49\"><span class=\"c20\">10 Apr 2013, 00:00</span><span class=\"c21\"> </span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c50\">\n" +
                "<td valign=\"top\" class=\"c51\"><p class=\"c44\"><span class=\"c52\"> </span><span class=\"c20\">Empty Return</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c53\"><p class=\"c47\"><span class=\"c20\">SIN01</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c54\"><p class=\"c49\"><span class=\"c20\">13 Sep 2013, 00:00</span><span class=\"c21\"> </span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c56\">\n" +
                "<td valign=\"top\" class=\"c57\"><p class=\"c40\"><span class=\"c21\"> </span><span class=\"c41\">設備信息</span></p>\n" +
                "<table class=\"c83\">\n" +
                "<col width=\"84.953%\"/>\n" +
                "<col width=\"15.046%\"/>\n" +
                "<tr class=\"c58\">\n" +
                "<td valign=\"top\" colspan=\"2\" class=\"c39\"><table class=\"c55\">\n" +
                "<col width=\"14.953%\"/>\n" +
                "<col width=\"11.666%\"/>\n" +
                "<col width=\"16.666%\"/>\n" +
                "<col width=\"13.333%\"/>\n" +
                "<col width=\"15.0%\"/>\n" +
                "<col width=\"13.333%\"/>\n" +
                "<col width=\"15.046%\"/>\n" +
                "<tr class=\"c59\">\n" +
                "<td valign=\"top\" class=\"c60\"><p class=\"c61\"><span class=\"c45\"><b>設備編號</b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c62\"><p class=\"c63\"><span class=\"c45\"><b>箱型尺寸</b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c64\"><p class=\"c65\"><span class=\"c45\"><b>貨物屬性</b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c66\"><p class=\"c65\"><span class=\"c45\"><b>簽封號</b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c67\"><p class=\"c65\"><span class=\"c45\"><b>訂艙單號</b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c66\"><p class=\"c65\"><span class=\"c45\"><b>貨物重量</b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c68\"><p class=\"c69\"><span class=\"c45\"><b>费用</b></span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c70\">\n" +
                "<td valign=\"top\" class=\"c71\"></td>\n" +
                "<td valign=\"top\" class=\"c72\"><p class=\"c63\"><span class=\"c20\">20GP</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c73\"></td>\n" +
                "<td valign=\"top\" class=\"c74\"></td>\n" +
                "<td valign=\"top\" class=\"c75\"><p class=\"c65\"><span class=\"c20\">Cuist0120011</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c74\"></td>\n" +
                "<td valign=\"top\" class=\"c76\"><p class=\"c77\"><span class=\"c20\">0</span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c70\">\n" +
                "<td valign=\"top\" class=\"c71\"></td>\n" +
                "<td valign=\"top\" class=\"c72\"><p class=\"c63\"><span class=\"c20\">20GP</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c73\"></td>\n" +
                "<td valign=\"top\" class=\"c74\"></td>\n" +
                "<td valign=\"top\" class=\"c75\"><p class=\"c65\"><span class=\"c20\">Cuist0120011</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c74\"></td>\n" +
                "<td valign=\"top\" class=\"c76\"><p class=\"c77\"><span class=\"c20\">0</span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c70\">\n" +
                "<td valign=\"top\" class=\"c71\"></td>\n" +
                "<td valign=\"top\" class=\"c72\"><p class=\"c63\"><span class=\"c20\">20GP</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c73\"></td>\n" +
                "<td valign=\"top\" class=\"c74\"></td>\n" +
                "<td valign=\"top\" class=\"c75\"><p class=\"c65\"><span class=\"c20\">Cuist0120011</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c74\"></td>\n" +
                "<td valign=\"top\" class=\"c76\"><p class=\"c77\"><span class=\"c20\">0</span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c70\">\n" +
                "<td valign=\"top\" class=\"c71\"></td>\n" +
                "<td valign=\"top\" class=\"c72\"><p class=\"c63\"><span class=\"c20\">20GP</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c73\"></td>\n" +
                "<td valign=\"top\" class=\"c74\"></td>\n" +
                "<td valign=\"top\" class=\"c75\"><p class=\"c65\"><span class=\"c20\">Cuist0120011</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c74\"></td>\n" +
                "<td valign=\"top\" class=\"c76\"><p class=\"c77\"><span class=\"c20\">0</span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c70\">\n" +
                "<td valign=\"top\" class=\"c71\"></td>\n" +
                "<td valign=\"top\" class=\"c72\"><p class=\"c63\"><span class=\"c20\">20GP</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c73\"></td>\n" +
                "<td valign=\"top\" class=\"c74\"></td>\n" +
                "<td valign=\"top\" class=\"c75\"><p class=\"c65\"><span class=\"c20\">Cuist0120011</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c74\"></td>\n" +
                "<td valign=\"top\" class=\"c76\"><p class=\"c77\"><span class=\"c20\">0</span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<p class=\"c78\"></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c79\">\n" +
                "<td valign=\"top\" class=\"c80\"><p class=\"c81\"><span class=\"c45\"><b>總數量:</b></span><span class=\"c21\"> </span><span class=\"c20\">5</span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c82\"></td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c34\">\n" +
                "<td valign=\"top\" class=\"c84\"><table class=\"c55\">\n" +
                "<col width=\"49.981%\"/>\n" +
                "<col width=\"50.018%\"/>\n" +
                "</table>\n" +
                "<p class=\"c23\"></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c34\">\n" +
                "<td valign=\"top\" class=\"c84\"><table class=\"c55\">\n" +
                "<col width=\"49.953%\"/>\n" +
                "<col width=\"50.046%\"/>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c34\">\n" +
                "<td valign=\"top\" class=\"c84\"><table class=\"c85\">\n" +
                "<col width=\"49.953%\"/>\n" +
                "<col width=\"50.046%\"/>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c86\">\n" +
                "<td valign=\"top\" class=\"c11\"><table class=\"c55\">\n" +
                "<col width=\"9.953%\"/>\n" +
                "<col width=\"90.046%\"/>\n" +
                "<tr class=\"c87\">\n" +
                "<td valign=\"top\" colspan=\"2\" class=\"c39\"><p class=\"c88\"><span class=\"c17\"> </span><span class=\"c41\">附加信息</span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c89\">\n" +
                "<td valign=\"top\" class=\"c90\"><p class=\"c61\"><span class=\"c45\"><b>備註</b></span></p>\n" +
                "</td>\n" +
                "<td valign=\"top\" class=\"c91\"><p class=\"c92\"><span class=\"c20\">123;</span><span class=\"c21\"> </span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c35\">\n" +
                "<td valign=\"top\" class=\"c37\"><table class=\"c55\">\n" +
                "<col width=\"100.0%\"/>\n" +
                "</table>\n" +
                "<p class=\"c23\"></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr class=\"c93\">\n" +
                "<td valign=\"top\" class=\"c37\"><p class=\"c94\"><span class=\"c21\"> </span><span class=\"c21\"> </span></p>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n";
        Matcher m = Pattern.compile("<tr\\s\\w*\\=\\\"(\\w*)\\\">\\n.*colspan.*<span.*").matcher(testStr);
        while (m.find()) {
            String spaceLine = "<tr style=\"height: 70px;\"></tr>\n";
            testStr = testStr.replace(m.group(0), spaceLine + m.group(0));
        }
    }
}
