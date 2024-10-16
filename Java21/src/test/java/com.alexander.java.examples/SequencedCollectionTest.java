package com.alexander.java.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SequencedCollectionTest {

    private List<Integer> numbers;

    @BeforeEach
    void before() {
        numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
    }

    @Test
    void getFirst() {
        assertThat(numbers.getFirst()).isEqualTo(1);
    }

    @Test
    void getLast() {
        assertThat(numbers.getLast()).isEqualTo(5);
    }

    @Test
    void addFirst() {
        numbers.addFirst(0);
        assertThat(numbers).containsExactly(0,1,2,3,4,5);
    }

    @Test
    void addLast() {
        numbers.addLast(6);
        assertThat(numbers).containsExactly(1,2,3,4,5,6);
    }

    @Test
    void removeFirst() {
        assertThat(numbers.removeFirst()).isEqualTo(1);
        assertThat(numbers).containsExactly(2,3,4,5);
    }

    @Test
    void removeLast() {
        assertThat(numbers.removeLast()).isEqualTo(5);
        assertThat(numbers).containsExactly(1,2,3,4);
    }

    @Test
    void reorder() {
        assertThat(numbers).containsExactly(1,2,3,4,5);
        assertThat(numbers.reversed()).containsExactly(5,4,3,2,1);
        assertThat(numbers).containsExactly(1,2,3,4,5);

    }
}
