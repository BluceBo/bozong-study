package com.banggood.bozong.study.javathink.chapter18;

import java.io.File;
import java.io.IOException;

/**
 * 18.1.2
 * Created by admin on 2018/4/3.
 * 创建一个工具，它可以在目录中穿行，并且根据Strategy对象来处理这些目录中的文件（策略设计模式）
 */
public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }
    private Strategy strategy;
    private String ext;
    public ProcessFiles(Strategy strategy,String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }
    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()) {
                        processDirectoryTree(fileArg);
                    } else {
                        if (!arg.endsWith("." + ext)) {
                            arg += "." +ext;
                        }
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取指定文件目录下的所有指定格式的文件
    public void processDirectoryTree(File root) throws IOException {
        //默认遍历文件
        for (File file : Directory.walk(root.getAbsolutePath(),".*\\." + ext)) {
            strategy.process(file.getCanonicalFile());
        }
    }
    //主方法
    public static void main(String[] args) {
        new ProcessFiles(new Strategy() {
            public void process(File file) {
                System.out.println(file);
            }
        },"java").start(args);
    }
}
