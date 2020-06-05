package com.alexander.java.example.java9.flow;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Flow;

public class MySubscription implements Flow.Subscription {

    private Queue<Integer> buffer = new PriorityQueue<>();
    private Flow.Subscriber subscriber;

    public void addSubscriber(Flow.Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    void offer(Integer i) {
        buffer.add(i);
    }

    @Override
    public void request(long n) {
        System.out.println("Trying to request " + n + " elements");
        if (n > Integer.MAX_VALUE) {
            subscriber.onError(new RuntimeException(n + " exceeds " + Integer.MAX_VALUE));
        }
        for (int i = 0; i < n; i++) {
            if (buffer.isEmpty()) {
                subscriber.onNext(null);
            } else {
                subscriber.onNext(buffer.remove());
            }

        }
    }

    @Override
    public void cancel() {
        subscriber.onComplete();
    }
}
