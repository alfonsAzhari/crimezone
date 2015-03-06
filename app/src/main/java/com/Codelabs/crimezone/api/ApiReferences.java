package com.Codelabs.crimezone.api;


public class ApiReferences {

    private static final String SITENAME = "http://crimezoneapp.com/";

    private static final String MODUL_API = "api/";
    private static final String MODUL_IMAGE = "foto_kejahatan/";

    private static final String MODUL_LAPORAN_KEJAHATAN = "bind_laporan_kejahatan.php";
    private static final String MODUL_DETAIL_KEJAHATAN = "bind_detail_laporan_kejahatan.php?id_laporan_kejahatan=";
    private static final String MODUL_LAPORAN_SOSIALISASI = "bind_kegiatan_sosialisasi.php";
    private static final String MODUL_LOGIN_USER = "post_login.php";
    private static final String MODUL_REGISTER_USER = "post_user_data.php";

    public static String postUrlLoginUser() {
        return SITENAME + MODUL_API + MODUL_LOGIN_USER;
    }

    public static String postUrlRegisterUser() {
        return SITENAME + MODUL_API + MODUL_REGISTER_USER;
    }

    public static String getUrlLaporanKejahatan() {
        return SITENAME + MODUL_API + MODUL_LAPORAN_KEJAHATAN;
    }

    public static String getUrlDetailKejahatan() {
        return SITENAME + MODUL_API + MODUL_DETAIL_KEJAHATAN;
    }

    public static String getUrlLaporanSosialisasi() {
        return SITENAME + MODUL_API + MODUL_LAPORAN_SOSIALISASI;
    }

    public static String getUrlImage() {
        return SITENAME + MODUL_IMAGE;
    }
}
