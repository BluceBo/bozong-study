package com.banggood.bozong.study.javathink.chapter18;

import java.io.*;

/**
 * Created by admin on 2018/4/15.
 */
public class BasicFileOutput {
    static String file = "E:\\shop-workspace\\bozong-study\\src\\main\\java\\com\\banggood\\bozong\\study\\javathink\\chapter18\\BasicFileOutPut.txt";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read("E:\\shop-workspace\\bozong-study\\src\\main\\java\\com\\banggood\\bozong\\study\\javathink\\chapter18\\BasicFileOutput.java"))
        );
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file))
        );
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ":" + s);
            out.close();
            System.out.println(BufferedInputFile.read(file));
        }
    }
}
