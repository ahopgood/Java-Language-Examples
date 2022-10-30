import org.junit.jupiter.api.Test;
import record.Point;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordTest {

    private static final int X = 1;
    private static final int Y = 2;

    @Test
    void testPointClassVsPointRecord() {
        Point point = new Point(X, Y);
        Point recordPoint = new Point(X,Y);

        assertThat(point.x()).isEqualTo(recordPoint.x());
        assertThat(point.y()).isEqualTo(recordPoint.y());
        assertThat(point).isEqualTo(recordPoint);
        assertThat(point.hashCode()).isEqualTo(recordPoint.hashCode());
        assertThat(recordPoint.toString()).contains(point.toString());
    }
}
