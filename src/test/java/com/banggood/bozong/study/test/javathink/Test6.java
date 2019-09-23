package com.banggood.bozong.study.test.javathink;

import com.banggood.bozong.study.javathink.chapter18.ProcessFiles;
import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2018/4/6.
 * 练习6：使用ProcessFiles来查找在某个特定目录子树下的所有在某个特定日期之后进行过修改的java源文件
 */
public class Test6 {
    @Test
    public void fileChange() throws ParseException {
        String[] str={".."};
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Date date = simpleDateFormat.parse("2018-04-05");
        new ProcessFiles(new ProcessFiles.Strategy() {
            public void process(File file) {
                //System.out.println(file + " 最后修改时间:" + file.lastModified());
                if (file.lastModified() > date.getTime()) {
                    System.out.println(file);
                }
            }
        },"java").start(str);
    }
}
