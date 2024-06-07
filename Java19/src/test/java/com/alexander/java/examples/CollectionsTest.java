package com.alexander.java.examples;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionsTest {

    @Test
    void HashMapTest() {
        var myMap = HashMap.newHashMap(5);
        myMap.put(1,1);
        myMap.put(2,2);
        myMap.put(3,3);
        myMap.put(4,4);
        myMap.put(5,5);
        //resize now we're at capacity
        myMap.put(6,6);
    }

    @Test
    void LinkedHashMapTest() {
        LinkedHashMap.newLinkedHashMap(5);
    }

    @Test
    void WeakHashMapTest() {
        WeakHashMap.newWeakHashMap(5);
    }

    @Test
    void HashSetTest() {
        HashSet.newHashSet(5);
    }

    @Test
    void LinkedHashSetTest() {
        LinkedHashSet.newHashSet(5);
        LinkedHashSet.newHashSet(5);
    }
}
