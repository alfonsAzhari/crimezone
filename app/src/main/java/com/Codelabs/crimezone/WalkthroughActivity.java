package com.Codelabs.crimezone;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Codelabs.crimezone.adapter.AdapterViewPager;

public class WalkthroughActivity extends ActionBarActivity {

    private Typeface typeFace;
    private TextView txtV_register, txtV_login;
    private ViewPager _viewPager;
    private PagerAdapter _pagerAdapter;
    private int[] flag;
    private LinearLayout llDots;
    private LinearLayout lin_btnReg, lin_btnLog;
    private Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);
        mContext = getApplicationContext();
        declareView();
        declareWid();
        declareInt();
        declareSwipe();
    }

    public void declareView() {
        //txtV_register = (TextView) findViewById(R.id.txtV_walk_register);
        //txtV_login = (TextView) findViewById(R.id.txtV_walk_login);
        _viewPager = (ViewPager) findViewById(R.id.pager);
        llDots = (LinearLayout) findViewById(R.id.llDots);
    }

    public void declareWid() {
        //lin_btnReg = (LinearLayout) findViewById(R.id.lin_walk_btnRegis);
        lin_btnLog = (LinearLayout) findViewById(R.id.lin_walk_btnLogin);
    }

    public void declareInt() {
        //lin_btnReg.setOnClickListener(_register);
        lin_btnLog.setOnClickListener(_login);
    }

    public void declareSwipe() {
        flag = new int[]{R.drawable.slider1, R.drawable.slider2, R.drawable.slider3, R.drawable.slider4};

        _pagerAdapter = new AdapterViewPager(this, flag);
        _viewPager.setAdapter(_pagerAdapter);

        for (int i = 0; i < _pagerAdapter.getCount(); i++) {
            ImageButton imgDot = new ImageButton(this);
            imgDot.setTag(i);
            imgDot.setScaleType(ImageView.ScaleType.FIT_XY);
            imgDot.setImageResource(R.drawable.dot_selector);
            imgDot.setBackgroundColor(0);
            imgDot.setPadding(5, 5, 5, 5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
            imgDot.setLayoutParams(params);
            if (i == 0) {
                imgDot.setSelected(true);
            }
            llDots.addView(imgDot);
        }

        _viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int pos) {
                Log.e("", "Page Selected is ===> " + pos);
                for (int i = 0; i < _pagerAdapter.getCount(); i++) {
                    if (i != pos) {
                        ((ImageView) llDots.findViewWithTag(i)).setSelected(false);
                    }
                }
                ((ImageView) llDots.findViewWithTag(pos)).setSelected(true);
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

        //Uncomment for set padding Margin between images.

        //int margin = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20*2,     getResources().getDisplayMetrics());
        //viewPager.setPageMargin(-20);
    }


    View.OnClickListener _register = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent i = new Intent(mContext, RegisterActivity.class);
//            startActivity(i);
        }
    };

    View.OnClickListener _login = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(mContext, LoginActivity.class);
            startActivity(i);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_walkthrough, menu);
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
