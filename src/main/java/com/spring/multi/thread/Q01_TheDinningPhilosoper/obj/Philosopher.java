package com.spring.multi.thread.Q01_TheDinningPhilosoper.obj;

import com.spring.multi.thread.utility.SleepHelper;
import lombok.extern.slf4j.Slf4j;

/* example:
p3 (cs3, cs4) -> get cs3 -> get cs4
p4 (cs4, cs0) -> get cs4
p0 (cs0, cs1) -> get cs0            => when p3 getcs4, p4 getcs4
p1 (cs1, cs2) -> get cs1               is executing simultaneously,
p2 (cs2, cs3) -> get cs2               deadlock is occurred
 */
@Slf4j
public class Philosopher extends Thread {

    private int index;
    private ChopStick left, right;

    public Philosopher(int index, ChopStick left, ChopStick right) {
        this.index = index;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        if (index % 2 == 0) { // 左撇子 algo, % 2 == 0 is more efficient
            synchronized (left) {
                SleepHelper.sleepSeconds(1);
                log.info(index + " number philosopher get the left chopstick.");
                synchronized (right) {
                    SleepHelper.sleepSeconds(1);
                    log.info(index + " number philosopher is finished the meal.");
                }
            }
        } else {
            synchronized (right) {
                SleepHelper.sleepSeconds(1);
                log.info(index + " number philosopher get the left chopstick.");
                synchronized (left) {
                    SleepHelper.sleepSeconds(1);
                    log.info(index + " number philosopher get the right chopstick.");
                    log.info(index + " number philosopher is finished the meal.");
                }
            }
        }
    }

}
