package com.alexander.java.example.java8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Created by alexhopgood on 13/02/17.
 */
public class StreamOperations {

    public List<String> map_traditional(List<Artist> artists){
        List<String> collected = new LinkedList<String>();
        for (Artist artist : artists){
            String name = artist.getName();
            collected.add(name);
        }
        return collected;
    }
    
    public List<String> map_stream(List<Artist> artists){
        return artists.stream()
                .map(artist -> artist.getName())
                .collect(Collectors.toList());
    }
    
    public List<Integer> flatMap_traditional(List<Integer> list1, List<Integer> list2){
        List<Integer> combined = new LinkedList<Integer>();
        for (Integer value : list1){
            combined.add(value);
        }
        for (Integer value : list2){
            combined.add(value);
        }
        return combined;
    }

    public List<Integer> flatMap_stream(List<Integer> list1, List<Integer> list2){
        return Stream.of(list1, list2)
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
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
    
    public Track max_traditional(List<Track> tracks){
        Track longest = tracks.get(0);
        for (Track t : tracks){
            if (t.getLength() > longest.getLength()){
                longest = t;
            }
        }
        return longest;
    }

    public Track max_stream(List<Track> list){
        return list
                .stream()
                .max(Comparator.comparing(track -> track.getLength()))
                .get();
    }

//    public Track max_reduce(List<Track> list){
//        return list.stream()
//                .reduce(Comparator.comparing(track -> track..getLength()))
//                .get();
//    }
}
