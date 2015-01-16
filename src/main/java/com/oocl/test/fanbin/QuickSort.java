package com.oocl.test.fanbin;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 12/26/14
 * Time: 9:39 AM
 */
import java.util.Arrays;
public class QuickSort {
    public static void main(String[] args) {
        int[] sour = {45,53,18,36,72,30,48,93,15,36};
        quickSort(sour, 0, sour.length-1); //调用快速排序方法
        //quickSort(sour, 0, 3);//前4个元素快速排序
        System.out.println(Arrays.toString(sour));
    }
    public static void quickSort(int[] a, int fromKey, int toKey) {
        int aheadKey = fromKey; //方法内变量只作用于本次调用。若直接使用方法形参，递归时受影响。
        int behindKey = toKey+1;

        int x = a[fromKey];//把基准元素的值暂存x中
        int temp;//交换元素值时使用的暂时存储空间

        do {

            //从前向后顺序查找一个需向后一区间交换的元素(即比基准元素值x大的元素)
            do aheadKey ++; while (aheadKey<toKey && a[aheadKey]<x);

            //从后向前顺序查找一个需向前一区间交换的元素。
            do behindKey--;while(behindKey>0 && a[behindKey]>x);

            if(aheadKey<behindKey){
                temp = a[aheadKey];
                a[aheadKey] = a[behindKey];
                a[behindKey] = temp;
            }
        } while (aheadKey < behindKey);//条件成立时继续进行一次划分中的比较和交换。
        //交换a[fromKey]和a[behindKey]的值，得到前后两个子区间。
        a[fromKey] = a[behindKey];
        a[behindKey] = x;

        System.out.println(Arrays.toString(a));
        System.out.println("--------------");
        //在当前左区间内超过一个元素的情况下递归处理左区间
        if(fromKey<behindKey-1) quickSort(a,fromKey,behindKey-1);
        //在当前右区间内超过一个元素的情况下递归处理右区间
        if(behindKey+1<toKey) quickSort(a,behindKey+1,toKey);

    }
}