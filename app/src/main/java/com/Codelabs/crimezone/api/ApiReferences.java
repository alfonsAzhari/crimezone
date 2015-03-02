package com.Codelabs.crimezone.api;

/**
 * Created by irfan on 02/03/15.
 */
public class ApiReferences {

    public static final String SITENAME = "http://crimezoneapp.com/";

    public static final String APIs = "api/";

    //Modul PHP
    public static final String MODUL_BIND_USER_DATA = "bind_user_data.php";
    public static final String MODUL_POST_USER_DATA = "post_user_data.php";

    //Fungsi get data
    public String postRegister() {
        return SITENAME + APIs + MODUL_POST_USER_DATA;
    }

    public String postLogin() {
        return SITENAME + APIs + MODUL_POST_USER_DATA;
    }
}
