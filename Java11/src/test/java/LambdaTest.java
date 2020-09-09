import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {

    @Test
    void testLocalVariable () {
        List<Integer> list = List.of(1, 2, 3, 4);
        List<Integer> refinedList = list.stream()
                .filter(i -> i % 2 == 0)
                .collect(toList());
        assertThat(refinedList.size()).isEqualTo(2);
    }

    @Test
    void testLocalVariabeSyntax_withAnnotation() {
        List<Integer> list = List.of(1, 2, 3, 4);
        List<Integer> refinedList = list.stream()
                .filter((var i) -> i % 2 == 0)
                .collect(toList());
        assertThat(refinedList.size()).isEqualTo(2);
    }
}