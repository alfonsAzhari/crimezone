package com.Codelabs.crimezone.model;

/**
 * Created by Alfons on 3/3/2015.
 */
public class ModelAdapterSosialisasi {

    private String title;
    private String tgl;
    private String alamat;

    public ModelAdapterSosialisasi(String title, String tgl, String alamat) {
        this.title = title;
        this.tgl = tgl;
        this.alamat = alamat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
