import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

public class CharsetTest {

    @Test
    void testNativeEncodingProperty() {
        System.out.println(System.getProperty("native.encoding"));
    }

    @Test
    void getDefaultCharset() {
        System.out.println(Charset.defaultCharset());
    }

    @Test
    void getConsoleCharset() {
        System.out.println("Console test");
        if (System.console() != null) {
            System.out.println(System.console().charset());
        }
    }
}
