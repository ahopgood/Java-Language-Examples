package com.alexander.java.example.java8;

import com.alexander.java.example.java8.streams.Artist;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alexander on 28/06/2017.
 */
public class DoubleBraceInitialiser {
    
    public List<Artist> emptyInitialiser(){
        System.out.println("This is actually an anonymous class with a static initialiser");
        return new LinkedList<Artist>(){{}};
    }

    public List<Artist> withContents(){
        System.out.println("This is actually an anonymous class with a static initialiser");
        return new LinkedList<Artist>(){{add(new Artist());}};
    }
    
}
