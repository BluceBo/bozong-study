package com.banggood.bozong.study.javathink.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by admin on 2018/4/1.
 */
public final class Directory {
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }
    //Overloaded
    public static File[] local(String path,String regex) {
        return local(new File(path),regex);
    }
    // A two-tuple for returing a pair of objects
    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();
        //The default iterable element is the file list
        public Iterator<File> iterator() {
            return files.iterator();
        }
        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }
        public String toString() {
            return "dirs: " + dirs.toString() + "\n\nfiles: " + files.toString();
        }
    }
    public static TreeInfo walk(String start,String regex) {
        return recurseDirs(new File(start),regex);
    }
    public static TreeInfo walk(File start,String regex) {
        return recurseDirs(start,regex);
    }
    public static TreeInfo walk(File start) {
        return recurseDirs(start,".*");
    }
    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start),".*");
    }
    static TreeInfo recurseDirs(File startDir,String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                //此处为递归
                result.addAll(recurseDirs(item,regex));
            } else {
                if (item.getName().matches(regex)) {    //使用的是String类中的matches()方法效果与Patten.matches(regex,str)相同
                    result.files.add(item);
                }
            }
        }
        return result;
    }
    //主方法
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(walk("."));
        } else {
            for (String arg : args) {
                System.out.println(walk("."));
            }
        }
    }
}
