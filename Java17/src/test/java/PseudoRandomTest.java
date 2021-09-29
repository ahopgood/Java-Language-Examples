import org.junit.jupiter.api.Test;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class PseudoRandomTest {

    @Test
    void test_LXM_random() {
        RandomGeneratorFactory<RandomGenerator> generatorFactory = RandomGeneratorFactory.of("L32X64MixRandom");
        RandomGenerator generator = generatorFactory.create();
        System.out.println(generator.nextInt());
    }

    @Test
    void testLegacy_SecureRandom() {
        RandomGeneratorFactory<RandomGenerator> generatorFactory = RandomGeneratorFactory.of("SecureRandom");
        RandomGenerator generator = generatorFactory.create();
        System.out.println(generator.nextInt());
    }
}
