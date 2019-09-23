package com.banggood.bozong.study.test.javathink;

import com.banggood.bozong.study.javathink.chapter18.Directory;
import org.junit.Test;

import java.io.File;

/**
 * Created by admin on 2018/4/5.
 * 练习4：使用Directory.walk()来计算在目录中所有名字与特定的正则表达式相匹配的文件的尺寸总和
 * 技术点：使用File对象中的length()方法获取文件大小
 */
public class Test4 {
    @Test
    public void fileSize() {
        long size = 0;
        for (File file : Directory.walk(".",".*\\.java")) {
            size+= file.length();
            System.out.println(file);
        }
        System.out.println(size);
    }
}
