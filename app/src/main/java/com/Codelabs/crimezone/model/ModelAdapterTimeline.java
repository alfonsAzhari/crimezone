package com.Codelabs.crimezone.model;


public class ModelAdapterTimeline {

    private String idFoto;
    private String user;
    private String address;
    private String tglPost;
    private String tagPost;
    private String title;

    public ModelAdapterTimeline(String idFoto, String user, String address, String tglPost, String tagPost, String title) {
        this.idFoto = idFoto;
        this.user = user;
        this.address = address;
        this.tglPost = tglPost;
        this.tagPost = tagPost;
        this.title = title;
    }

    public String getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(String idFoto) {
        this.idFoto = idFoto;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTglPost() {
        return tglPost;
    }

    public void setTglPost(String tglPost) {
        this.tglPost = tglPost;
    }

    public String getTagPost() {
        return tagPost;
    }

    public void setTagPost(String tagPost) {
        this.tagPost = tagPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
