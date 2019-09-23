package com.banggood.bozong.study.design.factory.abstractFactory;

public class Client {
    public static void main(String[] args) {
        CarFactory factory = new LuxuryCarFactory();
        Engine engine = factory.createEngine();
        engine.run();
        engine.start();
    }
}
