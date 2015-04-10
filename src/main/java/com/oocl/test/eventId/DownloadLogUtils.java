package com.oocl.test.eventId;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 1/21/15
 * Time: 2:53 PM
 */
public class DownloadLogUtils {
    private static String LOG1_URL = "http://hklp355p:1234/iview/servlet/DownloadFile?apps=iris4&dirname=/home/ir4domsps/logs/fil&filename=filDebug.log";

    public static void main(String[] args) {

        String res = downloadFromUrl(LOG1_URL, "d:/");
        System.out.println(res);
    }


    public static String downloadFromUrl(String url, String dir) {

        try {
            URL httpurl = new URL(url);
            URLConnection connection = httpurl.openConnection();
            String myCookie = "JSESSIONID=55B27D389A5F4B0ED7021A24F30DCB12; USER_NAME=LIUTH2";
            connection.setRequestProperty("Cookie", myCookie);
            String fileName = getFileNameFromUrl(url);
            System.out.println(fileName);
            File f = new File(dir + fileName);
            FileUtils.copyURLToFile(httpurl, f);
        } catch (Exception e) {
            e.printStackTrace();
            return "Fault!";
        }
        return "Successful!";
    }

    public static String getFileNameFromUrl(String url) {
        String name = new Long(System.currentTimeMillis()).toString() + ".X";
        int index = url.lastIndexOf("/");
        if (index > 0) {
            name = url.substring(index + 1);
            if (name.trim().length() > 0) {
                return name;
            }
        }
        return name;
    }
}
