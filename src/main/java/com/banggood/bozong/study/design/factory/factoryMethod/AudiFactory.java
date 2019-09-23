package com.banggood.bozong.study.design.factory.factoryMethod;

public class AudiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }
}
