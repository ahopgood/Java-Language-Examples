package com.alexander.java.examples.java7.concurrency;

import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedDeque;

import static org.junit.Assert.assertEquals;

public class ConcurrentLinkedDequeTest {

    @Test
    public void testAddFirst(){
        ConcurrentLinkedDeque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.add(2);
        deque.addFirst(1);
        assertEquals(1, deque.peekFirst().intValue());
        assertEquals(2, deque.peekLast().intValue());
    }

    @Test
    public void testAddLast(){
        ConcurrentLinkedDeque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.add(2);
        deque.addLast(3);
        assertEquals(2, deque.peekFirst().intValue());
        assertEquals(3, deque.peekLast().intValue());
    }

    @Test
    public void testRemoveFirst(){
        ConcurrentLinkedDeque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.add(1);
        deque.add(2);

        assertEquals(1, deque.removeFirst().intValue());
        assertEquals(2, deque.peekLast().intValue());
    }

    @Test
    public void testRemoveLast(){
        ConcurrentLinkedDeque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.add(1);
        deque.add(2);
        assertEquals(2, deque.removeLast().intValue());
        assertEquals(1, deque.peekLast().intValue());
    }

}
