package com.alexander.java.example.java8.streams;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.function.Function.*;
import static org.junit.Assert.*;

/**
 * Created by alexhopgood on 13/02/17.
 */
public class StreamOperationsTest {

    StreamOperations op = new StreamOperations();
    List<Artist> artists = new LinkedList<Artist>();

    Artist theBeatles = new Artist().setFrom("Liverpool").setName("The Beatles");
    Artist theProdigy = new Artist().setFrom("Braintree").setName("The Prodigy");
    Artist sunsOfThunder = new Artist().setFrom("Neath").setName("Suns of Thunder");
    Artist oasis = new Artist().setFrom("Manchester").setName("Oasis");
    Artist theCoral = new Artist().setFrom("liverpool").setName("The Coral");

    List<Track> tracks = new LinkedList<Track>();

    Track misery = new Track().setLength(109).setName("misery");
    Track jericho = new Track().setLength(222).setName("Jericho");
    Track swingit = new Track().setLength(270).setName("Swing it like you love it");
    Track shakermaker = new Track().setLength(370).setName("Shakermaker");
    Track spanish_main = new Track().setLength(113).setName("Spanish Main");

    List<Album> albums = new LinkedList<Album>();

    Album pleasePleaseMe = new Album().setArtist(theBeatles).setTrackList(asList(misery));
    Album experience = new Album().setArtist(theProdigy).setTrackList(asList(jericho));
    Album putYourMusicWhereYourMouthIs = new Album().setArtist(sunsOfThunder).setTrackList(asList(swingit));
    Album defintelyMaybe = new Album().setArtist(oasis).setTrackList(asList(shakermaker));
    Album theCoralAlbum = new Album().setArtist(theCoral).setTrackList(asList(spanish_main));

    @Before
    public void setUp(){
        artists.add(theBeatles);
        artists.add(theProdigy);
        artists.add(sunsOfThunder);
        artists.add(oasis);
        artists.add(theCoral);

        tracks.add(misery);
        tracks.add(jericho);
        tracks.add(swingit);
        tracks.add(shakermaker);
        tracks.add(spanish_main);

        albums.add(pleasePleaseMe);
        albums.add(experience);
        albums.add(putYourMusicWhereYourMouthIs);
        albums.add(defintelyMaybe);
        albums.add(theCoralAlbum);
    }

    @Test
    public void testMax(){
        Track longestTrack = shakermaker;
        Track track_traditional = op.max_traditional(tracks);
        Track track_strean = op.max_stream(tracks);

        assertEquals(longestTrack, track_traditional);
        assertEquals(longestTrack, track_strean);
    }

    @Test
    public void testMin(){
        Track shortestTrack = misery;
        Track track_traditional = op.min_traditional(tracks);
        Track track_strean = op.min_stream(tracks);

        assertEquals(shortestTrack, track_traditional);
        assertEquals(shortestTrack, track_strean);
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

    @Test
    public void testReduceSum(){
        List<Integer> numbers = asList(1,2,3);
        assertEquals(6, op.reduceSum_stream(numbers).intValue());
        assertEquals(6, op.reduceSum_traditional(numbers).intValue());
    }

    @Test
    public void testReduceMax(){
        List<Integer> numbers = asList(1,3,2);
        assertEquals(3, op.reduceMax_stream(numbers).intValue());
        assertEquals(3, op.reduceMax_traditional(numbers).intValue());
    }
    
    @Test
    public void testGetLongTracks(){
        Set<String> expected = new HashSet<String>();
        expected.add("Jericho");
        expected.add("Swing it like you love it");
        expected.add("Shakermaker");
        assertEquals(expected, op.getLongTracks_legacy(albums));
        assertEquals(expected, op.getLongTracks_refactor1(albums));
        assertEquals(expected, op.getLongTracks_refactor2(albums));
        assertEquals(expected, op.getLongTracks_refactor3(albums));
    }

    @Test
    public void testRange(){
        assertEquals(3, op.range().length);
        assertEquals(0, op.range()[0]);
        assertEquals(1, op.range()[1]);
        assertEquals(2, op.range()[2]);
    }

    @Test
    public void testRangeClosed(){
        assertEquals(4, op.rangeClosed().length);
        assertEquals(0, op.rangeClosed()[0]);
        assertEquals(1, op.rangeClosed()[1]);
        assertEquals(2, op.rangeClosed()[2]);
        assertEquals(3, op.rangeClosed()[3]);
    }
    
    @Test
    public void testFilter_ObjectNull(){
        List<Integer> numbers = Arrays.asList(1, null, 2, null, 3);
        assertEquals(5, numbers.size());
        
        List<Integer> filtered = numbers
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        assertEquals(3, filtered.size());

        List<Integer> nullOnly = numbers
                .stream()
                .filter(Objects::isNull)
                .collect(Collectors.toList());
        assertEquals(2, nullOnly.size());
    }
    
    @Test
    public void testMap_functionIdentity(){
        class Person{
            private Integer id;
            private String name;
            public Person(Integer id, String name){
                this.id = id;
                this.name = name;
            }
            
            public Integer id(){
                return this.id;
            }
            
            public String name(){
                return this.name;
            }
        }
        List<Person> people = Arrays.asList(
                new Person(1, "Alex"), 
                new Person(2, "Katie"), 
                new Person(3, "Alfie"));
        
        Map<Integer, Person> mapped = people
                .stream()
                .collect(Collectors.toMap(Person::id, Function.identity()));
        
        assertEquals("Alex",    mapped.get(1).name());
        assertEquals("Katie",   mapped.get(2).name());
        assertEquals("Alfie",   mapped.get(3).name());
    }

    @Test
    public void testGroupBy(){
        Map<String, List<Album>> artistMaps = op.albums_groupBy(albums);
        assertEquals(artists.size(), artistMaps.size());
    }
}