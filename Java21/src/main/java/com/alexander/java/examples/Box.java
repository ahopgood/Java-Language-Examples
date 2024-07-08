package com.alexander.java.examples;

/**
 * Generic record that wraps a type in a box
 * @param t
 * @param <T>
 */
public record Box<T>(T t) {
}
