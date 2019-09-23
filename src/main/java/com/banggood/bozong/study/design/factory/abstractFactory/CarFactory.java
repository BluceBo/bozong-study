package com.banggood.bozong.study.design.factory.abstractFactory;

public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
    Tyre createTyre();
}
