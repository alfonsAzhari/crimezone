package com.Codelabs.crimezone.api;


public class ApiReferences {

    private static final String SITENAME = "http://crimezoneapp.com/";

    private static final String MODUL_API = "api/";
    private static final String MODUL_IMAGE = "foto_kejahatan/";

    private static final String MODUL_LAPORAN_KEJAHATAN = "bind_laporan_kejahatan.php";
    private static final String MODUL_DETAIL_KEJAHATAN = "bind_detail_laporan_kejahatan.php?id_laporan_kejahatan=";
    private static final String MODUL_LAPORAN_KEGIATAN = "bind_kegiatan_sosialisasi.php";

    public static String getUrlLaporanKejahatan() {
        return SITENAME + MODUL_API + MODUL_LAPORAN_KEJAHATAN;
    }

    public static String getUrlDetailKejahatan() {
        return SITENAME + MODUL_API + MODUL_DETAIL_KEJAHATAN;
    }

    public static String getUrlLaporanSosialisasi() {
        return SITENAME + MODUL_API + MODUL_LAPORAN_KEGIATAN;
    }

    public static String getUrlImage() {
        return SITENAME + MODUL_IMAGE;
    }
}
