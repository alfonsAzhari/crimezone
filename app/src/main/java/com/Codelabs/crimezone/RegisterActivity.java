package com.Codelabs.crimezone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;

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
import java.util.Map;

import com.Codelabs.crimezone.model.ModelResponseRegister;
import com.Codelabs.crimezone.utils.MyVolley;
import com.Codelabs.crimezone.api.ApiReferences;

public class RegisterActivity extends ActionBarActivity {

    private EditText edTxt_nama, edTxt_email, edTxt_pass, edTxt_noKtp;
    private RelativeLayout rel_btnRegis;
    private Context mContext = null;
    private HttpClient httpClient;
    private HttpResponse response;
    private HttpPost httpPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    private void declareWid() {
        rel_btnRegis = (RelativeLayout) findViewById(R.id.rel_regis_btnRegister);

        edTxt_nama = (EditText) findViewById(R.id.edTxt_register_nama);
        edTxt_email = (EditText) findViewById(R.id.edTxt_register_email);
        edTxt_pass = (EditText) findViewById(R.id.edTxt_register_password);
        edTxt_noKtp = (EditText) findViewById(R.id.edTxt_regis_noKtp);
    }

    private void registerUser() {
        final String nama, email, password, no_ktp;
        nama = edTxt_nama.getText().toString();
        email = edTxt_email.getText().toString();
        password = edTxt_pass.getText().toString();
        no_ktp = edTxt_noKtp.getText().toString();

        MyVolley.init(mContext);
        RequestQueue queue = MyVolley.getRequestQueue();
        StringRequest postRequest = new StringRequest(Request.Method.POST, ApiReferences.postUrlRegisterUser(), new
                Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response", response);
                        getDataUser(response);
                        if (!response.isEmpty()) {
                            Intent i = new Intent(mContext, MainActivity.class);
                            startActivity(i);
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
                params.put("nama", nama);
                params.put("email", email);
                params.put("password", password);
                params.put("no_ktp", no_ktp);
                return params;
            }
        };
        queue.add(postRequest);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
