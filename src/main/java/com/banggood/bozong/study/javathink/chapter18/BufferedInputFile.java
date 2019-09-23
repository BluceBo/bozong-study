package com.banggood.bozong.study.javathink.chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by admin on 2018/4/15.
 */
public class BufferedInputFile {
    public static String read(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("Directory.java"));
    }
}
