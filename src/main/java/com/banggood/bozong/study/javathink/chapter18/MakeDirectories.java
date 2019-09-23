package com.banggood.bozong.study.javathink.chapter18;

import java.io.File;

/**
 * Created by admin on 2018/4/6.
 * File类不仅仅只代表存在的文件或目录。
 * 也可以用File对象来创建新的目录或尚不存在的整个目录路径，
 * 我们还可以查看文件的特性（如：大小，最后修改日期，读/写）,
 * 检查某个File对象代表的是一个文件还是一个目录，并可以删除文件。
 * 下面的示例展示了File类的一些其他方法
 */
public class MakeDirectories {
    private static void usage() {
        System.err.println("Usage:MakeDirectories path1 ... \n" +
                            "Creates each path \n" +
                            "Usage:MakeDirectories -d path1 ... \n" +
                            "Deletes each path \n" +
                            "Usage:MakeDirectories -r path1 path2 \n" +
                            "Renames from path1 to path2");
        System.exit(1);
    }
    private static void fileData(File file) {
        System.out.println("Absolute path: " + file.getAbsolutePath() +
                            "\n Can read: " + file.canRead() +
                            "\n Can write: " + file.canWrite() +
                            "\n getName: " + file.getName() +
                            "\n getParent: " + file.getParent() +
                            "\n getPath: " + file.getPath() +
                            "\n length: " + file.length() +
                            "\n lastModified: " + file.lastModified());
        if (file.isFile()) {
            System.out.println("It's a file");
        } else if (file.isDirectory()) {
            System.out.println("It's a directory");
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            usage();
        }
        if (args[0].equals("-r")) {
            if (args.length != 3) {
                usage();
            }
            File old = new File(args[1]);
            File rname = new File(args[2]);
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return;
        }
        int count = 0;
        boolean del = false;
        if (args[0].equals("-d")) {
            count++;
            del = true;
        }
        count--;
        while (++count < args.length) {
            File file = new File(args[count]);
            if (file.exists()) {
                System.out.println(file + "exists");
                if (del) {
                    System.out.println("deleting......" + file);
                    file.delete();
                }
            } else {
                if (!del) {
                    file.mkdirs();
                    System.out.println("created " + file);
                }
            }
            fileData(file);
        }
    }
}
