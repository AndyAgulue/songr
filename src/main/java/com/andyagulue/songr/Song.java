package com.andyagulue.songr;
import javax.persistence.*;

@Entity
public class Song {
    String title;
    String album;
    int length;
    int trackNumber;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    @ManyToOne
    Album albumSongs;

    public Song(String title, Album albumSongs, int length, int trackNumber){
        this.title = title;
        this.albumSongs = albumSongs;
        this. length = length;
        this.trackNumber = trackNumber;
    }

    public Song(){}

    public long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getAlbum(){
        return album;
    }

    public int getLength(){
        return length;
    }

    public int getTrackNumber(){
        return trackNumber;
    }
}
