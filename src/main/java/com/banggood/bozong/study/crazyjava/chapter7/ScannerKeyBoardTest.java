package com.banggood.bozong.study.crazyjava.chapter7;

import java.util.Scanner;

public class ScannerKeyBoardTest {
    public static void main(String[] args) {
        //System.in代表标准输入也就是键盘输入
        Scanner sc = new Scanner(System.in);
        //把回车作为分隔符
        sc.useDelimiter("\n");
        //判断是否还有下一个输入项
        while (sc.hasNext()) {
            //输出输入项
            System.out.println("键盘输入的内容是："+sc.next());
        }
    }
}
