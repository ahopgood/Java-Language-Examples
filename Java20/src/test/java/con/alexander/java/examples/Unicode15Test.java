package con.alexander.java.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Unicode15Test {

    @MethodSource("emojiCodes")
    @ParameterizedTest
    public void testUnicode(int emojiCodePoint, String description) throws UnsupportedEncodingException {

        System.out.println(Character.getName(emojiCodePoint));
        System.out.println(Character.charCount(emojiCodePoint));

        String unicodeString = "" + Character.toChars(emojiCodePoint)[0] + Character.toChars(emojiCodePoint)[1];
        System.out.println(unicodeString);

        assertEquals(description, Character.getName(emojiCodePoint));
        // Multi Character emoji
        assertEquals(2, Character.charCount(emojiCodePoint));


        PrintStream out = new PrintStream(System.out, true, "UTF-16");
        out.println(unicodeString);
    }
    private static Stream<Arguments> emojiCodes() {
        return Stream.of(
            Arguments.of(0x1FAE0, "MELTING FACE"),
            Arguments.of(0x1FAE8, "SHAKING FACE"),
            Arguments.of(0x1FA77, "PINK HEART"),
            Arguments.of(0x1FA75, "LIGHT BLUE HEART"),
            Arguments.of(0x1FA76	, "GREY HEART"),
            Arguments.of(0X1FAF7	, "LEFTWARDS PUSHING HAND"),
            Arguments.of(0X1FAF8	, "RIGHTWARDS PUSHING HAND")
//            Arguments.of(0x1FAF7+0x1F3FB, "LEFTWARDS PUSHING HAND: LIGHT SKIN TONE"),
//            Arguments.of(0x1FAF8+0x1F3FB, "RIGHTWARDS PUSHING HAND: LIGHT SKIN TONE")
        );
    }
}
