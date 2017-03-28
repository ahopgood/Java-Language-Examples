package com.alexander.java.example.java8.interfaces;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alexhopgood on 27/02/17.
 */
public class ParentTest {

    ChildImpl childImpl = new ChildImpl();
    Child child = new Child() {};
    Parent parent = new Parent() {};
    ParentImpl parentImpl = new ParentImpl();
    OverridingParent overridingParent = new OverridingParent();
    OverridingChild overridingChild = new OverridingChild();


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    String parentMessage =  "Welcome from Parent default interface";
    String parentImplMessage = "Welcome from Parent Overriding implementation";
    String childImplMessage = "Welcome from Child implementation";
    String overridingParentMessage = "I'm an Overriding Class of the ParentImpl";
    String overridingChildMessage = "I'm an Overriding class of the OverridingParent and an implementor of Child";

    @Test
    public void testParentInterface() throws Exception {
        assertEquals(parentMessage, parent.method());
    }

    @Test
    public void testChildInterface() throws Exception {
        assertEquals(parentMessage, child.method());
    }

    @Test
    public void testChildImpl() throws Exception {
        assertEquals(childImplMessage, childImpl.method());
    }

    @Test
    public void testParentImpl() throws Exception {
        assertEquals(parentImplMessage, parentImpl.method());
    }

    @Test
    public void testOverridingParentImpl() throws Exception {
        assertEquals(overridingParentMessage, overridingParent.method());
    }

    @Test
    public void testOverridingChildImpl() throws Exception {
        assertEquals(overridingChildMessage, overridingChild.method());
    }

}
