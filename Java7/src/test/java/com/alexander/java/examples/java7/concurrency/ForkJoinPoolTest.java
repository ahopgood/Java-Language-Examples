package com.alexander.java.examples.java7.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ForkJoinPool fjp = new ForkJoinPool();

       ForkJoinTask<Integer> taskFuture = fjp.submit(new FibbonacciTask(7));
       System.out.println(taskFuture.get());

//        fjp.invoke(); //wait
//        fjp.execute(); //async
//        fjp.submit(); //async & future

        int[] array = {0,1,2,3,4,5,6,7,8,9};
        ForkJoinTask<Void> task = fjp.submit(new IncrementTask(array, 10, 0));
        task.get();
        while(!task.isDone()){
            System.out.println("Waiting");
        }
        for (int i : array){
            System.out.println(i +" "+array[i]);
        }
    }

    public class FibbonacciTask extends RecursiveTask<Integer> {

        private Integer value;

        public FibbonacciTask(Integer value){
            this.value = value;
        }

        @Override
        protected Integer compute() {
            if (value <= 1){
                return value;
            }

            FibbonacciTask f1 = new FibbonacciTask(value -1);
            FibbonacciTask f2 = new FibbonacciTask(value -2);

            f1.fork();
            f2.fork();
            return f1.join() + f2.join() ;
        }
    }

    public class IncrementTask extends RecursiveAction {

        private int high;
        private int low;
        private int[] array;
        private int threshold = 10;

        public IncrementTask(int[] array, int high, int low){
            this.low = low;
            this.high = high;
            this.array = array;
        }

        @Override
        protected void compute() {
            if (high - low < threshold){
                System.out.println("Changing stuff");
                for (int i = low; i < high; ++i){
                    System.out.println("Changing array stuff");
                    array[i]++;
                }
            } else {
                int mid = (low + high) >>> 1;
                invokeAll(new IncrementTask(array, low, mid),
                        new IncrementTask(array, mid, high));
            }
        }
    }
}
