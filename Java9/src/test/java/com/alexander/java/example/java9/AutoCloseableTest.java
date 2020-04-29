package com.alexander.java.example.java9;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoCloseableTest {

    @Test
    void testAutoCloseable_givenFinalResource_new() throws IOException {
        // A final resource
        final StringReader resource1 = new StringReader("resource1");
        // An effectively final resource
        StringReader resource2 = new StringReader("resource2");
        // New and improved try-with-resources statement in Java SE 9
        try (resource1; resource2) {
            assertThat(resource1.ready()).isTrue();
            assertThat(resource2.ready()).isTrue();
        }
    }

    @Test
    void testAutoCloseable_givenFinalResource_old() throws IOException {
        // A final resource
        final StringReader resource1 = new StringReader("resource1");
        // An effectively final resource
        StringReader resource2 = new StringReader("resource2");
        // Previously we'd need to do this:
        try (StringReader r1 = resource1;
             StringReader r2 = resource2) {
            assertThat(r1.ready()).isTrue();
            assertThat(r2.ready()).isTrue();
        }
    }

    @Test
    void testAutoCloseable_givenMutableResource() throws IOException {
        try (StringReader resource1 = new StringReader("resource1");
             StringReader resource2 = new StringReader("resource2")) {
            assertThat(resource1.ready()).isTrue();
            assertThat(resource2.ready()).isTrue();
        }
    }

}
