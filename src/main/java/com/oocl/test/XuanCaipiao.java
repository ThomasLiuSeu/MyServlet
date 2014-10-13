package com.oocl.test;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 9/23/14
 * Time: 11:47 AM
 */
import java.util.*;

public class XuanCaipiao {
    private Set set1 = new HashSet();
    private Set set2 = new HashSet();

    public static void main(String[] args) {
        XuanCaipiao xuan = new XuanCaipiao(33, 6, 16, 1);
    }

    private XuanCaipiao(int maxH, int numH, int maxL, int numL) {
        int i = 0;
        int j = 0;
        while (i < numH) {
            if (this.xuanHong(maxH)) {
                i++;
            }
        }
        Iterator it = set1.iterator();
        System.out.print("红球：");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        while (j < numL) {
            if (this.xuanLan(maxL)) {
                j++;
            }
        }
        Iterator it1 = set2.iterator();
        System.out.print("蓝球：");
        while (it1.hasNext()) {
            System.out.print(it1.next() + " ");
        }
    }

    private boolean xuanHong(int maxH) {
        int temp = (int) (Math.random() * maxH + 1);
        return this.set1.add(temp);
    }

    private boolean xuanLan(int maxL) {
        int temp = (int) (Math.random() * maxL + 1);
        return this.set2.add(temp);
    }
}