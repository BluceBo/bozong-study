package com.banggood.bozong.study.javathink.chapter18;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by admin on 2018/4/16.
 * TextFile类在本书前面的示例中就已经被用来简化对文件读写操作了。
 * 它包含的static方法可以像简单字符串那样读写文本文件，并且我们可以创建一个TextFile对象，
 * 它用一个ArrayList来保存文件的若干行。
 */
public class TextFile extends ArrayList<String>{
    //阅读一个文件转换成字符串
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    //写一个文件
    public static void write(String fileName,String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            out.write(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public TextFile(String fileName,String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) {
            remove(0);
        }
    }
    public TextFile(String fileName) {
        this(fileName,"\n");
    }
    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            for (String item : this) {
                out.write(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file = read("E:\\shop-workspace\\bozong-study\\src\\main\\java\\com\\banggood\\bozong\\study\\javathink\\chapter18\\TextFile.java");
        write("E:\\shop-workspace\\bozong-study\\src\\main\\java\\com\\banggood\\bozong\\study\\javathink\\chapter18\\test.txt",file);
        TextFile text = new TextFile("E:\\shop-workspace\\bozong-study\\src\\main\\java\\com\\banggood\\bozong\\study\\javathink\\chapter18\\TextFile.java");
        text.write("E:\\shop-workspace\\bozong-study\\src\\main\\java\\com\\banggood\\bozong\\study\\javathink\\chapter18\\test2.txt");
        TreeSet<String> words = new TreeSet<String>(new TextFile("E:\\shop-workspace\\bozong-study\\src\\main\\java\\com\\banggood\\bozong\\study\\javathink\\chapter18\\TextFile.java","\\w+"));
        //System.out.println(words.headSet("a"));
    }
}
