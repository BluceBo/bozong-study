package com.banggood.bozong.study.crazyjava.chapter7;

import java.io.IOException;

public class ProcessHandleTest {
    public static void main(String[] args) throws IOException {
        Runtime rt = Runtime.getRuntime();
        //运行记事本程序
        Process p = rt.exec("notepad.exe");

    }
}
