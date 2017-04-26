package com.alexander.java.examples.java7.concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Phaser;

/**
 * Demonstration of a {@link Phaser} which is a reusable synchronization barrier.
 *
 * Tasks register with the Phaser.
 * Tasks arrive at a particular phase within the phaser's sequence of phases, this phase number is important.
 * Tasks then wait for the rest of tasks to arrive at the phaser, tasks can be registered to activate on a particular phase.
 * The phaser advances to the next phase after all tasks arrive for a particular phase.
 *
 * Created by alexhopgood on 05/01/17.
 */
public class PhaserUsage {

    public static void main(String[] args){
        PhaserUsage usage = new PhaserUsage();
        System.out.println(System.currentTimeMillis());
        List<Runnable> tasks = new LinkedList<Runnable>();
        for (int i = 0; i < 25; i++){
            tasks.add(new PhaserUsage().new Printer(i));
        }
//        usage.runTasks(tasks);
        usage.runTasksInTwoPhases(tasks);
        System.out.println(System.currentTimeMillis());
    }

    void runTasks(List<Runnable> tasks) {
        final Phaser phaser = new Phaser(1); // "1" to register self
        // create and start threads
        for (final Runnable task : tasks) {
            System.out.println("Registering task in phase " + phaser.register());
            new Thread() {
                public void run() {
                    phaser.arriveAndAwaitAdvance(); // await all creation
                    task.run();
                }
            }.start();
        }

        // allow threads to start and deregister self
        phaser.arriveAndDeregister();
    }

    void runTasksInTwoPhases(List<Runnable> tasks) {
        final Phaser phaser = new Phaser(1); // "1" to register self
        // create and start threads
        phaser.bulkRegister(10);
        for (final Runnable task : tasks) {
            System.out.println("Registering task in phase "+phaser.register());
            new Thread() {
                public void run() {
                    phaser.arriveAndAwaitAdvance(); // await all creation
                    task.run();
                }
            }.start();
        }

        // allow threads to start and deregister self
        phaser.arriveAndDeregister();
    }

    public class Printer implements Runnable{
        int count = 0;
        public Printer(int i){
            count = i;
        }
        @Override
        public void run() {
            System.out.println(count+" "+System.currentTimeMillis());
        }
    }
}
