package com.alexander.java.examples;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomDateTimeFormatterTest {
    @Test
    void testFormatter() {

        var formatter = DateTimeFormatter.ofLocalizedPattern("yMMM");
        assertThat(formatter.format(LocalDateTime.of(2023, 3, 14, 0, 0))).isEqualTo("Mar 2023");
    }
}
