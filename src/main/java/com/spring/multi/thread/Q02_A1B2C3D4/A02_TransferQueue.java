package com.spring.multi.thread.Q02_A1B2C3D4;

import com.spring.multi.thread.utility.HelperUtility;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class A02_TransferQueue {

    public static void main(String[] args) {
        String[] alphaArr = HelperUtility.generateAlphaArr();
        String[] numArr = HelperUtility.generateNumArr();
        StringBuffer sb = new StringBuffer();
        TransferQueue<String> queue = new LinkedTransferQueue<>();

        Thread producer = new Thread(() -> {
            for (String alpha : alphaArr) {
                try {
                    queue.transfer(alpha);
                    sb.append(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "producer");

        Thread consumer = new Thread(() -> {
            for (String num : numArr) {
                try {
                    sb.append(queue.take());
                    queue.transfer(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "consumer");

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = sb.toString();
        System.out.println(result);

    }

}
