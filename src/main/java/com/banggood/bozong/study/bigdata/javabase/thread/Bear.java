package com.banggood.bozong.study.bigdata.javabase.thread;

/**
 * @Author: admin
 * @Description:
 * @Date: 2018/8/8 22:51
 * @Modified By:
 * @Version: 1.0
 */
public class Bear extends Thread{
    private HoneyPool honeyPool;
    private String name;
    public Bear(HoneyPool honeyPool,String name) {
        this.honeyPool = honeyPool;
        this.name = name;
    }
    @Override
    public void  run() {
        while (true) {
            if (honeyPool.size() >= 20) {
                int index = honeyPool.remove();
                System.out.println("熊:" + name + "吃掉第" + index + "个蜂蜜");
            }
        }
    }
}
