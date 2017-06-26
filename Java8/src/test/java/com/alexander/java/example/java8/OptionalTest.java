package com.alexander.java.example.java8;

import org.junit.Test;

import java.util.Optional;
import java.util.jar.Pack200;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander on 26/06/2017.
 */
public class OptionalTest {
    
    @Test
    public void testNullValues(){
        Optional empty = Optional.empty();
        Optional emptyToo = Optional.ofNullable(null);
        assertEquals(empty, emptyToo);
    }
    
    @Test
    public void testAccess(){
        Optional a = Optional.of("a");
        assertEquals("a", a.get());
    }
    
    @Test
    public void testIsPresent(){
        Optional empty = Optional.empty();
        assertFalse(empty.isPresent());
        Optional a = Optional.of("s");
        assertTrue(a.isPresent());
    }
    
    @Test
    public void testOrElse(){
        Optional empty = Optional.empty();
        assertFalse(empty.isPresent());
        assertEquals("c",empty.orElse("c"));
        
        assertEquals("d", empty.orElseGet(() -> "d"));
        
        boolean exception = false;
        try {
            empty.orElseThrow(() -> new RuntimeException("blah"));
        } catch (Throwable e){
            exception = true;
        }
        assertTrue(exception);
        
        Optional present = Optional.of("a");
        present.ifPresent( x -> System.out.println("Contents "+x));
        
        
    }
}
