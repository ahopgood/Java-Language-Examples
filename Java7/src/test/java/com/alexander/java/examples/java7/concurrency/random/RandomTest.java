package com.alexander.java.examples.java7.concurrency.random;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {

    @Test
    public void testRandom(){
        int threadLocalRandom = ThreadLocalRandom.current().nextInt();
        int secureRandom = new SecureRandom().nextInt();
        int random = new Random().nextInt();

        System.out.println("ThreadLocalRandom \t:"+threadLocalRandom);
        System.out.println("SecureRandom \t\t:"+secureRandom);
        System.out.println("Random\t\t\t\t:"+random);
    }
}
