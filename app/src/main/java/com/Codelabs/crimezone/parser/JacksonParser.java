package com.Codelabs.crimezone.parser;

import com.Codelabs.crimezone.model.ModelDetailKejahatan;
import com.Codelabs.crimezone.model.ModelLaporanKejahatan;
import com.Codelabs.crimezone.model.ModelLaporanSosialisasi;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class JacksonParser {

    public static ModelLaporanKejahatan getDataKejahatan(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ModelLaporanKejahatan model = mapper.readValue(json, ModelLaporanKejahatan.class);
        return model;
    }

    public static ModelLaporanSosialisasi getDataSosialisasi(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ModelLaporanSosialisasi model = mapper.readValue(json, ModelLaporanSosialisasi.class);
        return model;
    }

    public static ModelDetailKejahatan getDataDetailKejahatan(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ModelDetailKejahatan model = mapper.readValue(json, ModelDetailKejahatan.class);
        return model;
    }
}
