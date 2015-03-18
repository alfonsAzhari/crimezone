package com.Codelabs.crimezone.model;

/**
 * Created by Alfons on 3/4/2015.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModelResponseRegister {

    @JsonProperty("nama")
    private String nama;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("no_ktp")
    private String no_ktp;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNo_ktp() {
        return no_ktp;
    }

    public void setNo_ktp(String no_ktp) {
        this.no_ktp = no_ktp;
    }
}
