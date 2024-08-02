package com.alexander.java.examples;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class VirtualThreadTest {

    private static final int THREAD_COUNT = 10_000;
    private static final int LESS_THAN_OS_PROCESSES_THREAD_COUNT = 4000;

    @Test
    void givenTooManyThreads_platformThreadTest() {
        assertThrows(OutOfMemoryError.class, () -> {
            try (var executor = Executors.newThreadPerTaskExecutor(Executors.defaultThreadFactory())) {
                IntStream.range(0, THREAD_COUNT).forEach(i -> executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                }));
            }  // executor.close() is called implicitly, and waits
        });
    }

    @Test
    void givenFewerThreads_platformThreadTest() {
        LocalDateTime start = LocalDateTime.now();
        try (var executor = Executors.newThreadPerTaskExecutor(Executors.defaultThreadFactory())) {
            IntStream.range(0, LESS_THAN_OS_PROCESSES_THREAD_COUNT).forEach(i -> executor.submit(() -> {
                Thread.sleep(Duration.ofSeconds(1));
                return i;
            }));
        }  // executor.close() is called implicitly, and waits
        LocalDateTime end = LocalDateTime.now();
        System.out.println(Duration.between(start, end).toMillis() + "ms");
    }

    @Test
    void givenFixedThreadPool_platformThreadTest() {
        LocalDateTime start = LocalDateTime.now();
        try (var executor = Executors.newFixedThreadPool(2000)) {
            IntStream.range(0, THREAD_COUNT).forEach(i -> executor.submit(() -> {
                Thread.sleep(Duration.ofSeconds(1));
                return i;
            }));
        }  // executor.close() is called implicitly, and waits
        LocalDateTime end = LocalDateTime.now();
        System.out.println(Duration.between(start, end).toMillis() + "ms");
    }

//    @Test
//    void givenSingleThread_platformThreadTest() {
//        LocalDateTime start = LocalDateTime.now();
//        try (var executor = Executors.newSingleThreadExecutor()) {
//            IntStream.range(0, THREAD_COUNT).forEach(i -> {
//                executor.submit(() -> {
//                    Thread.sleep(Duration.ofSeconds(1));
//                    return i;
//                });
//            });
//        }  // executor.close() is called implicitly, and waits
//        LocalDateTime end = LocalDateTime.now();
//        System.out.println(Duration.between(start, end).toMillis() + "ms");
//    }

    @Test
    void virtualThreadTest() {
        LocalDateTime start = LocalDateTime.now();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, THREAD_COUNT).forEach(i -> executor.submit(() -> {
                Thread.sleep(Duration.ofSeconds(1));
                return i;
            }));
        }  // executor.close() is called implicitly, and waits
        LocalDateTime end = LocalDateTime.now();
        System.out.println(Duration.between(start, end).toMillis() + "ms");
    }
}
