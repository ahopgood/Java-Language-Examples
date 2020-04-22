package com.alexander.java.example.java9;


import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalTest {

    @Test
    public void testIfPresentOrElse_whenEmpty() {
        final List<Integer> ints = new LinkedList<>();
        Optional<Integer> empty = Optional.empty();
        empty.ifPresentOrElse(
                (s) -> ints.add(s),
                () -> System.out.println("Value in optional was not present")
        );

        assertThat(ints.isEmpty());
    }

    @Test
    public void testIfPresentOrElse_whenNull() {
        final List<Integer> ints = new LinkedList<>();
        Optional<Integer> nullOpt = Optional.ofNullable(null);
        nullOpt.ifPresentOrElse(
                (s) -> ints.add(s),
                () -> System.out.println("Value in optional was not present")
        );

        assertThat(ints.isEmpty());
    }

    @Test
    public void testIfPresentOrElse_whenPresent() {
        final List<Integer> ints = new LinkedList<>();
        Optional.ofNullable(Integer.valueOf(1)).ifPresentOrElse(
                (s) -> ints.add(s),
                () -> System.out.println("Value in optional was not present")
        );

        assertThat(ints.size()).isEqualTo(1);
    }

    @Test
    public void testStream() {
        assertThat(Optional.ofNullable(Integer.valueOf(1))
                .stream()
                .count()).isEqualTo(1L);
    }

    @Test
    public void testStream_givenNullOptional() {
        assertThat(Optional.ofNullable(null)
                .stream()
                .count()).isEqualTo(0L);
    }

    @Test
    public void testOr() {
        Optional<Integer> number = Optional.ofNullable(Integer.valueOf(1))
                .or(() -> Optional.of(Integer.valueOf(2)));
        assertThat(number.get()).isEqualTo(1);
    }

    @Test
    public void testOr_givenNull() {
        Optional number = Optional.ofNullable(null)
                .or(() -> Optional.of(Integer.valueOf(2)));
        assertThat(number.get()).isEqualTo(2);
    }
}
