import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.InstantSource;

public class TimeTest {

    @Test
    void testInstant() {
        System.out.println(InstantSource.system().instant());
    }

    @Test
    void testClock() {
        Clock now = Clock.systemUTC();
        System.out.println("Clock:" + now.toString());
        System.out.println("Instant:" + now.instant());
        System.out.println("Timezone:" + now.getZone());
    }
}
