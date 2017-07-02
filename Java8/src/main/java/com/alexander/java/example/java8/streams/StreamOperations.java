package com.alexander.java.example.java8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    public Track min_traditional(List<Track> tracks){
        Track shortest = tracks.get(0);
        for (Track track : tracks){
            if (track.getLength() < shortest.getLength()){
                shortest = track;
            }
        }
        return shortest;
    }

    public Track min_stream(List<Track> tracks){
        return tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();
    }

    public Integer reduceSum_stream(List<Integer> list){
        return list.stream()
                .reduce(0, (acc, element) -> acc + element);
    }

    public Integer reduceSum_traditional(List<Integer> list){
        Integer sum = new Integer(0);
        for (Integer i : list){
            sum += i;
        }
        return sum;
    }

    public Set<String> getLongTracks_legacy(List<Album> albums){
        Set<String> tracknames = new HashSet<String>();
        for (Album album : albums){
            for (Track track : album.getTrackList()){
                if (track.getLength() > 150){
                    tracknames.add(track.getName());
                }
            }
        }
        return tracknames;
    }

    public Set<String> getLongTracks_refactor1(List<Album> albums){
        Set<String> tracknames = new HashSet<String>();
        albums.stream()
                .forEach(album -> {
                    album.getTrackList().stream()
                            .forEach(track -> {
                                if (track.getLength() > 150){
                                    tracknames.add(track.getName());
                                }
                            });
                });
        return tracknames;
    }

    public Set<String> getLongTracks_refactor2(List<Album> albums){
        Set<String> tracknames = new HashSet<String>();
        albums.stream()
                .forEach(album -> {
                    album.getTrackList().stream()
                            .filter(track -> track.getLength() > 150)
                            .map(track -> track.getName())
                            .forEach(string -> tracknames.add(string));
                });
        return tracknames;
    }

    public Set<String> getLongTracks_refactor3(List<Album> albums){
        Set<String> tracknames = new HashSet<String>();
        albums.stream()
                .flatMap(album -> album.getTrackList().stream())
                .filter(track -> track.getLength() > 150)
                .map(track -> track.getName())
                .forEach(string -> tracknames.add(string));
        return tracknames;
    }
    
    public int[] range(){
        return IntStream.range(0,3).toArray();
    }

    public int[] rangeClosed(){
        return IntStream.rangeClosed(0,3).toArray();
    }

}
