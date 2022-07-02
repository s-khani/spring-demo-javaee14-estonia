package com.sda.springdemojavaee14.homework.ex1;

public class Main {
    public static void main(String[] args) {
        Wheel one = new Wheel();
        Wheel two = new Wheel();
        Wheel three = new Wheel();
        Wheel four = new Wheel();

        Body carBody = new Body();

        Cylinder engineCylinder = new Cylinder();
        Head engineHead = new Head();

        Engine carEngine = new Engine(engineCylinder,engineHead);


        System.out.println("Now we're ready to create car");

        Car mazda = new Car(
                carEngine,
                carBody,
                one,
                two,
                three,
                four
        );

        System.out.println("Car is ready!!!");
    }



}
