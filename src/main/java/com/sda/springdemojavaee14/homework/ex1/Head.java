package com.sda.springdemojavaee14.homework.ex1;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class Head {

    public Head() {
        System.out.println("Creating head");
    }
}
