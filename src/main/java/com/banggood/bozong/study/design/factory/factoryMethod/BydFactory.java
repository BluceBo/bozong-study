package com.banggood.bozong.study.design.factory.factoryMethod;

public class BydFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Byd();
    }
}
