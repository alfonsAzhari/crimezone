package com.Codelabs.crimezone.model;

public class ModelAdapterListNav {

    private int imageId;
    private String titleItem;

    public ModelAdapterListNav(int imageId, String titleItem) {
        this.imageId = imageId;
        this.titleItem = titleItem;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitleItem() {
        return titleItem;
    }

    public void setTitleItem(String titleItem) {
        this.titleItem = titleItem;
    }
}
