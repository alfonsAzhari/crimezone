package com.Codelabs.crimezone;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Codelabs.crimezone.api.ApiReferences;
import com.Codelabs.crimezone.model.ModelDetailKejahatan;
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
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


public class FragmentDetailKejahatan extends Fragment {

    private Context context;
    private ModelDetailKejahatan model;
    private NetworkChecking checking;
    private RequestQueue requestQueue;

    private ImageView imgFoto;
    private ImageView imgAvatar;
    private TextView txtDetailUser;
    private TextView txtDetailTgl;
    private TextView txtDetailAlamat;
    private TextView txtDetailTag;
    private TextView txtDetailDesc;
    private LinearLayout linBtnDetailMaps;
    private ArrayList<String> location = new ArrayList<>();

    public FragmentDetailKejahatan() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_detail_kejahatan, container, false);

        context = getActivity();
        String id = getArguments().getString("id");
        declareView(rootView);
        loadData(ApiReferences.getUrlDetailKejahatan() + id);

        return rootView;
    }

    private void declareView(View v) {
        imgAvatar = (ImageView)v.findViewById(R.id.img_detail_kejahatan_ava);
        imgFoto = (ImageView)v.findViewById(R.id.img_detail_kejahatan_foto);
        txtDetailUser = (TextView)v.findViewById(R.id.txt_detail_kejahatan_user);
        txtDetailTgl = (TextView)v.findViewById(R.id.txt_detail_kejahatan_tgl);
        txtDetailAlamat = (TextView)v.findViewById(R.id.txt_detail_kejahatan_alamat);
        txtDetailTag = (TextView)v.findViewById(R.id.txt_detail_kejahatan_tag);
        txtDetailDesc = (TextView)v.findViewById(R.id.txt_detail_kejahatan_desc);
        linBtnDetailMaps = (LinearLayout)v.findViewById(R.id.lin_btn_detail_kejahatan_maps);
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
                Log.i("Request Gagal", error.toString());
            }
        });

        int socketTimeout = 10000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        objectRequest.setRetryPolicy(policy);
        MyVolley.init(context);
        requestQueue = MyVolley.getRequestQueue();
        checking = new NetworkChecking(context);
        if(checking.isConnectingToInternet()) {
            requestQueue.add(objectRequest);
        } else {
            Toast.makeText(context, "Anda tidak terkoneksi dengan internet", Toast.LENGTH_LONG).show();
        }
    }

    private void fetchData(String json) {
        try {
            model = JacksonParser.getDataDetailKejahatan(json);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Log.i("Parsing", "Parsing Sukses");
        }

        txtDetailUser.setText(model.getItem().get(0).getNamaPetugas());
        txtDetailTgl.setText(model.getItem().get(0).getTglKejadian());
        txtDetailAlamat.setText(model.getItem().get(0).getAlamatKejahatan());
        txtDetailTag.setText(model.getItem().get(0).getNamaJenisKejahatan());
        txtDetailDesc.setText(model.getItem().get(0).getDescLaporanKejahatan());
        Picasso.with(context).load(ApiReferences.getUrlImage() + model.getItem().get(0).getFotoKejahatan().replaceAll(" ", "%20")).into(imgFoto);
        linBtnDetailMaps.setOnClickListener(showMaps);

        location.add(model.getItem().get(0).getLatitude());
        location.add(model.getItem().get(0).getLongitude());
    }

    View.OnClickListener showMaps = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            
        }
    };
}
