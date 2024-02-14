package com.spring.multi.thread.Q01_TheDinningPhilosoper;

import com.spring.multi.thread.Q01_TheDinningPhilosoper.obj.ChopStick;
import com.spring.multi.thread.Q01_TheDinningPhilosoper.obj.Philosopher;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class T01_DeadLock {

    public static void main(String[] args) {
        ChopStick cs0 = new ChopStick();
        ChopStick cs1 = new ChopStick();
        ChopStick cs2 = new ChopStick();
        ChopStick cs3 = new ChopStick();
        ChopStick cs4 = new ChopStick();

        Philosopher p0 = new Philosopher(0, cs0, cs1);
        Philosopher p1 = new Philosopher(1, cs1, cs2);
        Philosopher p2 = new Philosopher(2, cs2, cs3);
        Philosopher p3 = new Philosopher(3, cs3, cs4);
        Philosopher p4 = new Philosopher(4, cs4, cs0);

        p0.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }
}
