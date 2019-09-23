package com.banggood.bozong.study.javathink.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by admin on 2018/3/29.
 * 文件过滤排序
 * 技术要点：
 * 1. 使用Arrays.sort()方法排序
 * 2. String.CASE_INSENSITIVE_ORDER表示按字母从小到大排序
 * 3. FilenameFilter类对文件进行过滤
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0]));
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
