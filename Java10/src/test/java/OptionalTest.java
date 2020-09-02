import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OptionalTest {

    @Test
    void testOrElseThrows() {
        assertThrows(NoSuchElementException.class, () -> Optional.ofNullable(null).orElseThrow());

        Integer optionalContents = Optional.ofNullable(5).orElseThrow();
        assertThat(optionalContents).isEqualTo(5);
    }
}
