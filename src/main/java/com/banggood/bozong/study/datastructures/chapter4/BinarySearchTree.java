package com.banggood.bozong.study.datastructures.chapter4;

/**
 * Created by admin on 2018/4/12.
 */
public class BinarySearchTree<T extends  Comparable<? super T>> {
    //创建一个树节点类
    private static class  BinaryNode<T>{
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;
        BinaryNode(T theElement) {
            this(theElement,null,null);
        }
        BinaryNode(T theElement,BinaryNode<T> lt,BinaryNode<T> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
    }
}
