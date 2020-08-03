package com.example.movieapp;

public class Slide {

    private int Images;
     private String Title;

    public Slide(int images, String title) {
        Images = images;
        Title = title;
    }

    public int getImages() {
        return Images;
    }

    public void setImages(int images) {
        Images = images;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
