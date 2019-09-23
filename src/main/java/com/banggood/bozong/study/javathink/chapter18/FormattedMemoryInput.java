package com.banggood.bozong.study.javathink.chapter18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by admin on 2018/4/15.
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new ByteArrayInputStream(BufferedInputFile.read("E:\\shop-workspace\\bozong-study\\src\\main\\java\\com\\banggood\\bozong\\study\\javathink\\chapter18\\FormattedMemoryInput.java").getBytes())
        );
        while (in.available() != 0) {
            System.out.println((char) in.readByte());
        }
    }
}
