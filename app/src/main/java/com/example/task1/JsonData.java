package com.example.task1;

public class JsonData {
    private String title,pictureurl,thumbnailurl;

    public String getTitle() {
        return title;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public String getThumbnailurl() {
        return thumbnailurl;
    }

    public JsonData(String title, String pictureurl, String thumbnailurl) {
        this.title = title;
        this.pictureurl = pictureurl;
        this.thumbnailurl = thumbnailurl;
    }
}
