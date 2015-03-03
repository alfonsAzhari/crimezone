package com.Codelabs.crimezone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class ModelLaporanKejahatan {

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
        private String tanggalKejadian;

        @JsonProperty("alamat_kejahatan")
        private String alamatKejadian;

        @JsonProperty("nama_jenis_kejahatan")
        private String namaJenisKejahatan;

        @JsonProperty("nama_petugas")
        private String namaPetugas;

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

        public String getTanggalKejadian() {
            return tanggalKejadian;
        }

        public void setTanggalKejadian(String tanggalKejadian) {
            this.tanggalKejadian = tanggalKejadian;
        }

        public String getAlamatKejadian() {
            return alamatKejadian;
        }

        public void setAlamatKejadian(String alamatKejadian) {
            this.alamatKejadian = alamatKejadian;
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
    }
}
