import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TypeInferenceTest {

    @Test
    void testLocalVariableInference() {
        var numbers = List.of(1, 2, 3, 4, 5);
        assertThat(numbers.size()).isEqualTo(5);
    }

    @Test
    void testEnhancedForLoopVariableInference() {
        var numbers = List.of(1, 2, 3, 4, 5);
        for (var number : numbers) {
            System.out.println(number);
        }
    }

    @Test
    void testIndexVariableInference() {
        var numbers = List.of(1, 2, 3, 4, 5);
        for (var i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }

}
