package com.banggood.bozong.study.design.proxy.staticProxy;

public class Client {
    public static void main(String[] args) {
        Star real = new RealStar();
        Star proxy = new ProxStar(real);
        proxy.confer();
        proxy.bookTicket();
        proxy.signContract();
        proxy.sing();
        proxy.collectMoney();
    }
}
