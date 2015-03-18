package com.Codelabs.crimezone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.Codelabs.crimezone.api.ApiReferences;
import com.Codelabs.crimezone.model.ModelResponseRegister;
import com.Codelabs.crimezone.utils.MyVolley;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterActivity extends ActionBarActivity {

    private EditText edTxt_nama, edTxt_email, edTxt_pass, edTxt_noKtp;
    private RelativeLayout rel_btnRegis;
    private Context mContext = null;
    private HttpClient httpClient;
    private HttpResponse response;
    private HttpPost httpPost;
    private Integer WAKTU_TOAST = 1000;
    private SharedPreferences sharedPreferences;
    private static final String mPREF = "Data_User";
    private static final String NAMA = "Nama_User";
    private static final String EMAIL = "Email";
    private static final String PASSWORD = "Password";
    private static final String NO_KTP = "No_KTP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mContext = getApplicationContext();
        declareWid();
        declareInt();
        //Log.i("AAA", getLastDataUser().toArray().toString());
    }

    private void declareWid() {
        rel_btnRegis = (RelativeLayout) findViewById(R.id.rel_regis_btnRegister);

        edTxt_nama = (EditText) findViewById(R.id.edTxt_register_nama);
        edTxt_email = (EditText) findViewById(R.id.edTxt_register_email);
        edTxt_pass = (EditText) findViewById(R.id.edTxt_register_password);
        edTxt_noKtp = (EditText) findViewById(R.id.edTxt_regis_noKtp);
    }

    private void declareInt() {
        rel_btnRegis.setOnClickListener(_register);
    }

    View.OnClickListener _register = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                registerUser();
                //getDataPref();
            } catch (Exception e) {
                e.toString();
            }
        }
    };

    private void registerUser() {
        final String nama, email, password, no_ktp;
        nama = edTxt_nama.getText().toString();
        email = edTxt_email.getText().toString();
        password = edTxt_pass.getText().toString();
        no_ktp = edTxt_noKtp.getText().toString();

        StringRequest postRequest = new StringRequest(Request.Method.POST, ApiReferences.postUrlRegisterUser(), new
                Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response", response);
                        getDataUser(response);
                        if (!response.isEmpty()) {
                            Intent i = new Intent(mContext, LoginActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("nama_pengguna", nama);
                params.put("email", email);
                params.put("password", password);
                params.put("no_ktp", no_ktp);
                return params;
            }
        };
        if (nama.equals("") || email.equals("") || password.equals("") || no_ktp.equals("")) {
            Toast.makeText(mContext, "Anda belum mengisi data secara lengkap", Toast.LENGTH_SHORT).show();
        } else {
            MyVolley.init(mContext);
            RequestQueue queue = MyVolley.getRequestQueue();
            queue.add(postRequest);
        }
    }

    private void getDataUser(String json) {
        ObjectMapper mp = new ObjectMapper();
        ModelResponseRegister model = null;
        try {
            model = mp.readValue(json, ModelResponseRegister.class);
        } catch (Exception e) {
            e.toString();
        }
    }

    private void getDataPref() {
        String namaUser = edTxt_nama.getText().toString();
        String emailUser = edTxt_email.getText().toString();
        String passUser = edTxt_pass.getText().toString();
        String noKTPUser = edTxt_noKtp.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAMA, namaUser);
        editor.putString(EMAIL, emailUser);
        editor.putString(PASSWORD, passUser);
        editor.putString(NO_KTP, noKTPUser);
        editor.commit();
    }

    public List<String> getLastDataUser() {
        sharedPreferences = getSharedPreferences(mPREF, MODE_PRIVATE);
        String getEmailUser = sharedPreferences.getString(EMAIL, "");
        String getPassword = sharedPreferences.getString(PASSWORD, "");

//        List<String> listDataUser = new ArrayList<String>();
//        listDataUser.add(getEmailUser);
//        listDataUser.add(getPassword);
//
//        StringBuilder csvList = new StringBuilder();
//        for(String s : listDataUser){
//            csvList.append(s);
//            csvList.append(",");
//        }
//        return listDataUser;
        return null;
    }
}
