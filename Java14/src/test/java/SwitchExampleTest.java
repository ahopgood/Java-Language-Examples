import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SwitchExampleTest {

    private SwitchExample example = new SwitchExample();

    @Test
    void testOld_default() {
        assertThrows(IllegalArgumentException.class,
                () -> example.oldIsWeekend("Funday"));
    }

    @Test
    void testNew_default() {
        assertThrows(IllegalArgumentException.class,
                () -> example.newIsWeekend("Funday"));
    }

    @Test
    void testOld_monday() {
        assertFalse(example.oldIsWeekend("monday"));
    }

    @Test
    void testNew_monday() {
        assertFalse(example.newIsWeekend("monday"));
    }

    @Test
    void testOld_tuesday() {
        assertFalse(example.oldIsWeekend("tuesday"));
    }

    @Test
    void testNew_tuesday() {
        assertFalse(example.newIsWeekend("tuesday"));
    }

    @Test
    void testOld_wednesday() {
        assertFalse(example.oldIsWeekend("wednesday"));
    }

    @Test
    void testNew_wednesday() {
        assertFalse(example.newIsWeekend("wednesday"));
    }

    @Test
    void testOld_thursday() {
        assertFalse(example.oldIsWeekend("thursday"));
    }

    @Test
    void testNew_thursday() {
        assertFalse(example.newIsWeekend("thursday"));
    }

    @Test
    void testOld_friday() {
        assertFalse(example.oldIsWeekend("friday"));
    }

    @Test
    void testNew_friday() {
        assertFalse(example.newIsWeekend("friday"));
    }

    @Test
    void testOld_saturday() {
        assertTrue(example.oldIsWeekend("saturday"));
    }

    @Test
    void testNew_saturday() {
        assertTrue(example.newIsWeekend("saturday"));
    }

    @Test
    void testOld_sunday() {
        assertTrue(example.oldIsWeekend("sunday"));
    }

    @Test
    void testNew_sunday() {
        assertTrue(example.newIsWeekend("sunday"));
    }

    @MethodSource("weekdays")
    @ParameterizedTest
    void testCondensed_weekday(String day) {
        assertFalse(example.condensedIsWeekend(day));
    }

    @MethodSource("weekends")
    @ParameterizedTest
    void testCondensed_weekends(String day) {
        assertTrue(example.condensedIsWeekend(day));
    }

    @MethodSource("invalid")
    @ParameterizedTest
    void testCondensed_invalidDays(String day) {
        assertThrows(IllegalArgumentException.class,
                () -> example.oldIsWeekend(day));
    }

    private static Stream<String> invalid() {
        return Stream.of("funday",
                "Funday");
    }

    private static Stream<String> weekends() {
        return Stream.of("saturday",
                "Saturday",
                "sunday",
                "Sunday");
    }

    private static Stream<String> weekdays() {
        return Stream.of("monday",
                "Monday",
                "Tuesday",
                "tuesday",
                "Wednesday",
                "wednesday",
                "Thursday",
                "thursday",
                "friday",
                "Friday"
        );
    }
}