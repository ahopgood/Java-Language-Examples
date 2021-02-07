import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    @Test
    void testIsBlank_whenStringNotEmpty() {
        String s = "test";
        assertThat(s.isBlank()).isFalse();
    }

    @Test
    void testIsBlank_whenContainsSpaces() {
        String s = "      ";
        assertThat(s.isBlank()).isTrue();
    }

    @Test
    void testIsBlank_whenContainsNewline() {
        String s = "\n\n\n\n";
        assertThat(s.isBlank()).isTrue();
    }

    @Test
    void testIsBlank_whenContainsCarriageReturn() {
        String s = "\r\r\r\r";
        assertThat(s.isBlank()).isTrue();
    }

    @Test
    void testIsBlank_whenContainsTabs() {
        String s = "\t\t\t\t\t";
        assertThat(s.isBlank()).isTrue();
    }

    @Test
    void testIsBlank_whenIsEmpty() {
        String s = "";
        assertThat(s.isBlank()).isTrue();
    }

    @Test
    void testIsBlank_whenIsNull() {
        String s = null;
        assertThrows(NullPointerException.class, () -> s.isBlank());
    }

    @Test
    void testLines_whenSingleLine() {
        String s = "tada!";
        assertThat(s.lines().count()).isEqualTo(1);
    }

    @Test
    void testLines_whenMultipleNewlines() {
        String s = "Uoompah\nUoompah\ntada!";
        assertThat(s.lines().count()).isEqualTo(3);
    }

    @Test
    void testLines_whenMultipleCarriageReturns() {
        String s = "Uoompah\rUoompah\rtada!";
        assertThat(s.lines().count()).isEqualTo(3);
    }

    @Test
    void testLines_whenMultipleTabsReturns() {
        String s = "Uoompah\tUoompah\ttada!";
        assertThat(s.lines().count()).isEqualTo(1);
    }

    @Test
    void testStripLeading_whenStringStartsWithTabs() {
        String s = "\ttest";
        String expected = "test";
        assertThat(s.stripLeading()).isEqualTo(expected);
    }

    @Test
    void testStripLeading_whenStringStartsWithNewlines() {
        String s = "\n\ntest";
        String expected = "test";
        assertThat(s.stripLeading()).isEqualTo(expected);
    }

    @Test
    void testStripLeading_whenStringStartsWithCarriageReturns() {
        String s = "\r\rtest";
        String expected = "test";
        assertThat(s.stripLeading()).isEqualTo(expected);
    }

    @Test
    void testStripLeading_whenStringStartsWithSpaces() {
        String s = "    test";
        String expected = "test";
        assertThat(s.stripLeading()).isEqualTo(expected);
    }

    @Test
    void testStripLeading_whenStringEndsWithWhitespace() {
        String s = "test\t\r\n ";
        String expected = "test\t\r\n ";
        assertThat(s.stripLeading()).isEqualTo(expected);
    }

    @Test
    void testStripTrailing_whenStringEndsWithTabs() {
        String s = "test\t";
        String expected = "test";
        assertThat(s.stripTrailing()).isEqualTo(expected);
    }

    @Test
    void testStripTrailing_whenStringEndsWithNewlines() {
        String s = "test\n\n";
        String expected = "test";
        assertThat(s.stripTrailing()).isEqualTo(expected);
    }

    @Test
    void testStripTrailing_whenStringEndsWithCarriageReturns() {
        String s = "test\r\r";
        String expected = "test";
        assertThat(s.stripTrailing()).isEqualTo(expected);
    }

    @Test
    void testStripTrailing_whenStringEndsWithSpaces() {
        String s = "test    ";
        String expected = "test";
        assertThat(s.stripTrailing()).isEqualTo(expected);
    }

    @Test
    void testStripTrailing_whenStringStartsWithWhitespace() {
        String s = "\t\r\n test";
        String expected = "\t\r\n test";
        assertThat(s.stripTrailing()).isEqualTo(expected);
    }

    @Test
    void testStrip_whenStringStartsAndEndsWithTabs() {
        String s = "\ttest\t";
        String expected = "test";
        assertThat(s.strip()).isEqualTo(expected);
    }

    @Test
    void testStrip_whenStringEndsWithNewlines() {
        String s = "\n\ntest\n\n";
        String expected = "test";
        assertThat(s.strip()).isEqualTo(expected);
    }

    @Test
    void testStrip_whenStringStartsAndEndsWithCarriageReturns() {
        String s = "\r\rtest\r\r";
        String expected = "test";
        assertThat(s.strip()).isEqualTo(expected);
    }

    @Test
    void testStrip_whenStringStartsAndEndsWithSpaces() {
        String s = "    test    ";
        String expected = "test";
        assertThat(s.strip()).isEqualTo(expected);
    }

    @Test
    void testStrip_whenStringStartsAndEndsWithWhitespace() {
        String s = "\t\r\n test \n\r\t";
        String expected = "test";
        assertThat(s.strip()).isEqualTo(expected);
    }

    @Test
    void testStrip_whenStringContainsWhitespaceInMiddle() {
        String s = "\t\r\n test \n\r\ttest \n\r\t";
        String expected = "test \n\r\ttest";
        assertThat(s.strip()).isEqualTo(expected);
    }

    @Test
    void testRepeat() {
        String s = "x";
        assertThat(s.repeat(3)).isEqualTo("xxx");
    }

    @Test
    void testRepeat_negative() {
        String s = "x";
        assertThrows(IllegalArgumentException.class, () -> s.repeat(-3));
    }

    @Test
    void testRepeat_single() {
        String s = "x";
        assertThat(s.repeat(1)).isEqualTo("x");
    }

    @Test
    void testRepeat_emptyString() {
        String s = "";
        assertThat(s.repeat(4)).isEqualTo("");
    }

    @Test
    void testRepeat_intMax() {
        String s = "xxx";
        assertThrows(OutOfMemoryError.class, () -> s.repeat(Integer.MAX_VALUE), "Repeating 3 bytes String 2147483647 times will produce a String exceeding maximum size.");
    }
}
