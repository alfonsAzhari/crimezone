package com.Codelabs.crimezone;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.Codelabs.crimezone.adapter.AdapterListDrawer;
import com.Codelabs.crimezone.model.ModelAdapterListNav;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private LinearLayout linNavDrawer;
    private ListView listNav;
    private ActionBarDrawerToggle drawerToggle;
    private Button btn;

    private ArrayList<ModelAdapterListNav> item;
    private AdapterListDrawer adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        declareView();

        setSupportActionBar(toolbar);

        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        setItemListDrawer(this);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name) {
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);

        if (savedInstanceState == null) {
            selectItem(1);
        }

    }

    private void setItemListDrawer(Context context) {
        item = new ArrayList<>();
        item.add(new ModelAdapterListNav(R.drawable.ic_timeline, "Timeline"));
        item.add(new ModelAdapterListNav(R.drawable.ic_police, "Sosialisasi"));

        adapter = new AdapterListDrawer(item, context);
        listNav.setAdapter(adapter);
        listNav.setOnItemClickListener(new DrawerItemClickListener());
    }

    private void declareView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_main);
        linNavDrawer = (LinearLayout) findViewById(R.id.lin_nav_drawer);
        listNav = (ListView) findViewById(R.id.list_drawer);
    }

    private void selectItem(int position) {
        Fragment fragmentTimeline = new FragmentTimeline();
        Fragment fragmentSosialisasi = new FragmentSosialisasi();
        FragmentManager fragmentManager = getFragmentManager();
        switch (position) {
            case 0:
                fragmentManager.beginTransaction().replace(R.id.frame_main_content, fragmentTimeline).commit();
                break;
            case 1:
                fragmentManager.beginTransaction().replace(R.id.frame_main_content, fragmentSosialisasi).commit();
        }
        listNav.setItemChecked(position, true);
        drawerLayout.closeDrawer(linNavDrawer);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(linNavDrawer)) {
            drawerLayout.closeDrawer(linNavDrawer);
        } else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = drawerLayout.isDrawerOpen(linNavDrawer);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }
}
