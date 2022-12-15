package com.example.it_schoolandroid;

public class MyNews {

    public MyNews(String title, String content, int image) {
        this.content = content;
        this.image = image;
        this.title = title;
    }

    String title;
    String content;
    int image;
    boolean liked = false;
}
