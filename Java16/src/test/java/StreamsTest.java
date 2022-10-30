import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamsTest {

    private Stream stream = Stream.of(1, 2, 3, 4);
    private static final List list = List.of(1, 2, 3, 4);

    @Test
    void testCollectorsToList() {
        assertThat(stream.collect(Collectors.toList())).isEqualTo(list);
    }

    @Test
    void testToList() {
        assertThat(stream.toList()).isEqualTo(list);
    }
}
