package com.oocl.test.fanbin;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 12/29/14
 * Time: 11:36 AM
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ThomasSort {
    public final static File RANDOMFILE = new File("C:/", "randomFile.txt");
    public final static File SORTFILE = new File("C:/", "sortFile.txt");
    public final static String CHARSETNAME = "UTF-8";
//    public static final int N = 100;
    public static final int N = 10000000;
//    public static final int S = 30;
    public static final int S = 300000;
    public static final int[] A = new int[N];
    public final static AtomicInteger THREADCOUNT = new AtomicInteger(50);

    public static void main(String[] args) throws IOException,
            InterruptedException {
        writeRrandomFile();
        readRrandomFile();
        sort();
        checkSort();
        writeSortFile();
    }

    public static void arraysSort() {
        long beginTime = System.currentTimeMillis();
        java.util.Arrays.sort(A);
        long endTime = System.currentTimeMillis();
        System.out.println("arrays sort file:" + (endTime - beginTime) + "ms");
    }

    public static void writeRrandomFileOnce() {
        if (!RANDOMFILE.exists()) {
            writeRrandomFile();
        }
        System.out.println("random file exists!");
    }

    public static void writeRrandomFile() {
        long beginTime = System.currentTimeMillis();
        Random rd = new Random();
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(RANDOMFILE), CHARSETNAME));
            for (int i = 0; i < N; i++) {
                bw.write(String.valueOf(rd.nextInt()));
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("write random file:" + (endTime - beginTime) + "ms");
    }

    public static void readRrandomFile() {
        long beginTime = System.currentTimeMillis();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(RANDOMFILE), CHARSETNAME));
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                A[index++] = Integer.valueOf(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("read random file:" + (endTime - beginTime) + "ms");
    }

    public static void sort() {
        long beginTime = System.currentTimeMillis();
        try {
            sort(A, 0, A.length - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("sort file:" + (endTime - beginTime) + "ms");
    }

    public static void checkSort() {
        long beginTime = System.currentTimeMillis();
        boolean flag = true;
        try {
            int Nmm = N - 2;
            for (int i = 0; i < Nmm; i++) {
                if (A[i] > A[i + 1]) {
                    System.out.println(A[i] + ">" + A[i + 1]);
                    flag = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("check sort file " + flag + ":"
                + (endTime - beginTime) + "ms");
    }

    public static void writeSortFile() {
        long beginTime = System.currentTimeMillis();
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(SORTFILE), CHARSETNAME));
            for (int i = 0; i < N; i++) {
                bw.write(String.valueOf(A[i]));
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("write sort file:" + (endTime - beginTime) + "ms");
    }

    public static void sort(final int a[], final int low, final int high) {
        if (high - low < S) {
            Arrays.sort(a, low, high + 1);
            return;
        }

        int i = low;
        int j = high;
        if (j - i > 2) {
            if ((a[i] < a[j - i] && a[j - i] < a[j])
                    || (a[j] < a[j - i] && a[j - i] < a[i])) {
                int t = a[i];
                a[i] = a[j - i];
                a[j - i] = t;
            } else {
                if ((a[i] < a[j] && a[j] < a[j - i])
                        || (a[j - i] < a[j] && a[j] < a[i])) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }

        int pivot = a[low];
        while (i < j) {
            while (i < j && a[j] > pivot) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < pivot) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = pivot;
        // System.out.println("pivot " + i + ":" + pivot);
        // System.out.println(Arrays.toString(a));
        List<Thread> threads = new ArrayList<Thread>();
        final int imm = i - 1;
        if (low < imm) {
            if (ThomasSort.THREADCOUNT.get() > 0 && imm - low > S) {
                Thread t = new Thread() {
                    {
                        ThomasSort.THREADCOUNT.decrementAndGet();
                    }

                    @Override
                    public void run() {
                        sort(a, low, imm);
                        ThomasSort.THREADCOUNT.addAndGet(1);
                    }
                };
                t.start();
                threads.add(t);
            } else {
                Arrays.sort(a, low, imm + 1);
            }
        }
        final int ipp = i + 1;
        if (high > ipp) {
            if (ThomasSort.THREADCOUNT.get() > 0 && high - ipp > S) {
                Thread t = new Thread() {
                    {
                        ThomasSort.THREADCOUNT.decrementAndGet();
                    }

                    @Override
                    public void run() {
                        sort(a, ipp, high);
                        ThomasSort.THREADCOUNT.addAndGet(1);
                    }
                };
                t.start();
                threads.add(t);
            } else {
                Arrays.sort(a, ipp, high + 1);
            }
        }

        try {
            for (Thread t : threads)
                t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}