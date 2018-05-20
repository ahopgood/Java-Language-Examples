package com.alexander.java.examples.java7.concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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

    public static void main(String[] args) throws InterruptedException {
        PhaserUsage usage = new PhaserUsage();
        System.out.println(System.currentTimeMillis());

        //This will register the phaser itself as a participant
        final Phaser phaser = new Phaser(1);
        List<Runnable> tasks = new LinkedList<Runnable>();
        for (int i = 0; i < 4; i++){
            tasks.add(new PhaserUsage().new Printer(i, phaser));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(tasks.size());
        int taskId = 0;
        for (final Runnable task : tasks) {
            System.out.println("Scheduling task "+taskId);
            executorService.submit(task);
            taskId ++;
        }
        //Having the main thread arrive will result in the # of registered threads matching those that have arrived
        phaser.arriveAndAwaitAdvance();
        System.out.println("End tasks "+System.currentTimeMillis());
        System.out.println("Phase "+phaser.getPhase());
        phaser.arriveAndDeregister();
        executorService.shutdown();
    }

    public class Printer implements Runnable{
        int count = 0;
        final Phaser phaser;
        public Printer(int i, Phaser phaser){
            count = i;
            this.phaser = phaser;
            System.out.println("Thread "+count+" registered to phase "+this.phaser.register());
        }
        @Override
        public void run() {
            System.out.println("This is phase " + phaser.getPhase() + " and thread count "+count);
            phaser.arriveAndAwaitAdvance();
            System.out.println(count+" "+System.currentTimeMillis());
            phaser.arriveAndDeregister();
        }
    }
}
