package com.banggood.bozong.study.javathink.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by admin on 2018/3/31.
 * 使用内部类的方式复写accept()方法
 */
public class DirList2 {

    public static FilenameFilter filter(final String regex) {
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }
    //主方法
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(filter(args[0]));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String dirItem: list) {
            System.out.println(dirItem);
        }
    }
}
