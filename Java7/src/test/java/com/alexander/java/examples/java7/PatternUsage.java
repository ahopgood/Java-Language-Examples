package com.alexander.java.examples.java7;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUsage {
    @Test
    public void testPattern(){
        String myNumeric = "12345-67890";
        Pattern myPattern = Pattern.compile("((?<first>[0-9]{5})-)([0-9]{5})");
        Matcher myMatcher = myPattern.matcher(myNumeric);
        myMatcher.matches();
        System.out.println(myMatcher.group(0));
        System.out.println(myMatcher.group(1));
        System.out.println(myMatcher.group(2));
        System.out.println(myMatcher.group(3));
        System.out.println(myMatcher.group("first"));
    }
}
