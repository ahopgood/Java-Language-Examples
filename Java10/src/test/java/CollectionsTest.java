import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CollectionsTest {

    @Test
    void testListCopyOf() {
        List numbers = List.of(1, 2, 3, 4, 5);
        List unmodifiableNumbers = List.copyOf(numbers);

        assertThat(unmodifiableNumbers.size()).isEqualTo(5);
        assertThrows(UnsupportedOperationException.class, () -> unmodifiableNumbers.add(6));

        numbers.add(6);
        assertThat(numbers.size()).isEqualTo(6);
        assertThat(unmodifiableNumbers.size()).isEqualTo(5);
    }

    @Test
    void testMapCopyOf() {
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("One", 1);
        numbers.put("Two", 2);
        numbers.put("Three", 3);
        numbers.put( "Four", 4);
        numbers.put("Five", 5);

        Map unmodifiableNumbers = Map.copyOf(numbers);
        assertThat(unmodifiableNumbers.size()).isEqualTo(5);
        assertThrows(UnsupportedOperationException.class, () -> unmodifiableNumbers.put("Six", 6));

        numbers.put("Six", 6);
        assertThat(numbers.size()).isEqualTo(6);
        assertThat(unmodifiableNumbers.size()).isEqualTo(5);
    }

    @Test
    void testSetCopyOf() {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Set unmodifiableNumbers = Set.copyOf(numbers);
        assertThat(unmodifiableNumbers.size()).isEqualTo(5);
        assertThrows(UnsupportedOperationException.class, () -> unmodifiableNumbers.add(6));

        numbers.add(6);
        assertThat(numbers.size()).isEqualTo(6);
        assertThat(unmodifiableNumbers.size()).isEqualTo(5);
    }
}
