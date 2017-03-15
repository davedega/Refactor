package com.example.dega.refa.viewmodel;

import com.example.dega.refa.model.Weather;

/**
 * Created by ddelgado on 15/03/2017.
 */

public interface IMainVM {
    void setListener(IMainVMListener listener);

    void updateTitle(String title);

    void setWeather(Weather weather);

}
