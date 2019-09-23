package com.banggood.bozong.study.design.factory.factoryMethod;

public class BenzFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Benz();
    }
}
