package com.alexander.java.example.java8;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alexander on 28/06/2017.
 */
public class DoubleBraceInitialiserTest {

    @Test
    public void testEmptyInitialiser() throws Exception {
        DoubleBraceInitialiser dblBrace = new DoubleBraceInitialiser();
        assertTrue(dblBrace.emptyInitialiser().isEmpty());
        assertEquals(0, dblBrace.emptyInitialiser().size());
    }

    @Test
    public void testWithContents() throws Exception {
        DoubleBraceInitialiser dblBrace = new DoubleBraceInitialiser();
        assertFalse(dblBrace.withContents().isEmpty());
        assertEquals(1, dblBrace.withContents().size());
    }
}