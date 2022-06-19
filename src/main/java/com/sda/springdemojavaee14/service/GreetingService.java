package com.sda.springdemojavaee14.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j // provide lof field for us
//as the same as private static final Logger log = LoggerFactory.getLogger(GreetingService.class);
public class GreetingService {
    public String makeSomeGreetingToUser(String name){

        String result = "Welcome to Sprig class " + name;
        log.info(result);
        return result;

    }
}
