package com.alexander.java.example.java9.flow;

import java.util.concurrent.Flow;

public class MySubscriber implements Flow.Subscriber<Integer> {

    private Flow.Subscription subscription;
    private static int MAX_RETRIES = 5;
    private int attempts = 0;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.println("I'm subscribed");
        subscription.request(1);
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("Received: " + item);

        if (item == null) {
            System.out.println("Request returned nothing, waiting...");
            synchronized (subscription) {
                try {
                    subscription.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            attempts++;
        }

        if (attempts >= MAX_RETRIES) {
            subscription.cancel();
        } else {
            subscription.request(1);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Ooops: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Poke me with a fork I'm done");
    }
}
