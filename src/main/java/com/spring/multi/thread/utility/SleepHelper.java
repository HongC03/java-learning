package com.spring.multi.thread.utility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SleepHelper {

    public static void sleepSeconds(int second) {
        try {
            Long milliSeconds = (long) second * 1000;
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

}
