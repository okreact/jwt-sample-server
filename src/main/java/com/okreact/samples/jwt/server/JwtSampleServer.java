package com.okreact.samples.jwt.server;

import com.okreact.samples.jwt.server.model.Greeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class JwtSampleServer {

    @RequestMapping("/greeting")
    Greeting greeting() {

        return Greeting.builder().id(new Long(1)).content("Hello, World!").build();
    }

    public static void main(String[] args) {
        SpringApplication.run(JwtSampleServer.class, args);
    }
}
