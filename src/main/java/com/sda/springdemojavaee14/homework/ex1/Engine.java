package com.sda.springdemojavaee14.homework.ex1;

public class Engine {

    private final Cylinder cylinder;
    private final Head head;

    public Engine(Cylinder cylinder, Head head) {
        this.cylinder = cylinder;
        this.head = head;

        System.out.println("Creating new engine");
    }
}
