package com.alexander.java.example.java8.streams;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Comparator;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by alexhopgood on 12/04/17.
 */
public class ParallelTest {
    static int ten = 10;
    static int thousand = 10_000;
    static int million = 1_000_000_00;

    static int[] tenPrimitive = new int[ten];
    static Integer[] tenBoxed = new Integer[ten];

    static int[] thousandPrimitive = new int[thousand];
    static Integer[] thousandBoxed = new Integer[thousand];

    static int[] millionPrimitive = new int[million];
    static Integer[] millionBoxed = new Integer[million];


    @BeforeClass
    public static void setUpBefore(){
        setupArrays(tenPrimitive, tenBoxed, ten);
        setupArrays(thousandPrimitive, thousandBoxed, thousand);
        setupArrays(millionPrimitive, millionBoxed, million);
    }

    private static void setupArrays(int[] primitive, Integer[] boxed, int size){
        Random rand = new Random();
        for (int i = 0; i < size; i++){
            int value = rand.nextInt();
            primitive[i] = value;
            boxed[i] = new Integer(value);
        }
    }

    @Test
    public void testParallelFilter(){
        BoxingTest boxing = new BoxingTest();
        boxing.runFilter(millionBoxed);
        boxing.runFilter(millionBoxed);
        boxing.runFilter(millionBoxed);

        boxing.runFilter(millionPrimitive);
        boxing.runFilter(millionPrimitive);
        boxing.runFilter(millionPrimitive);

        runParallelFilter(millionBoxed);
        runParallelFilter(millionBoxed);
        runParallelFilter(millionBoxed);

        runParallelFilter(millionPrimitive);
        runParallelFilter(millionPrimitive);
        runParallelFilter(millionPrimitive);
    }

    @Test
    public void testParallelMax(){
        BoxingTest boxing = new BoxingTest();
        boxing.runMax(millionBoxed);
        boxing.runMax(millionBoxed);
        boxing.runMax(millionBoxed);

        boxing.runMax(millionPrimitive);
        boxing.runMax(millionPrimitive);
        boxing.runMax(millionPrimitive);

        runParallelMax(millionBoxed);
        runParallelMax(millionBoxed);
        runParallelMax(millionBoxed);

        runParallelMax(millionPrimitive);
        runParallelMax(millionPrimitive);
        runParallelMax(millionPrimitive);
    }

    private void runParallelFilter(Integer[] array){
        StringBuilder stats = new StringBuilder();
        Date start = new Date();
        stats.append(array.length+" Boxed Parallel Filter: ");
        stats.append(
                Stream.of(array).parallel()
                        .filter(x -> (x > 4)));
        Date end = new Date();
        stats.append(". Running time: "+(end.getTime()-start.getTime())+"ms");
        System.out.println(stats.toString());
    }

    private void runParallelFilter(int[] array){
        StringBuilder stats = new StringBuilder();
        Date start = new Date();
        stats.append(array.length+" Primitive Parallel Filter: ");
        stats.append(
                IntStream.of(array).parallel()
                        .filter(x -> (x > 4)));
        Date end = new Date();
        stats.append(". Running time: "+(end.getTime()-start.getTime())+"ms");
        System.out.println(stats.toString());
    }

    private void runParallelMax(Integer[] array){
        StringBuilder stats = new StringBuilder();
        Date start = new Date();
        stats.append(array.length+" Boxed Parallel Max: ");
        stats.append(
                Stream.of(array).parallel()
                        .max(Comparator.naturalOrder()));
        Date end = new Date();
        stats.append(". Running time: "+(end.getTime()-start.getTime())+"ms");
        System.out.println(stats.toString());
    }

    private void runParallelMax(int[] array){
        StringBuilder stats = new StringBuilder();
        Date start = new Date();
        stats.append(array.length+" Primitive Parallel Max: ");
        stats.append(
                IntStream.of(array).parallel()
                        .max().getAsInt());
        Date end = new Date();
        stats.append(". Running time: "+(end.getTime()-start.getTime())+"ms");
        System.out.println(stats.toString());
    }
}
