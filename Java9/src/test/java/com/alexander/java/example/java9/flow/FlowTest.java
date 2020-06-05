package com.alexander.java.example.java9.flow;


import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class FlowTest {

    private final MyPublisher publisher = new MyPublisher();
    private final MySubscriber subscriber = new MySubscriber();

    @Test
    void testSubscribe() {
        publisher.subscribe(subscriber);
    }

    @Test
    void testRequest() {
        Stream.of(1, 2, 3, 4, 5).forEach(i -> publisher.submit(i));
        publisher.subscribe(subscriber);
    }
}
