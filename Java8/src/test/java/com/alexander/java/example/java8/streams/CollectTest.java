package com.alexander.java.example.java8.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static org.junit.Assert.assertEquals;

public class CollectTest {

    List<Integer> numbers = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

    @Test
    public void testCollectToList(){
        List<Integer> lessThanFour = numbers.stream()
                .filter(x -> x > 4)
                .collect(toList());
        assertEquals(5, lessThanFour.size());
    }

    List<String> words = Arrays.asList("This", "is", "what", "I", "expect");
    String sentence = "This,is,what,I,expect";

    @Test
    public void testCollectJoin(){
        String lessThanFour = words.stream()
                .collect(joining(","));
        assertEquals(sentence, lessThanFour);
    }

    @Test
    public void testCollectToMap(){
        Map<Integer, String> map = numbers.stream()
                .filter(x -> x > 4)
                .collect(toMap(i -> i, i -> "" + i));
        assertEquals(5, map.size());

        Map<Integer, String> mapUsingIdentity = numbers.stream()
                .filter(x -> x > 4)
                .collect(toMap(Function.identity(), i -> "" + i));
        assertEquals(5, mapUsingIdentity.size());
    }
}
