package com.alexander.java.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SwitchPatternTest {

    @ParameterizedTest(name = "Pattern Matching Switch with {1}")
    @MethodSource("objects")
    void switchWithObject(Object parameter, Class clazz) {
        assertThat(Switch.FormatterPatternSwitch(parameter))
            .isEqualTo(Switch.Formatter(parameter));
    }

    @Test
    void switchWithUnknown() {
        assertThat(Switch.FormatterPatternSwitch(BigDecimal.ONE)).isEqualTo("1");
        assertThat(Switch.Formatter(BigDecimal.ONE)).isEqualTo("unknown");
    }

    private static Stream<Arguments> objects() {
        return Stream.of(
            Arguments.of(Integer.valueOf(1), Integer.class),
            Arguments.of(Long.valueOf(2), Long.class),
            Arguments.of(String.valueOf("test"), String.class),
            Arguments.of(Double.valueOf(3), Double.class)
        );
    }
}
