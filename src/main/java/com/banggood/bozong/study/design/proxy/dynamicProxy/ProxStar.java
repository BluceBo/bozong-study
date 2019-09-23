package com.banggood.bozong.study.design.proxy.dynamicProxy;

public class ProxStar implements Star {
    private Star star;
    public ProxStar(Star star) {
        this.star = star;
    }
    @Override
    public void confer() {
        System.out.println("ProxStar.confer()");
    }

    @Override
    public void signContract() {
        System.out.println("ProxStar.signContract()");
    }

    @Override
    public void bookTicket() {
        System.out.println("ProxStar.bookTicket()");
    }

    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("ProxStar.collectMoney()");
    }
}
