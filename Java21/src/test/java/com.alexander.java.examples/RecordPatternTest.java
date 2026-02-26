package com.alexander.java.examples;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class RecordPatternTest {

    @Test
    void testInstanceof_true() {
        Point point = new Point(0,1);
        assertThat(point instanceof Point).isTrue();
    }

    @Test
    void testInstanceof_false() {
        Object notAPoint = Integer.valueOf(1);
        assertThat(notAPoint instanceof Point).isFalse();
    }

    @Test
    void testInstanceofWithRecordPattern_true() {
        Point point = new Point(0,1);
        if (point instanceof Point(int x, int y)) {
            var sum = x + y;
            assertThat(sum).isEqualTo(1);
        } else {
            fail("Wrong pattern");
        }
    }

    @Test
    void testInstanceofWithCustomConstructorRecordPattern_true() {
        Point point = new Point(1);

        if (point instanceof Point(int x, int y)) {
            var sum = x + y;
            assertThat(sum).isEqualTo(1);
        } else {
            fail("Wrong pattern");
        }
    }

    @Test
    void testInstanceofWithTypePattern_true() {
        Point point = new Point(0,1);
        if (point instanceof Point p) {
            var sum = p.x() + p.y();
            assertThat(sum).isEqualTo(1);
        } else {
            fail("Wrong pattern");
        }
    }

    @Test
    void testInstanceofWithTypeInference_true() {
        Point point = new Point(0,1);
        if (point instanceof Point(var x, var y)) {
            var sum = x + y;
            assertThat(sum).isEqualTo(1);
        } else {
            fail("Wrong pattern");
        }
    }

    @Test
    void testInstanceofWithPattern_false() {
        Object point = Integer.valueOf(1);
        if (point instanceof Point(int x, int y)) {
            fail("Pattern shouldn't match");
        }
    }

    @Test
    void testInstanceofWithNestedRecord_true() {
        Rectangle rectangle = new Rectangle(new Point(0,1), new Point (1, 0));
        if (rectangle instanceof Rectangle(Point(var x, var y), var bottomRight)) {
            var sum = x + y;
            assertThat(sum).isEqualTo(1);
            var inferredSum = bottomRight.x() + bottomRight.y();
            assertThat(inferredSum).isEqualTo(1);
        } else {
            fail("Wrong pattern");
        }
    }

    @Test
    void testInstanceofWithGeneric_true() {
        Box<String> box = new Box("String");
        if (box instanceof Box<String>(String s)) {
            assertThat(s).isEqualTo("String");
        } else {
            fail("Pattern should match");
        }
    }

    @Test
    void testInstanceofWithGenericAndTypeInference_true() {
        Box<String> box = new Box("String");
        if (box instanceof Box(String s)) {
            assertThat(s).isEqualTo("String");
        } else {
            fail("Pattern should match");
        }
    }

    @Test
    void testInstanceofWithNestedGeneric_true() {
        Box<Box<String>> box = new Box(new Box("String"));
        if (box instanceof Box(Box(var s))) {
            assertThat(s).isEqualTo("String");
        } else {
            fail("Pattern should match");
        }
    }
}
