package com.Codelabs.crimezone.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Alfons on 3/3/2015.
 */
public class MyVolley {

    private static final int MAX_IMAGE_CACHE_ENTIRES  = 100;

    private static RequestQueue mRequestQueue;


    private MyVolley() {
        // no instances
    }


    public static void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }


    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }
}
