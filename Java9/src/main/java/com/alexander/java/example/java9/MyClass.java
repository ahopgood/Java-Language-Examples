package com.alexander.java.example.java9;

public class MyClass  {

    public String getString() {
        //Using the diamond operator on an anonymous inner class
        MyInterface instance =  new MyInterface<String>(){};
        return instance.defaultGreeting("Alex");
    }
}
