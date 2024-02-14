package com.spring.multi.thread.demo.thread;

import java.util.concurrent.Callable;

public class DemoCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello world";
    }
}
