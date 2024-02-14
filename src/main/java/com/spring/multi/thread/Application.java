package com.spring.multi.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(Application.class, args);
    }

}
