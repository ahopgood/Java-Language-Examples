package com.alexander.java.example.java8.streams;

import java.util.List;

/**
 * Created by alexhopgood on 14/02/17.
 */
public class Album {

    private List<Track> trackList;
    private Artist artist;

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
        return this;
    }
}
