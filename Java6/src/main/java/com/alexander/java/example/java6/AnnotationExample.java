package com.alexander.java.example.java6;

import java.lang.reflect.Field;

public class AnnotationExample {

    @SystemProperty("username")
    private String username;

    public String getUsername() {
        return username;
    }

    public void processSystemProperties() throws IllegalAccessException {
        for (Field field : this.getClass().getDeclaredFields()){
            field.setAccessible(true);
            SystemProperty property = field.getDeclaredAnnotation(SystemProperty.class);
            if ( null != property ){
                String propertyValue = System.getProperty(property.value());
                field.set(this, propertyValue);
            }
        }
    }

    public static void main(String args[]) throws IllegalAccessException {
        System.setProperty("username", "alex");
        AnnotationExample example = new AnnotationExample();

        System.out.println(String.format("Username %s", example.getUsername()));
        example.processSystemProperties();
        System.out.println(String.format("Username %s", example.getUsername()));
    }
}
