package com.sda.springdemojavaee14.controller;

import com.sda.springdemojavaee14.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController creates now Spring bean based on the class
//bean = component = managed object (object created by Spring for us)
//TOO:install postman
@RestController
public class MyFirstRestController {

    private static final Logger log = LoggerFactory.getLogger(MyFirstRestController.class);
    private final GreetingService greetingService;


    //dependency injection providing required collaborators/dependencies by Spring
    //@Autowired
    public MyFirstRestController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    //@GetMapping means
    // - code of the method will be run when we hit endpoint
    //we use exact HTTP method
    @GetMapping("/say-hello")
    public String hello() {
        // TODO: explain logger level
        log.info("hello method was called...");

        return "Welcome to spring class!!!";
    }

    @GetMapping("/greeting")
    public String greetUser(){
        log.info("greetUser");
        return greetingService.makeSomeGreetingToUser("Samaneh");
    }
}
