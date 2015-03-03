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

import com.Codelabs.crimezone.adapter.AdapterTimeline;
import com.Codelabs.crimezone.api.ApiReferences;
import com.Codelabs.crimezone.model.ModelAdapterTimeline;
import com.Codelabs.crimezone.model.ModelLaporanKejahatan;
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
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


public class FragmentTimeline extends Fragment {

    private Context context;
    private RecyclerView recyclerView;
    private LinearLayout linProgress;

    private ArrayList<ModelAdapterTimeline> itemTimeline;
    private AdapterTimeline adapter;
    private ModelLaporanKejahatan model;
    private NetworkChecking networkChecking;
    private RequestQueue requestQueue;

    public FragmentTimeline() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_timeline, container, false);

        context = getActivity();
        declareView(rootView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        loadData(ApiReferences.getUrlLaporanKejahatan());

        return rootView;
    }

    private void declareView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_timeline);
        linProgress = (LinearLayout) view.findViewById(R.id.lin_timeline_progress);
    }

    private void loadData(String url) {
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("sukses", response.toString());
                if (!response.equals("")) {
                    fetchData(response.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Error", error.toString());
            }
        });

        int socketTimeout = 10000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        MyVolley.init(context);
        requestQueue = MyVolley.getRequestQueue();
        objectRequest.setRetryPolicy(policy);
        networkChecking = new NetworkChecking(context);
        if (networkChecking.isConnectingToInternet()) {
            requestQueue.add(objectRequest);
        } else {
            Toast.makeText(context, "Anda tidak terkoneksi dengan internet", Toast.LENGTH_LONG).show();
        }
    }

    private void fetchData(String result) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            model = mapper.readValue(result, ModelLaporanKejahatan.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Log.i("Parsing", "Parsing Sukses");
        }

        Toast.makeText(context, model.getItem().get(0).getNamaPetugas(), Toast.LENGTH_LONG).show();
        itemTimeline = new ArrayList<ModelAdapterTimeline>();
        for (ModelLaporanKejahatan.Item item : model.getItem()) {
            itemTimeline.add(new ModelAdapterTimeline(
                    item.getFotoKejahatan(),
                    item.getNamaPetugas(),
                    item.getAlamatKejadian(),
                    item.getTanggalKejadian(),
                    item.getNamaJenisKejahatan(),
                    item.getJudulLaporanKegiatan())
            );
        }

        adapter = new AdapterTimeline(context, itemTimeline);
        recyclerView.setAdapter(adapter);
        linProgress.setVisibility(View.GONE);
    }
}
