package com.alexander.java.example.java9;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionsTest {

    @Test (expected = UnsupportedOperationException.class)
    public void testListOf() {
        List<Integer> integerList = List.of(1, 2, 3, 4);
        assertThat(integerList.size()).isEqualTo(4);
        assertThat(integerList).containsOnly(1, 2, 3, 4);

        //Assert that list is immutable
        integerList.add(5);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testMapOf() {
        Map<Integer, String> integerStringMap = Map.of(1, "one", 2, "two");
        assertThat(integerStringMap.size()).isEqualTo(2);
        assertThat(integerStringMap).containsOnly(Map.entry(1, "one"), Map.entry(2, "two"));

        //Assert that list is immutable
        integerStringMap.put(3, "three");
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testSetOf() {
        Set<Integer> integerStringMap = Set.of(1, 2, 3, 4);
        assertThat(integerStringMap.size()).isEqualTo(4);
        assertThat(integerStringMap).containsOnly(1, 2, 3, 4);

        //Assert that list is immutable
        integerStringMap.add(5);
    }
}
