package com.example.water.marketplace;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.water.marketplace.adapter.TabAdapter;
import com.example.water.marketplace.fragment.branditem.BrandFragmentList;
import com.example.water.marketplace.login.SignIn;
import com.example.water.marketplace.login.SwitchLogin;
import com.example.water.marketplace.login.profile.ProfileSetting;
import com.example.water.marketplace.login.session.SessionUser;


import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    private static final String TAG = "";
    private Fragment fragment = null;
    ViewPager pager;
    ArrayList<Fragment> fragmentList;
    TabAdapter fragmentPagerAdapter;
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragment = new SwitchLogin();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
/*
        if (!SessionUser.get(this).isLoggedIn()) {
            fragment = new SignIn();
        }
        else
        {
            fragment = new ProfileSetting();

        }
*/
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.home, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case android.R.id.home:
          //      onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displaySelectedScreen(int fragmentMenuId) {

        Fragment fragment = null;
        switch(fragmentMenuId) {
            case R.id.nav_camera:
                fragment = new BrandFragmentList();
                break;
            case R.id.nav_gallery:
                fragment = new SwitchLogin();
                break;
            case R.id.nav_slideshow:
                fragment = new ProfileSetting();
                break;
            case R.id.nav_manage:

                break;
            case R.id.nav_share:

                break;
            case R.id.nav_send:

                break;
            default:
                fragment = new SwitchLogin();
        }

        try {
            if (fragment != null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.home_cont_frg, fragment);
                ft.commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        displaySelectedScreen(item.getItemId());
        return true;
    }



}
