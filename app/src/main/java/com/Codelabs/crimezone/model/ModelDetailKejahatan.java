package com.Codelabs.crimezone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Alfons on 3/3/2015.
 */
public class ModelDetailKejahatan {

    @JsonProperty("result")
    private String result;

    @JsonProperty("item")
    private List<Item> item;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public static class Item {
        @JsonProperty("id_laporan_kejahatan")
        private String idLaporanKejahatan;

        @JsonProperty("foto_kejahatan")
        private String fotoKejahatan;

        @JsonProperty("judul_laporan_kegiatan")
        private String judulLaporanKegiatan;

        @JsonProperty("tanggal_kejadian")
        private String tglKejadian;

        @JsonProperty("alamat_kejahatan")
        private String alamatKejahatan;

        @JsonProperty("nama_jenis_kejahatan")
        private String namaJenisKejahatan;

        @JsonProperty("nama_petugas")
        private String namaPetugas;

        @JsonProperty("latitude")
        private String latitude;

        @JsonProperty("longitude")
        private String longitude;

        @JsonProperty("deskripsi_laporan_kejahatan")
        private String descLaporanKejahatan;

        @JsonProperty("nama_status_laporan")
        private String namaStatusLaporan;

        public String getIdLaporanKejahatan() {
            return idLaporanKejahatan;
        }

        public void setIdLaporanKejahatan(String idLaporanKejahatan) {
            this.idLaporanKejahatan = idLaporanKejahatan;
        }

        public String getFotoKejahatan() {
            return fotoKejahatan;
        }

        public void setFotoKejahatan(String fotoKejahatan) {
            this.fotoKejahatan = fotoKejahatan;
        }

        public String getJudulLaporanKegiatan() {
            return judulLaporanKegiatan;
        }

        public void setJudulLaporanKegiatan(String judulLaporanKegiatan) {
            this.judulLaporanKegiatan = judulLaporanKegiatan;
        }

        public String getTglKejadian() {
            return tglKejadian;
        }

        public void setTglKejadian(String tglKejadian) {
            this.tglKejadian = tglKejadian;
        }

        public String getAlamatKejahatan() {
            return alamatKejahatan;
        }

        public void setAlamatKejahatan(String alamatKejahatan) {
            this.alamatKejahatan = alamatKejahatan;
        }

        public String getNamaJenisKejahatan() {
            return namaJenisKejahatan;
        }

        public void setNamaJenisKejahatan(String namaJenisKejahatan) {
            this.namaJenisKejahatan = namaJenisKejahatan;
        }

        public String getNamaPetugas() {
            return namaPetugas;
        }

        public void setNamaPetugas(String namaPetugas) {
            this.namaPetugas = namaPetugas;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getDescLaporanKejahatan() {
            return descLaporanKejahatan;
        }

        public void setDescLaporanKejahatan(String descLaporanKejahatan) {
            this.descLaporanKejahatan = descLaporanKejahatan;
        }

        public String getNamaStatusLaporan() {
            return namaStatusLaporan;
        }

        public void setNamaStatusLaporan(String namaStatusLaporan) {
            this.namaStatusLaporan = namaStatusLaporan;
        }
    }
}
