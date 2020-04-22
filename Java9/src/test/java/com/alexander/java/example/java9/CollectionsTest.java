package com.alexander.java.example.java9;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CollectionsTest {

    @Test()
    void testListOf() {
        List<Integer> integerList = List.of(1, 2, 3, 4);
        assertThat(integerList.size()).isEqualTo(4);
        assertThat(integerList).containsOnly(1, 2, 3, 4);

        //Assert that list is immutable
        assertThrows(UnsupportedOperationException.class, () -> integerList.add(5));
    }

    @Test
    void testMapOf() {
        Map<Integer, String> integerStringMap = Map.of(1, "one", 2, "two");
        assertThat(integerStringMap.size()).isEqualTo(2);
        assertThat(integerStringMap).containsOnly(Map.entry(1, "one"), Map.entry(2, "two"));

        //Assert that list is immutable
        assertThrows(UnsupportedOperationException.class, () -> integerStringMap.put(3, "three"));
    }

    @Test
    void testSetOf() {
        Set<Integer> integerStringMap = Set.of(1, 2, 3, 4);
        assertThat(integerStringMap.size()).isEqualTo(4);
        assertThat(integerStringMap).containsOnly(1, 2, 3, 4);

        //Assert that list is immutable
        assertThrows(UnsupportedOperationException.class, () -> integerStringMap.add(5));
    }
}
