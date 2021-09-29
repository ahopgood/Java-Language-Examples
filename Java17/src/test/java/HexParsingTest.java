import org.junit.jupiter.api.Test;

import java.util.HexFormat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HexParsingTest {

    private final String HEX_42 = "2A";
    private final char HEX_15 = 'F';

    @Test
    void testHexFormat_fromHexDigits() {
        assertThat(HexFormat.fromHexDigits(HEX_42)).isEqualTo(42);
    }

    @Test
    void testHexFormat_isHexDigit_fromCodePoints() {
        assertTrue(HexFormat.isHexDigit('0'));
        assertTrue(HexFormat.isHexDigit('1'));
        assertTrue(HexFormat.isHexDigit('2'));
        assertTrue(HexFormat.isHexDigit('3'));
        assertTrue(HexFormat.isHexDigit('4'));
        assertTrue(HexFormat.isHexDigit('5'));
        assertTrue(HexFormat.isHexDigit('6'));
        assertTrue(HexFormat.isHexDigit('7'));
        assertTrue(HexFormat.isHexDigit('8'));
        assertTrue(HexFormat.isHexDigit('9'));
        assertTrue(HexFormat.isHexDigit('A'));
        assertTrue(HexFormat.isHexDigit('B'));
        assertTrue(HexFormat.isHexDigit('C'));
        assertTrue(HexFormat.isHexDigit('D'));
        assertTrue(HexFormat.isHexDigit('E'));
        assertTrue(HexFormat.isHexDigit('F'));
        assertTrue(HexFormat.isHexDigit('a'));
        assertTrue(HexFormat.isHexDigit('b'));
        assertTrue(HexFormat.isHexDigit('c'));
        assertTrue(HexFormat.isHexDigit('d'));
        assertTrue(HexFormat.isHexDigit('e'));
        assertTrue(HexFormat.isHexDigit('f'));
    }

    @Test
    void testHexFormat_fromHexDigit_fromCodePoints() {
        assertThat(HexFormat.fromHexDigit(HEX_15)).isEqualTo(15);
    }

    @Test
    void testHexFormat_fromHexDigitsToLong_fromCodePoints() {
        assertThat(HexFormat.fromHexDigitsToLong(HEX_42)).isEqualTo(42L);
    }
}
