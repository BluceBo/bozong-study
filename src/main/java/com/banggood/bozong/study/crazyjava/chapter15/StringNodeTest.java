package com.banggood.bozong.study.crazyjava.chapter15;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringNodeTest {
    public static void main(String[] args) throws IOException {
        String src = "从明天起，做一个幸福的人\n"
                + "喂马，劈柴，周游世界\n"
                + "从明天起，关心粮食和蔬菜\n"
                + "我有一所房子，面朝大海春暖花开\n"
                + "从明天起，和每一个亲人通信\n"
                + "告诉他们我的幸福\n";
        char[] buf = new char[32];
        int hasRead = 0;
        StringReader sr = new StringReader(src);
        while ((hasRead = sr.read(buf)) > 0) {
            System.out.print(new String(buf,0,hasRead));
        }
        StringWriter sw = new StringWriter();
        sw.write("有一个美丽的新世界,\n");
        sw.write("她在远方等我,\n");
        sw.write("那里有天真的孩子们,\n");
        System.out.println(sw.toString());
    }
}
