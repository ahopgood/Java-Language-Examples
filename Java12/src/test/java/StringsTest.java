import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandles;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class StringsTest {

    @Test
    void testIndent() {
        String myString = "I'm a test string ma!";
        assertThat(myString.indent(4)).isEqualTo("    I'm a test string ma!\n");
        assertThat(myString).isEqualTo("I'm a test string ma!");

        String indentedString = " \tI'm indented ma";
        assertThat(indentedString.indent(-4)).isEqualTo("I'm indented ma\n");
        assertThat(indentedString).isEqualTo(" \tI'm indented ma");
    }

    @Test
    void testDescribeConstable() {
        String myString = "I'm a test string ma!";
        Optional<String> stringOpt = myString.describeConstable();
        assertThat(stringOpt.get()).isEqualTo(myString);
    }

    @Test
    void testResolveConstantDesc() {
        String myString = "I'm a test string ma!";
        assertThat(myString.resolveConstantDesc(MethodHandles.lookup())).isEqualTo(myString);
    }

    @Test
    void testTransform() {
        String myString = "alex";
        Name myName = myString.transform(s -> new Name(s));
        assertThat(myName.getFirstName()).isEqualTo(myString);
    }

    class Name {
        private String firstName;

        public Name(String firstName) {
            this.firstName = firstName;
        }

        public String getFirstName() {
            return this.firstName;
        }
    }
}
