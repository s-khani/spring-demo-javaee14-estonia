package com.sda.springdemojavaee14.homework.ex1;


import org.springframework.stereotype.Component;

@Component //Component is bean - class manage by Spring
public class Car {
    private final Engine engine;
    private final Body body;
    private final Wheel frontLeft;
    private final Wheel frontRight;
    private final Wheel rearLeft;
    private final Wheel rearRight;

    public Car(Engine engine, Body body, Wheel frontLeft, Wheel frontRight, Wheel rearLeft, Wheel rearRight) {
        this.engine = engine;
        this.body = body;
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.rearLeft = rearLeft;
        this.rearRight = rearRight;

        System.out.println("Creating new car");
    }


}
