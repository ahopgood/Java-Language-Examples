import org.junit.jupiter.api.Test;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class PseudoRandomTest {

    @Test
    void test() {
        RandomGeneratorFactory<RandomGenerator> generatorFactory = RandomGeneratorFactory.of("L32X64MixRandom");
        RandomGenerator generator = generatorFactory.create();
        System.out.println(generator.nextInt());
    }
}
