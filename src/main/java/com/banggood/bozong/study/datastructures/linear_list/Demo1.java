package com.banggood.bozong.study.datastructures.linear_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo1 {
    private List list = new  ArrayList();
    private List linkedList = new LinkedList();
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int[] arr = new int[10];
        for (int i =0;i<5;i++) {
            arr[i] = i;
        }
        System.arraycopy(arr,2,arr,3,3);
        arr[2] = 6;
        for (int i : arr) {
            System.out.println("遍历数组值："+i);
        }
    }
}
