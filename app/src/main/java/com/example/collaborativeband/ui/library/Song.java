package com.example.collaborativeband.ui.library;

import android.graphics.drawable.Drawable;

public class Song {
    public int id;
    private String name;
    private String singer;
    private String style;
    private String language;
    private String time;
    private String key;
    private String instruments;
    private String note;
    private String path;
    //
    private int imgId;
    private int prof; // color

    //----------Functions-------------
    public Song(){
    }

    public Song(int id, String name, String singer, String style, String language,
                String time, String key, String instruments, String note,
                String path, int imgId, int prof){
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.style = style;
        this.language = language;
        this.time = time;
        this.key = key;
        this.instruments = instruments;
        this.note = note;
        this.path = path;
        this.imgId = imgId;
        this.prof = prof;
    }

    //---------Getter---------------
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSinger(){
        return singer;
    }

    public String getStyle() {
        return style;
    }

    public String getLanguage() {
        return language;
    }

    public String getTime() {
        return time;
    }

    public String getKey() {
        return key;
    }

    public String getInstruments() {
        return instruments;
    }

    public String getNote() {
        return note;
    }

    public String getPath() {
        return path;
    }

    public int getImgId() {
        return imgId;
    }

    public int getProf(){
        return prof;
    }


    //--------Setter-----------------------------------
    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSinger(String singer){
        this.singer = singer;
    }

    public void setStyle(String style){
        this.style = style;
    }

    public void setLanguage(String language){
        this.language = language;
    }

    public void setTime(String time){
        this.time = time;
    }

    public void setKey(String key){
        this.key = key;
    }

    public void setInstruments(String instruments){
        this.instruments = instruments;
    }

    public void setNote(String note){
        this.note = note;
    }

    public void setImgId(int imgId){
        this.imgId = imgId;
    }

    public void setProf(int prof){
        this.prof = prof;
    }
}
