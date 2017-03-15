package com.example.dega.refa.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.dega.refa.R;
import com.example.dega.refa.model.Weather;
import com.example.dega.refa.viewmodel.IMainVM;
import com.example.dega.refa.viewmodel.IMainVMListener;

/**
 * Created by ddelgado on 15/03/2017.
 * <p>
 * This class controls the data flow into model object and updates the view using the interface
 * 'IMainVM'.
 */

public class MainController extends AppCompatActivity implements IMainVMListener {

    //    We modify the View using method provided by this interface
    IMainVM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_controller);
        viewModel = (IMainVM) getSupportFragmentManager().findFragmentById(R.id.fragment);
        viewModel.setListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Weather weather = new Weather("Sunday", 23.5);
//        We update the view
        viewModel.setWeather(weather);
    }

    @Override
    public void onCamera() {
        Toast.makeText(getApplicationContext(), "CAMERA action from CONTROLLER :)", Toast.LENGTH_SHORT).show();
        viewModel.updateTitle("CAMERA !");
    }

    @Override
    public void onGallery() {
        Toast.makeText(getApplicationContext(), "GALLERY action from CONTROLLER :)", Toast.LENGTH_SHORT).show();
        viewModel.updateTitle("GALLERY !");

    }

    @Override
    public void onSlideShow() {
        Toast.makeText(getApplicationContext(), "SLIDESHOW action from CONTROLLER :)", Toast.LENGTH_SHORT).show();
        viewModel.updateTitle("SLIDEHOW !");

    }

    @Override
    public void onManage() {
        Toast.makeText(getApplicationContext(), "MANAGE action from CONTROLLER :)", Toast.LENGTH_SHORT).show();
        viewModel.updateTitle("MANAGE !");

    }

    @Override
    public void onShare() {
        Toast.makeText(getApplicationContext(), "SHARE action from CONTROLLER :)", Toast.LENGTH_SHORT).show();
        viewModel.updateTitle("SHARE !");

    }

    @Override
    public void onSend() {
        Toast.makeText(getApplicationContext(), "SEND action from CONTROLLER :)", Toast.LENGTH_SHORT).show();
        viewModel.updateTitle("SEND !");

    }


}
