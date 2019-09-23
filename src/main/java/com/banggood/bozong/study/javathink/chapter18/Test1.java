package com.banggood.bozong.study.javathink.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by admin on 2018/3/31.
 * 练习1：修改DirList.java，以便FilenameFilter能够打开每个文件(使用TextFile工具)，
 * 并检查命令行尾随的参数是否在于那个文件中，以此检查来决定是否接受这个文件
 */
public class Test1 {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirList.DirFilter(args[0]));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
    //内部类
    static class  DirFilter implements FilenameFilter {
        private Pattern pattern;
        public DirFilter(String regex) {
            pattern = Pattern.compile(regex);
        }
        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }
}
