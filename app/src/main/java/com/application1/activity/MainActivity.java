package com.application1.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.application1.R;
import com.application1.fragment.AccountFragment;
import com.application1.fragment.HomeFragment;
import com.application1.fragment.MenFragment;
import com.application1.fragment.ProductViewFragment;
import com.application1.fragment.WishListFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    public static final int HOME = 1;
    public static final int WISHLIST = 2;
    public static final int ACCOUNT = 3;
    public static final int DESCRIPTION_VIEW = 4;
    public static final int PRODUCT_VIEW = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        LinearLayout llUserAccount = (LinearLayout) findViewById(R.id.ll_user_account);
        llUserAccount.setOnClickListener(this);

        LinearLayout llHome = (LinearLayout) findViewById(R.id.ll_home);
        llHome.setOnClickListener(this);

        LinearLayout llWishList = (LinearLayout) findViewById(R.id.ll_wishlist);
        llWishList.setOnClickListener(this);

        setTabFragment(HOME);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_men) {
            // Handle the camera action
        } else if (id == R.id.nav_women) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                setTabFragment(HOME);
                break;
            case R.id.ll_wishlist:
                setTabFragment(WISHLIST);
                break;
            case R.id.ll_user_account:
                setTabFragment(ACCOUNT);
                break;
        }
    }

    public void setTabFragment(int position) {
        switch (position) {
            case HOME:
                replaceFragment(HomeFragment.newInstance());
                break;
            case WISHLIST:
                replaceFragment(WishListFragment.newInstance());
                break;
            case ACCOUNT:
                replaceFragment(AccountFragment.newInstance());
                break;
            case DESCRIPTION_VIEW:
                addFragment(MenFragment.newInstance());
                break;
            case PRODUCT_VIEW:
                addFragment(ProductViewFragment.newInstance());
                break;

        }
    }

    void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }

    void addFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container, fragment);
        ft.addToBackStack("fragment");
        ft.commit();
    }
}
