package com.Codelabs.crimezone;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Codelabs.crimezone.api.ApiReferences;
import com.Codelabs.crimezone.model.ModelResponseLogin;
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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends ActionBarActivity {

    private EditText edTxt_email, edTxt_pass;
    private RelativeLayout rel_btnLogin;
    private Boolean internetTersedia = false;
    private ProgressDialog progressDialog = null;
    private Context mContext = null;
    private HttpClient httpClient;
    private HttpPost httpPost;
    private TextView txtV_email;
    private HttpResponse response;
    private ModelResponseLogin model;
    private static final String mPref = "Data User";
    private static final String EMAIL = "Email";
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = getApplicationContext();
        declareWid();
        declareInt();

        //Log.i("Data Email : ", getLastDataEmailUser());
        //Toast.makeText(mContext, getLastDataEmailUser(), Toast.LENGTH_LONG).show();
    }

    public void declareWid() {
        edTxt_email = (EditText) findViewById(R.id.edTxt_login_email);
        edTxt_pass = (EditText) findViewById(R.id.edTxt_login_pass);
        rel_btnLogin = (RelativeLayout) findViewById(R.id.rel_login_btnLogin);
    }

    public void declareInt() {
        rel_btnLogin.setOnClickListener(_login);
    }

    View.OnClickListener _login = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                loginUser();
                //getDataPref();
            } catch (Exception e) {
                e.toString();
            }
        }
    };

    public void loginUser() {
        final String email, password;
        email = edTxt_email.getText().toString();
        password = edTxt_pass.getText().toString();

        StringRequest postRequest = new StringRequest(Request.Method.POST, ApiReferences.postUrlLoginUser(), new
                Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response", response);
                        getDataUser(response);
                        if (model.getResult().equals("sukses")) {
                            Toast.makeText(mContext, model.getMsg(), Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(mContext, MainActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(mContext, model.getMsg(), Toast.LENGTH_LONG).show();
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
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };
        if (email.equals("") && password.equals("")) {
            Toast.makeText(mContext, "Email dan Password Kosong", Toast.LENGTH_LONG).show();
        } else if (password.equals("")) {
            Toast.makeText(mContext, "Password Kosong", Toast.LENGTH_LONG).show();
        } else if (email.equals("")) {
            Toast.makeText(mContext, "Email Kosong", Toast.LENGTH_LONG).show();
        } else {
            MyVolley.init(mContext);
            RequestQueue queue = MyVolley.getRequestQueue();
            queue.add(postRequest);
        }
    }

    private void getDataUser(String json) {
        ObjectMapper mp = new ObjectMapper();
        try {
            model = mp.readValue(json, ModelResponseLogin.class);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Toast.makeText(mContext, "Parsing sukses", Toast.LENGTH_SHORT).show();
        }
    }

    public void getDataPref() {
        String email_user = model.getEmail().toString();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(EMAIL, email_user);
        editor.commit();
    }

    private String getLastDataEmailUser() {
        sharedPref = getSharedPreferences(mPref, MODE_PRIVATE);
        String getEmailUser = sharedPref.getString(EMAIL, "");
        return getEmailUser;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
