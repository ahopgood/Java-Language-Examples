package com.alexander.java.examples.java7;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CharsTest {

    @Test
    public void testUnicode6(){
        char start = '\u0000';
        System.out.println("["+start+"]");
        char end = '\uFFFF';
        System.out.println("["+end+"]");

        int emojiCodePoint = 0x1F601;

        System.out.println(Character.getName(emojiCodePoint));
        System.out.println(Character.charCount(emojiCodePoint));
        System.out.println(""+Character.toChars(emojiCodePoint)[0] + Character.toChars(emojiCodePoint)[1]);

        String description = "GRINNING FACE WITH SMILING EYES";
        assertEquals(description, Character.getName(emojiCodePoint));
        //Contains both a
        assertEquals(2, Character.charCount(emojiCodePoint));

        assertEquals("😁", new String(new char[]{Character.toChars(emojiCodePoint)[0], Character.toChars(emojiCodePoint)[1]}));
    }
}
