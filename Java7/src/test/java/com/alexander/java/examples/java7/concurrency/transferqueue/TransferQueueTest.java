package com.alexander.java.examples.java7.concurrency.transferqueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class TransferQueueTest {

    private static final Logger log = LoggerFactory.getLogger(TransferQueueTest.class);
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);
    private TransferQueue<Integer> queue;
    private Consumer cons;
    private Producer prod;

    @Before
    public void setUp(){
        BasicConfigurator.configure(new ConsoleAppender(
                new PatternLayout("%d{ISO8601} [%t %X{Thread}] %m%n")));
        queue = new LinkedTransferQueue<>();
        cons = new Consumer(queue);
        prod = new Producer(queue);
    }

    @Test
    public void testDelayedTransfer() throws InterruptedException, ExecutionException {
        Future<Integer> produced = executorService.submit(prod);
        log.info("Scheduled producer");
        synchronized (produced) {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        }
        Future<Integer> retrieved = executorService.submit(cons);
        log.info("{}",produced.get());
        assertNotNull(retrieved.get());
        assertTrue(queue.isEmpty());
        executorService.shutdown();
    }

    @Test
    public void testQueued() throws InterruptedException, ExecutionException {
        Future<Integer> produced = executorService.submit(prod);
        log.info("Scheduled producer");

        synchronized (produced) {
            Thread.sleep(TimeUnit.SECONDS.toMillis(6));
        }

        Future<Integer> retrieved = executorService.submit(cons);
        log.info("{}",produced.get());
        assertNotNull(retrieved.get());
        assertTrue(queue.isEmpty());
        executorService.shutdown();
    }

    @Test
    public void testImmediateTransfer() throws ExecutionException, InterruptedException {
        Future<Integer> produced = executorService.submit(prod);
        Future<Integer> retrieved = executorService.submit(cons);

        log.info("{}",produced.get());
        assertNotNull(retrieved.get());
        assertTrue(queue.isEmpty());
        executorService.shutdown();
    }

    @Test
    public void testNoTransfer() throws ExecutionException, InterruptedException {
        Future<Integer> produced = executorService.submit(prod);
        log.info("{}",produced.get());
        assertEquals(1,queue.size());
        executorService.shutdown();
    }
}
