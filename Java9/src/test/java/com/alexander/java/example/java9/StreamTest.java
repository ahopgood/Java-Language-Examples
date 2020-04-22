package com.alexander.java.example.java9;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {

    @Test
    void testTakeWhile_conditionMetAtStart() {
        assertThat(Stream.of(5, 1, 2, 3, 4, 5, 6)
                .takeWhile(i -> (i / 4) == 1)
                .collect(Collectors.toList()))
                .containsExactly(5);
    }

    @Test
    void testTakeWhile_conditionFailsImmediately() {
        assertThat(Stream.of(1, 2, 3, 4, 5, 6)
                .takeWhile(i -> (i / 4) == 1)
                .collect(Collectors.toList()))
                .containsExactly();
    }

    @Test
    void testTakeWhile_conditionMetImmediately() {
        assertThat(Stream.of(6,5,4,3,2,1)
                .takeWhile(i -> (i / 4) == 1)
                .collect(Collectors.toList()))
                .containsExactly(6,5,4);
    }

    @Test
    void testDropWhile_conditionFailsImmediately() {
        assertThat(Stream.of(1, 2, 3, 4, 5, 6)
                .dropWhile(i -> (i / 4) == 1)
                .collect(Collectors.toList()))
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void testDropWhile_conditionMetOnce() {
        assertThat(Stream.of(6, 1, 2, 3, 4, 5, 6)
                .dropWhile(i -> (i / 4) == 1)
                .collect(Collectors.toList()))
                .containsExactly(1, 2, 3, 4, 5, 6);
    }
    @Test
    void testDropWhile_conditionMetImmediately() {
        assertThat(Stream.of(6,5,4,3,2,1)
                .dropWhile(i -> (i / 4) == 1 )
                .collect(Collectors.toList()))
                .containsExactly(3,2,1);
    }

    @Test
    void testOfNullable_nullObject() {
        assertThat(Stream.ofNullable(null).count()).isEqualTo(0);
    }

    @Test
    void testOfNullable_Object() {
        assertThat(Stream.ofNullable(7).count()).isEqualTo(1);
    }
}
