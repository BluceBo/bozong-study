package com.banggood.bozong.study.javathink.chapter18;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by admin on 2018/4/15.
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("E:\\shop-workspace\\bozong-study\\src\\main\\java\\com\\banggood\\bozong\\study\\javathink\\chapter18\\MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.println(c);
        }
    }
}
