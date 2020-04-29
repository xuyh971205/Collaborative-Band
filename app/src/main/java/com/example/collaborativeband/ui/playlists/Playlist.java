package com.example.collaborativeband.ui.playlists;

import com.example.collaborativeband.ui.library.Song;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Playlist {
    private int id;
    private String name;
    private String date;
    private String startAt;
    private String endAt;
    private String location;
    private String note;
    //ArrayList<Song> songs = new ArrayList<>();
    private int imgId;


    //Gson gson = new Gson();
    //String inputString = gson.toJson(songs);


    //--------------Functions-----------------------
    public Playlist(){
    }

    public Playlist(int id, String name, String date, String startAt, String endAt,
                    String location, String note, int imgId){
        this.id = id;
        this.name = name;
        this.date = date;
        this.startAt = startAt;
        this.endAt = endAt;
        this.location = location;
        this.note = note;
        //this.songs = songs;
        this.imgId = imgId;
    }

    //---------------Getter-----------------------------
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDate(){
        return date;
    }

    public String getStartAt(){
        return startAt;
    }

    public String getEndAt(){
        return endAt;
    }

    public String getLocation(){
        return location;
    }

    public String getNote(){
        return note;
    }

    /*public ArrayList<Song> getSongs(){
        return songs;
    }*/

    /*
    public String getSongById(int id){
         return songs.get(id);
    }
    */

    public int getImgId(){
        return imgId;
    }

    //-------------------Setter---------------------

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setStartAt(String startAt){
        this.startAt = startAt;
    }

    public void setEndAt(String endAt){
        this.endAt = endAt;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void setNote(String note){
        this.note = note;
    }

    /*public void setSongs(ArrayList<Song> songs){
        this.songs = songs;
    }*/

    public void setImgId(int imgId){
        this.imgId = imgId;
    }

}
