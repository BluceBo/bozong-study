package com.banggood.bozong.study.design.factory.factoryMethod;

public class Client {
    public static void main(String[] args) {
        Car audi = new AudiFactory().createCar();
        Car byd = new BydFactory().createCar();
         audi.run();
         byd.run();
    }
}
