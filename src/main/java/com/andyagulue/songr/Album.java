package com.andyagulue.songr;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
1 Give your class an Entity annotation
2 Give your class an id, generated value of IDENTITY
3 It needs a default constructor (it will create an empty object when retrieving from the storage layer and then assign the proper)
4 Create a <EntityClassName> repository interface that extends JpaRepository
 */

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String artist;
    String title;
    int songCount;
    double length;
    String imgUrl;

    public Album(){}

    public Album(String artist, String title, int songCount, double length, String imgUrl){
        this.artist = artist;
        this.title = title;
        this.songCount = songCount;
        this.length = length;
        this.imgUrl = imgUrl;
    }
    public String getArtist(){
        return artist;
    }
    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public int getSongCount(){
        return songCount;
    }
    public void setSongCount(int songCount){
        this.songCount = songCount;
    }

    public double getLength(){
        return length;
    }
    public void setLength(int length){
        this.length = length;
    }

    public String getImgUrl(){
        return imgUrl;
    }
    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }

}