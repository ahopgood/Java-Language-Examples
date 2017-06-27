package com.alexander.java.example.java8.streams;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by Alexander on 27/06/2017.
 */
public class PeekExampleTest {
    
    @Test
    public void peekaboo(){
        Artist sting = new Artist().setFrom("Ireland").setName("The Sting");
        Artist bono = new Artist().setFrom("Home Counties").setName("Bono");
        Track roxanne = new Track().setLength(270).setName("Roxanne");
        Track zooStation = new Track().setLength(301).setName("Zoo Station");
        Album va = new Album().setArtist(sting).setArtist(bono).setTrackList(asList(roxanne,zooStation));

        Set<String> nationalities
                = va.getArtists()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getFrom())
                .peek(nation -> System.out.println("Found nationality: " + nation))
                .collect(Collectors.<String>toSet());
    }
    
}
