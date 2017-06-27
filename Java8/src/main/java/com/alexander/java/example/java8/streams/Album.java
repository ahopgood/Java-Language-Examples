package com.alexander.java.example.java8.streams;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by alexhopgood on 14/02/17.
 */
public class Album {

    private List<Track> trackList;
    private Artist artist;
    private List<Artist> artists = new LinkedList<>();

    public List<Track> getTrackList() {
        return this.trackList;
    }

    public Album setTrackList(List<Track> trackList) {
        this.trackList = trackList;
        return this;
    }

    public Artist getArtist() {
        return artist;
    }

    public Album setArtist(Artist artist) {
        this.artist = artist;
        this.artists.add(artist);
        return this;
    }
    
    public Stream<Artist> getArtists(){
        return artists.stream();
    }
}
