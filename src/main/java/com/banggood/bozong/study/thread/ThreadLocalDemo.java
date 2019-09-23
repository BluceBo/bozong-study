package com.banggood.bozong.study.thread;

class Res {
    //生成序列共享变量
    public static Integer count = 0;
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 0;
        }
    };
    public Integer getNum() {
        int count = threadLocal.get() + 1;
        threadLocal.set(count);
        return count;
    }
}

/**
* @description: 线程局部变量演示Demo
* @author:  blucebo
* @createDate:  2019/1/23 21:49
* @updateUser:  blucebo
* @updateDate:  2019/1/23 21:49
* @updateRemark:
* @version: 1.0
*/
public class ThreadLocalDemo extends Thread{
    private Res res;
    public ThreadLocalDemo(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0;i < 3;i++) {
            System.out.println(Thread.currentThread().getName() + "-----" + "i------" + i + "-----num:" + res.getNum());
        }
    }

    public static void main(String[] args) {
        Res res = new Res();
        ThreadLocalDemo threadLocalDemo1 = new ThreadLocalDemo(res);
        ThreadLocalDemo threadLocalDemo2 = new ThreadLocalDemo(res);
        ThreadLocalDemo threadLocalDemo3 = new ThreadLocalDemo(res);
        threadLocalDemo1.start();
        threadLocalDemo2.start();
        threadLocalDemo3.start();
    }
}
