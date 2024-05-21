package com.alexander.java.examples;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DefaultCharsetTest {

    @Test
    void testDefaultCharset() {
        assertThat(Charset.defaultCharset()).isEqualTo(Charset.forName("UTF-8"));
    }
}