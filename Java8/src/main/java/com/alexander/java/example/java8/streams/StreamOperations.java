package com.alexander.java.example.java8.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by alexhopgood on 13/02/17.
 */
public class StreamOperations {

    public int countInLoop_traditional(List<Artist> artists){
        int count = 0;
        Iterator<Artist> iterator = artists.iterator();
        while(iterator.hasNext()){
            Artist artist = iterator.next();
            if (artist.isFrom("Liverpool")){
                count++;
            }
        }
        return count;
    }

    public long countInLoop_stream(List<Artist> artists){
        return artists.stream().filter(artist -> artist.isFrom("liverpool"))
                .count();
    }

    public List<Artist> filter_to_list_traditional(List<Artist> artists){
        List<Artist> filtered = new LinkedList<Artist>();
        Iterator<Artist> iterator = artists.iterator();
        while(iterator.hasNext()){
            Artist artist = iterator.next();
            if (artist.isFrom("Liverpool")){
                filtered.add(artist);
            }
        }
        return filtered;
    }

    public List<Artist> filter_to_list_stream(List<Artist> artists){
        return artists.stream()
                .filter(artist -> artist.isFrom("Liverpool"))
                .collect(Collectors.toList());
    }

    public Set<Artist> filter_to_set_traditional(List<Artist> artists){
        Set<Artist> filtered = new HashSet<Artist>();
        Iterator<Artist> iterator = artists.iterator();
        while(iterator.hasNext()){
            Artist artist = iterator.next();
            if (artist.isFrom("Liverpool")){
                filtered.add(artist);
            }
        }
        return filtered;
    }

    public Set<Artist> filter_to_set_stream(List<Artist> artists){
        return artists.stream()
                .filter(artist -> artist.isFrom("liverpool"))
                .collect(Collectors.toSet());
    }
}
