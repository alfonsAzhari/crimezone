package com.Codelabs.crimezone;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.Codelabs.crimezone.adapter.AdapterSosialisasi;
import com.Codelabs.crimezone.api.ApiReferences;
import com.Codelabs.crimezone.model.ModelAdapterSosialisasi;
import com.Codelabs.crimezone.model.ModelLaporanSosialisasi;
import com.Codelabs.crimezone.parser.JacksonParser;
import com.Codelabs.crimezone.utils.MyVolley;
import com.Codelabs.crimezone.utils.NetworkChecking;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


public class FragmentSosialisasi extends Fragment {

    private Context context;
    private RecyclerView recyclerView;
    private LinearLayout linProgress;

    private ArrayList<ModelAdapterSosialisasi> itemSosialisasi;
    private AdapterSosialisasi adapter;
    private ModelLaporanSosialisasi model;
    private NetworkChecking networkChecking;
    private RequestQueue requestQueue;

    public FragmentSosialisasi() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sosialisasi, container, false);

        context = getActivity();
        declareView(rootView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        loadData(ApiReferences.getUrlLaporanSosialisasi());

        return rootView;
    }

    public void declareView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_sosialisasi);
        linProgress = (LinearLayout) view.findViewById(R.id.lin_sosialisasi_progress);
    }

    private void loadData(String url) {
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        int socketTimeout = 10000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        objectRequest.setRetryPolicy(policy);
        MyVolley.init(context);
        requestQueue = MyVolley.getRequestQueue();
        networkChecking = new NetworkChecking(context);
        if (networkChecking.isConnectingToInternet()) {
            requestQueue.add(objectRequest);
        } else {
            Toast.makeText(context, "Anda tidak terkoneksi dengan internet", Toast.LENGTH_LONG).show();
        }
    }

    private void fetchData(String json) {
        try {
            model = JacksonParser.getDataSosialisasi(json);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Log.i("Parsing", "Parsing Sukses");
        }

        itemSosialisasi = new ArrayList<>();
        for (ModelLaporanSosialisasi.Item item : model.getItem()) {
            itemSosialisasi.add(new ModelAdapterSosialisasi(item.getJudulKegiatan(),item.getTglKegiatan(),item.getWaktuKegiatan()));
        }

        adapter = new AdapterSosialisasi(context, itemSosialisasi);
        recyclerView.setAdapter(adapter);
        linProgress.setVisibility(View.GONE);
    }
}
