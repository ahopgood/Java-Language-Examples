package com.alexander.java.examples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class EmojiTest {

    @Test
    public void testUnicode14() throws UnsupportedEncodingException {
        int emojiCodePoint = 0x1FAE0;

        System.out.println(Character.getName(emojiCodePoint));
        System.out.println(Character.charCount(emojiCodePoint));

        String unicodeString = "" + Character.toChars(emojiCodePoint)[0] + Character.toChars(emojiCodePoint)[1];
        System.out.println(unicodeString);


        String description = "MELTING FACE";
        assertEquals(description, Character.getName(emojiCodePoint));
        // Multi Character emoji
        assertEquals(2, Character.charCount(emojiCodePoint));

        PrintStream out = new PrintStream(System.out, true, "UTF-16");
        out.println(unicodeString);
    }
}