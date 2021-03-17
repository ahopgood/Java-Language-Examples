import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest {

    private final int number = 2021;

    @Test
    void compactNumberFormatting_short() {
        NumberFormat shortFormat = NumberFormat.getCompactNumberInstance(Locale.UK, NumberFormat.Style.SHORT);
        shortFormat.setMaximumFractionDigits(2);
        System.out.println(shortFormat.format(number));
    }

    @Test
    void compactNumberFormatting_long() {
        NumberFormat longFormat = NumberFormat.getCompactNumberInstance(Locale.UK, NumberFormat.Style.LONG);
        longFormat.setMaximumFractionDigits(2);
        System.out.println(longFormat.format(number));
    }
}
