public class Parent {

    public void myPublic() {}

    private void myPrivate() {}

    class Child {
        public void nestedPublic() {
            myPrivate();
        }

        class Grandchild {
            public void nestedPublic() {
                System.out.println("Test");
            }
        }
    }
}
