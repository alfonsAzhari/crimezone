package com.Codelabs.crimezone.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class ModelLaporanSosialisasi {

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
        @JsonProperty("id_kegiatan")
        private String idKegiatan;

        @JsonProperty("judul_kegiatan")
        private String judulKegiatan;

        @JsonProperty("deskripsi_kegiatan")
        private String descKegiatan;

        @JsonProperty("tanggal_kegiatan")
        private String tglKegiatan;

        @JsonProperty("waktu_kegiatan")
        private String waktuKegiatan;

        @JsonProperty("status")
        private String status;

        public String getIdKegiatan() {
            return idKegiatan;
        }

        public void setIdKegiatan(String idKegiatan) {
            this.idKegiatan = idKegiatan;
        }

        public String getJudulKegiatan() {
            return judulKegiatan;
        }

        public void setJudulKegiatan(String judulKegiatan) {
            this.judulKegiatan = judulKegiatan;
        }

        public String getDescKegiatan() {
            return descKegiatan;
        }

        public void setDescKegiatan(String descKegiatan) {
            this.descKegiatan = descKegiatan;
        }

        public String getTglKegiatan() {
            return tglKegiatan;
        }

        public void setTglKegiatan(String tglKegiatan) {
            this.tglKegiatan = tglKegiatan;
        }

        public String getWaktuKegiatan() {
            return waktuKegiatan;
        }

        public void setWaktuKegiatan(String waktuKegiatan) {
            this.waktuKegiatan = waktuKegiatan;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
