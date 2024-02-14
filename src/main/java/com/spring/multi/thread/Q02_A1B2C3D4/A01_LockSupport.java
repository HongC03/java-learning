package com.spring.multi.thread.Q02_A1B2C3D4;

import com.spring.multi.thread.utility.HelperUtility;

import java.util.concurrent.locks.LockSupport;

public class A01_LockSupport {

    public static void main(String[] args) {
        final Thread[] threads = new Thread[2];
        String[] alphaArr = HelperUtility.generateAlphaArr();
        String[] numArr = HelperUtility.generateNumArr();
        StringBuffer sb = new StringBuffer();

        threads[0] = new Thread(() -> {
            for (String alpha : alphaArr) {
                sb.append(alpha);
                LockSupport.unpark(threads[1]);
                LockSupport.park();
            }
            ;
        }, "t1");

        threads[1] = new Thread(() -> {
            for (String num : numArr) {
                LockSupport.park();
                sb.append(num);
                LockSupport.unpark(threads[0]);
            }
            ;
        }, "t2");

        threads[0].start();
        threads[1].start();

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String result = sb.toString();
        System.out.println(result);


    }

}
