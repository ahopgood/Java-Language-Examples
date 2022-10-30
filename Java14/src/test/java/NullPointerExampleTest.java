import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NullPointerExampleTest {

    @Test
    void testExample() {
        //Requires the following JVM Parameter: -XX:+ShowCodeDetailsInExceptionMessages
        NullPointerExample example = new NullPointerExample();

        Throwable exception = assertThrows(NullPointerException.class, () -> example.example());
        assertThat(exception.getMessage()).contains("Cannot invoke \"String.substring(int)\" because \"test\" is null");
    }
}