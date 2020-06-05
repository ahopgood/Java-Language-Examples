package com.alexander.java.example.java9.flow;


import java.util.concurrent.Flow;

public class MyPublisher implements Flow.Publisher<Integer> {

    private MySubscription subscription = new MySubscription();

    public MyPublisher() {
    }

    @Override
    public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
        subscription.addSubscriber(subscriber);
        subscriber.onSubscribe(subscription);
    }

    public void submit(Integer i) {
        subscription.offer(i);
    }
}
