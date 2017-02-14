package com.alexander.java.example.java8.streams;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * Created by alexhopgood on 13/02/17.
 */
public class StreamOperationsTest {

    StreamOperations op = new StreamOperations();
    static List<Artist> artists = new LinkedList<Artist>();

    Artist theBeatles = new Artist().setFrom("Liverpool").setName("The Beatles");
    Artist theProdigy = new Artist().setFrom("Braintree").setName("The Prodigy");
    Artist sunsOfThunder = new Artist().setFrom("Neath").setName("Suns of Thunder");
    Artist oasis = new Artist().setFrom("Manchester").setName("Oasis");
    Artist theCoral = new Artist().setFrom("liverpool").setName("The Coral");
    @Before
    public void setUp(){
        artists.add(theBeatles);
        artists.add(theProdigy);
        artists.add(sunsOfThunder);
        artists.add(oasis);
        artists.add(theCoral);
    }

    @Test
    public void testMap(){
        List<String> artistNames = asList("The Beatles", "The Prodigy", "Suns of Thunder", "Oasis", "The Coral");
        List<String> artistNames_traditional = op.map_traditional(artists);
        List<String> artistNames_stream = op.map_stream(artists);

        assertEquals(artistNames, artistNames_traditional);
        assertEquals(artistNames, artistNames_stream);
    }

    @Test
    public void testFlatMap(){
        List<Integer> list1 = asList(1,2,3);
        List<Integer> list2 = asList(4,5,6);
        List<Integer> expected = asList(1,2,3,4,5,6);
        assertEquals(expected, op.flatMap_traditional(list1, list2));
        assertEquals(expected, op.flatMap_stream(list1, list2));
    }

    @Test
    public void testFilter_to_list() throws Exception {
        List<Artist> tradArtists = op.filter_to_list_traditional(artists);
        assertEquals(2, tradArtists.size());
        assertEquals("The Beatles", tradArtists.get(0).getName());
        assertEquals("The Coral", tradArtists.get(1).getName());

        List<Artist> streamArtists = op.filter_to_list_stream(artists);
        assertEquals(2, streamArtists.size());
        assertEquals("The Beatles", streamArtists.get(0).getName());
        assertEquals("The Coral", streamArtists.get(1).getName());
    }

    @Test
    public void testFilter_to_set() throws Exception {
        Set<Artist> tradArtists = op.filter_to_set_traditional(artists);
        assertEquals(2, tradArtists.size());
        assertEquals(true, tradArtists.contains(theBeatles));
        assertEquals(true, tradArtists.contains(theCoral));

        Set<Artist> streamArtists = op.filter_to_set_stream(artists);
        assertEquals(2, streamArtists.size());
        assertEquals(true, streamArtists.contains(theBeatles));
        assertEquals(true, streamArtists.contains(theCoral));
    }

    @Test
    public void testCountInLoop() throws Exception {
        int tradArtists = op.countInLoop_traditional(artists);
        assertEquals(2, tradArtists);

        long streamArtists = op.countInLoop_stream(artists);
        assertEquals(2, streamArtists);
    }



}