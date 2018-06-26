package com.alexander.java.examples.java7.concurrency.transferqueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.lang.Integer;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A producer will add numbers to the transfer queue.
 * @param
 */
public class Producer implements Callable<Integer> {

    private final static Logger log = LoggerFactory.getLogger(Producer.class);
    private final TransferQueue<Integer> queue;
    private final Random random;
    private static AtomicInteger instanceCounter = new AtomicInteger(0);

    public Producer(TransferQueue queue){
        this.queue = queue;
        random = new Random();
    }

    @Override
    public Integer call() throws Exception {
        MDC.put("Thread", this.getClass().getSimpleName() + "-" + instanceCounter.incrementAndGet());

        Integer produced = new Integer(random.nextInt());
        log.info("Producing [" + produced + "]");
        boolean transferred = this.queue.tryTransfer(produced, 2, TimeUnit.SECONDS);
        if (transferred){
            log.info("Transferring [" + produced + "]");
        } else {
            this.queue.add(produced);
            log.info("Queuing ["+produced+"]");
        }

        MDC.remove("Thread");
        return produced;
    }
}
