package com.alexander.java.example.java8.streams;

import org.junit.*;

import java.util.Comparator;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by alexhopgood on 12/04/17.
 */
public class BoxingTest {

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



    @Before
    public void setUp(){
    }

    @After
    public void tearDown(){

    }

    @Test
    public void primitiveVsBoxedTest(){

        run(tenPrimitive);
        run(tenBoxed);

        run(tenPrimitive);
        run(tenBoxed);

        run(tenPrimitive);
        run(tenBoxed);


        run(thousandPrimitive);
        run(thousandBoxed);

        run(thousandPrimitive);
        run(thousandBoxed);

        run(thousandPrimitive);
        run(thousandBoxed);


        run(millionPrimitive);
        run(millionBoxed);

        run(millionPrimitive);
        run(millionBoxed);

        run(millionPrimitive);
        run(millionBoxed);
    }

    private void run(int[] array){
        StringBuilder stats = new StringBuilder();
        Date start = new Date();
        stats.append(array.length+" Primitives: ");
        stats.append(IntStream.of(array)
                .filter(x -> (x > 4))
                .max().getAsInt());

        Date end = new Date();
        stats.append(". Running time: "+(end.getTime()-start.getTime())+"ms");
        System.out.println(stats.toString());
    }

    private void run(Integer[] array){
        StringBuilder stats = new StringBuilder();
        Date start = new Date();
        stats.append(array.length+" Boxed: ");
        stats.append(Stream.of(array)
                .filter(x -> (x > 4))
                .max(Comparator.naturalOrder())
                .get());
        Date end = new Date();
        stats.append(". Running time: "+(end.getTime()-start.getTime())+"ms");
        System.out.println(stats.toString());

    }
}
