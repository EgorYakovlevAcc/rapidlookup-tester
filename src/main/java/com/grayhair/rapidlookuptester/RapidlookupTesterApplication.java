package com.grayhair.rapidlookuptester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RapidlookupTesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RapidlookupTesterApplication.class, args);
    }

}
