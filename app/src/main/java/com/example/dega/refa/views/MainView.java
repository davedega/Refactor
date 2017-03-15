package com.example.dega.refa.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dega.refa.R;
import com.example.dega.refa.model.Weather;
import com.example.dega.refa.viewmodel.IMainVM;
import com.example.dega.refa.viewmodel.IMainVMListener;

import org.w3c.dom.Text;

/**
 * Created by ddelgado on 15/03/2017.
 * <p>
 * This class is the only one who can modify the view through the interface 'IMainVM' called
 * from the controller
 */

public class MainView extends Fragment implements NavigationView.OnNavigationItemSelectedListener, IMainVM {

    IMainVMListener mlistener;
    View root;
    Toolbar toolbar;
    DrawerLayout drawer;
    TextView day, temp;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_main, container, false);

        toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        day = (TextView) root.findViewById(R.id.day);
        temp = (TextView) root.findViewById(R.id.temp);


        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) root.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) root.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        return root;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            mlistener.onCamera();
        } else if (id == R.id.nav_gallery) {
            mlistener.onGallery();

        } else if (id == R.id.nav_slideshow) {
            mlistener.onSlideShow();

        } else if (id == R.id.nav_manage) {
            mlistener.onManage();

        } else if (id == R.id.nav_share) {
            mlistener.onShare();

        } else if (id == R.id.nav_send) {
            mlistener.onSend();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void setListener(IMainVMListener listener) {
//        Controller Actions are going to be called with this listener
//        Usage examples are in "onNavigationItemSelected" above this method :)
        mlistener = listener;
    }

    @Override
    public void updateTitle(String title) {
        toolbar.setTitle(title);
    }

    @Override
    public void setWeather(Weather weather) {
        day.setText(weather.day);
        temp.setText("" + weather.temp+"°C");
    }


}
