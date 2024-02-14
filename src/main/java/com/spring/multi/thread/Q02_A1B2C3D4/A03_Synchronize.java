package com.spring.multi.thread.Q02_A1B2C3D4;

import com.spring.multi.thread.utility.HelperUtility;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class A03_Synchronize {

    private static int state = 0;

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        Thread thread1;
        Thread thread2;
        Thread thread3;
        String[] alphaArr = HelperUtility.generateAlphaArr();
        String[] numArr = HelperUtility.generateNumArr();
        String[] randomArr = HelperUtility.generateRandomArr();
        StringBuffer sb = new StringBuffer();

        thread1 = new Thread(() -> {
            synchronized (lock) {
                for (String alpha : alphaArr) {
                    while (state % 3 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    state++;
                    sb.append(alpha);
                    lock.notifyAll();
                }
            }
        }, "t1");
        thread1.start();

        thread2 = new Thread(() -> {
            synchronized (lock) {
                for (String num : numArr) {
                    while (state % 3 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    state++;
                    sb.append(num);
                    lock.notifyAll();
                }
            }
        }, "t2");
        thread2.start();

        thread3 = new Thread(() -> {
            synchronized (lock) {
                for (String random : randomArr) {
                    while (state % 3 != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    state++;
                    sb.append(random);
                    lock.notifyAll();
                }
            }
        }, "t3");
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        String result = sb.toString();
        log.info(result);

    }

}
