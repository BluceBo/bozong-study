package com.banggood.bozong.study.crazyjava.chapter6;

public class AnonymousInner {
    public void test(Device d){
        System.out.println("购买一个" + d.getName() + "，花掉了" + d.getPrice());
    }

    public static void main(String[] args) {
        AnonymousInner ai = new AnonymousInner();
        //调用有参数的构造器创建Device匿名内部类的对象
        ai.test(new Device() {
            @Override
            public double getPrice() {
                return 67.8;
            }
        });
        //调用无参的构造器创建Device匿名实现类的对象
        Device d = new Device() {
            //初始化块
            {
                System.out.println("匿名内部类初始化块........");
            }
            @Override
            public double getPrice() {
                return 56.2;
            }
            //重写实例方法
            public String getName() {
                return "键盘";
            }
        };
        ai.test(d);
    }
}
