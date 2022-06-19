package com.sda.springdemojavaee14.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //prepare all required beans for testing purposes
public class GreetingServiceTest {
    @Autowired // request to spring for providing the bean
    // should be only used on tests
     private GreetingService greetingService;

    @Test
    public void injectionTest(){
        Assertions.assertNotNull(greetingService,"GreetingService shouldn't be null");

    }
}
