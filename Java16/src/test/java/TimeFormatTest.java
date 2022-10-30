import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TimeFormatTest {

    @Test
    void testMorning() {
        String output = DateTimeFormatter.ofPattern("B").format(LocalTime.of(06,00,00));
        assertThat(output).isEqualTo("in the morning");
    }

    @Test
    void testNoon() {
        String output = DateTimeFormatter.ofPattern("B").format(LocalTime.of(12,00,00));
        assertThat(output).isEqualTo("noon");
    }

    @Test
    void testAfternoon() {
        String output = DateTimeFormatter.ofPattern("B").format(LocalTime.of(12,01,00));
        assertThat(output).isEqualTo("in the afternoon");
    }

    @Test
    void testEvening() {
        String output = DateTimeFormatter.ofPattern("B").format(LocalTime.of(18,00,00));
        assertThat(output).isEqualTo("in the evening");
    }

    @Test
    void testNight() {
        String output = DateTimeFormatter.ofPattern("B").format(LocalTime.of(21,00,00));
        assertThat(output).isEqualTo("at night");
    }
}
