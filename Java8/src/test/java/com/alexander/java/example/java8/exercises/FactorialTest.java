package com.alexander.java.example.java8.exercises;

import com.alexander.java.example.java8.exercises.factorial.Factorial;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class FactorialTest {

    Factorial iter;
    
    @Before
    public void setUp() throws Exception {
        iter = getFactorialImplementation();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testZero(){
        assertEquals(0, iter.factorial(0));
    }

    @Test
    public void testOne(){
        assertEquals(1, iter.factorial(1));
    }

    @Test
    public void testTwo(){
        assertEquals(2, iter.factorial(2));
    }

    @Test
    public void testThree(){
        assertEquals(6, iter.factorial(3));
    }

    @Test
    public void testFour(){
        assertEquals(24, iter.factorial(4));
    }

    @Test
    public void testNegative(){
        assertEquals(0, iter.factorial(-1));
    }

    @Test
    public void testVeryLargeNumber(){
        assertEquals(39916800, iter.factorial(11));
        assertEquals(20922789888000L, iter.factorial(16));
    }

    public abstract Factorial getFactorialImplementation();



}