import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NestedTest {

    @Test
    void testNestedAccess() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Parent parent = new Parent();
        parent.myPublic();

        Method method = parent.getClass().getDeclaredMethod("myPrivate");
        Throwable exception = assertThrows(IllegalAccessException.class, () -> method.invoke(parent));
        assertThat(exception.getMessage()).contains("cannot access a member of class " + Parent.class.getName() + " with modifiers \"private\"");
    }

    @Test
    void testNestNost() {
        assertThat(Parent.class.getNestHost()).isEqualTo(Parent.class);
        assertThat(Parent.Child.class.getNestHost()).isEqualTo(Parent.class);
        assertThat(Parent.Child.Grandchild.class.getNestHost()).isEqualTo(Parent.class);
    }

    @Test
    void testNestMembers() {
        assertThat(Parent.class.getNestMembers()).containsExactly(Parent.class, Parent.Child.class, Parent.Child.Grandchild.class);

        assertThat(Parent.Child.class.getNestMembers()).containsExactly(Parent.class, Parent.Child.class, Parent.Child.Grandchild.class);

        assertThat(Parent.Child.Grandchild.class.getNestMembers()).containsExactly(Parent.class, Parent.Child.class, Parent.Child.Grandchild.class);
    }

    @Test
    void testIsNestmateOf() {
        assertThat(Parent.Child.class.isNestmateOf(Parent.class)).isTrue();
        assertThat(Parent.class.isNestmateOf(Parent.Child.class)).isTrue();
        assertThat(Parent.class.isNestmateOf(Parent.Child.Grandchild.class)).isTrue();
        assertThat(Parent.Child.class.isNestmateOf(Parent.Child.Grandchild.class)).isTrue();
    }
}
