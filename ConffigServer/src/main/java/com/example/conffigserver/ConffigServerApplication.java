package com.example.conffigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConffigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConffigServerApplication.class, args);
    }

}
