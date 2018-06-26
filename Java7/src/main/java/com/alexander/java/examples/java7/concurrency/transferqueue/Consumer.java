package com.alexander.java.examples.java7.concurrency.transferqueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.concurrent.Callable;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A Consumer will read numbers from a transfer queue
 */
public class Consumer implements Callable<Integer>  {

    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    private final TransferQueue<Integer> queue;

    private static AtomicInteger instanceCounter = new AtomicInteger(0);

    public Consumer(TransferQueue<Integer> queue){
        this.queue = queue;
        instanceCounter.incrementAndGet();
    }

    @Override
    public Integer call() throws Exception {
        MDC.put("Thread", this.getClass().getSimpleName()+"-"+instanceCounter.get());
        Integer consumed = queue.take();

        log.info("Consumed object ["+consumed+"]");
        MDC.remove("Thread");
        return consumed;
    }
}
