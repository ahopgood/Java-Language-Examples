package pattern;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InstanceOfTest {

    private static final int X = 1;
    private static final int Y = 2;

    @Test
    void testOldEquals_differentClass() {
        OldEquals oldEquals = new OldEquals(X, Y);

        String s = "";
        assertThat(oldEquals.equals(s)).isFalse();
    }

    @Test
    void testOldEquals_differentX() {
        OldEquals oldEquals = new OldEquals(X, Y);
        OldEquals otherEquals = new OldEquals(3, Y);

        assertThat(oldEquals.equals(otherEquals)).isFalse();
    }

    @Test
    void testOldEquals_differentY() {
        OldEquals oldEquals = new OldEquals(X, Y);
        OldEquals otherEquals = new OldEquals(X, 3);

        assertThat(oldEquals.equals(otherEquals)).isFalse();
    }


    @Test
    void testOldEquals_sameFields() {
        OldEquals oldEquals = new OldEquals(X, Y);
        OldEquals otherEquals = new OldEquals(X, Y);

        assertThat(oldEquals.equals(otherEquals)).isTrue();
    }

    @Test
    void testNewEquals_differentClass() {
        NewEquals newEquals = new NewEquals(X, Y);

        String s = "";
        assertThat(newEquals.equals(s)).isFalse();
    }

    @Test
    void testNewEquals_differentX() {
        NewEquals newEquals = new NewEquals(X, Y);
        NewEquals otherEquals = new NewEquals(3, Y);

        assertThat(newEquals.equals(otherEquals)).isFalse();
    }

    @Test
    void testNewEquals_differentY() {
        NewEquals newEquals = new NewEquals(X, Y);
        NewEquals otherEquals = new NewEquals(X, 3);

        assertThat(newEquals.equals(otherEquals)).isFalse();
    }


    @Test
    void testNewEquals_sameFields() {
        NewEquals newEquals = new NewEquals(X, Y);
        NewEquals otherEquals = new NewEquals(X, Y);

        assertThat(newEquals.equals(otherEquals)).isTrue();
    }
}