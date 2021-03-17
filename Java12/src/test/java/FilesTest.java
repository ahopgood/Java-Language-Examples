import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class FilesTest {

    @Test
    void testMismatch_sameContent() throws IOException {
        Path file1 = Files.createTempFile("file1", ".txt");
        Path file2 = Files.createTempFile("file2", ".txt");
        Files.writeString(file1, "We're the same");
        Files.writeString(file2, "We're the same");
        assertThat(Files.mismatch(file1, file2)).isEqualTo(-1L);

        file1.toFile().deleteOnExit();
        file2.toFile().deleteOnExit();
    }

    @Test
    void testMismatch_differentContent() throws IOException {
        Path file1 = Files.createTempFile("file1", ".txt");
        Path file2 = Files.createTempFile("file2", ".txt");
        Files.writeString(file1, "We're different");
        Files.writeString(file2, "We're the same");
        assertThat(Files.mismatch(file1, file2)).isEqualTo(6L);

        file1.toFile().deleteOnExit();
        file2.toFile().deleteOnExit();
    }

    @Test
    void testMismatch_differentContentSameBytes() throws IOException {
        Path file1 = Files.createTempFile("file1", ".txt");
        Path file2 = Files.createTempFile("file2", ".txt");
        Files.writeString(file1, "We're the same but I have more in me");
        Files.writeString(file2, "We're the same");
        assertThat(Files.mismatch(file1, file2)).isEqualTo(14L);

        file1.toFile().deleteOnExit();
        file2.toFile().deleteOnExit();
    }
}
