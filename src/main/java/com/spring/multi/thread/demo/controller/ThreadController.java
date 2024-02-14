package com.spring.multi.thread.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ThreadController {

    @GetMapping("/thread")
    public void getThreadTask() throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            Thread.sleep(10000);
            return "callback is finished";
        };
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        String result = futureTask.get();
        log.info(result);
    }

}
