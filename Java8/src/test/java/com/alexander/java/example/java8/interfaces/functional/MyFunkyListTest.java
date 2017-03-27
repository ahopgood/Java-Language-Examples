package com.alexander.java.example.java8.interfaces.functional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by alexhopgood on 27/02/17.
 */
public class MyFunkyListTest {

    MyFunkyList<Integer> funky = new MyFunkyList<>();
    MyFunkyList<String> funkyString = new MyFunkyList<String>();

    @Before
    public void setUp() throws Exception {
        funky.add(1);
        funky.add(2);
        funky.add(3);
        funky.add(4);
        funky.add(5);
        funky.add(6);

        funkyString.add("abc");
        funkyString.add("defg");
        funkyString.add("hijkl");
    }

    @After
    public void tearDown() throws Exception {

    }



    @Test
    public void testFunkyFilter_greaterThan3() throws Exception {
        LinkedList<Integer> filtered = funky.funkyFilter(value -> value > 3);
        assertEquals(3, filtered.size());
        assertEquals(Arrays.asList(4,5,6), filtered);
    }

    @Test
    public void testFunkyFilter_lessThan3() throws Exception {
        LinkedList<Integer> filtered = funky.funkyFilter(value -> value < 3);
        assertEquals(2, filtered.size());
        assertEquals(Arrays.asList(1,2), filtered);
    }

    @Test
    public void testOverridingFunkyFilter_lessThan3() throws Exception {
        LinkedList<Integer> filtered = funky.funkyFilter(value -> value < 3);
        assertEquals(2, filtered.size());
        assertEquals(Arrays.asList(1,2), filtered);
    }
}
