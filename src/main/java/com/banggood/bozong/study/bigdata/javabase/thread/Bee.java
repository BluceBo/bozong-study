package com.banggood.bozong.study.bigdata.javabase.thread;

/**
 * @Author: admin
 * @Description:
 * @Date: 2018/7/25 23:02
 * @Modified By:
 * @Version: 1.0
 */
public class Bee extends Thread{
    private static int index = 0;
    private HoneyPool honeyPool;
    private String name;
    public Bee(HoneyPool honeyPool,String name) {
        super();
        this.honeyPool=honeyPool;
        this.name = name;
    }
    @Override
    public void run() {
        while (true) {
            honeyPool.add(index);
            System.out.println("蜜蜂：" + name + "产生第" + index + "个蜂蜜");
            index++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
