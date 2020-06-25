package com.sajal.mvvmtutorial;

public class Place {

    private String title;
    private String imageUrl;

    public Place(String imageUrl, String title) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public Place() {

    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
