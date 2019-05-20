package com.example.kuba.astroweather1.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kuba.astroweather1.AstroCalc;
import com.example.kuba.astroweather1.AstroDT;
import com.example.kuba.astroweather1.Localization;
import com.example.kuba.astroweather1.R;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import static android.os.Looper.getMainLooper;

public class SunFragment extends Fragment  {

    private TextView time2;
    private TextView latitude, longitude, sunrise,sunset,azimuthRise,azimuthSet, twilightEvening, twilightMorning;
    private AstroCalc astroCalc;
    private int refreshTime;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.sun, container, false);
        time2 = (TextView)view.findViewById(R.id.time2);
        latitude = view.findViewById(R.id.latitude);
        longitude = view.findViewById(R.id.longitude);
        sunrise = view.findViewById(R.id.sunrise);
        sunset = view.findViewById(R.id.sunset);
        azimuthRise = view.findViewById(R.id.azimuthrise);
        azimuthSet= view.findViewById(R.id.azimuthset);
        twilightEvening = view.findViewById(R.id.twilightEvening);
        twilightMorning = view.findViewById(R.id.twilightMorning);

        refreshTime=5;

        astroCalc = new AstroCalc(AstroDT.astroDateTime, Localization.location);


        latitude.setText(Localization.getLatitude().toString());
        longitude.setText(Localization.getLongitude().toString());

        final Handler someHandler = new Handler(getMainLooper());
        someHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time2.setText(new SimpleDateFormat("HH:mm:ss", Locale.US).format(new Date()));
                someHandler.postDelayed(this, 10);
            }
        }, 10);

        someHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                someHandler.postDelayed(this, 10);
                latitude.setText(Localization.getLatitude().toString());
                longitude.setText(Localization.getLongitude().toString());

                astroCalc.setLocation(Localization.location);

                sunrise.setText(astroCalc.getSunrise().toString());
                sunset.setText(astroCalc.getSunset().toString());
                azimuthRise.setText(Double.toString(astroCalc.getAzimuthRise()));
                azimuthSet.setText(Double.toString(astroCalc.getAzimuthSet()));
                twilightEvening.setText(astroCalc.getTwilightEvening().toString());
                twilightMorning.setText(astroCalc.getTwilightMorning().toString());

                refreshTime = Localization.getRefreshTime();

            }
        }, 10);


        someHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                someHandler.postDelayed(this, 60000 * refreshTime);
                setTtime();
                astroCalc.setDateTime(AstroDT.astroDateTime);

            }
        }, 10);


        return view;
    }

    public void setTtime(){
        AstroDT.setYear(Integer.parseInt(new SimpleDateFormat("yyyy", Locale.US).format(new Date())));
        AstroDT.setMonth(Integer.parseInt(new SimpleDateFormat("MM", Locale.US).format(new Date())));
        AstroDT.setDay(Integer.parseInt(new SimpleDateFormat("dd", Locale.US).format(new Date())));
        AstroDT.setHour(Integer.parseInt(new SimpleDateFormat("HH", Locale.US).format(new Date())));
        AstroDT.setMinute(Integer.parseInt(new SimpleDateFormat("mm", Locale.US).format(new Date())));
        AstroDT.setSecond(Integer.parseInt(new SimpleDateFormat("ss", Locale.US).format(new Date())));

        System.out.println(new SimpleDateFormat("yyyy", Locale.US).format(new Date()));
        System.out.println(new SimpleDateFormat("MM", Locale.US).format(new Date()));
        System.out.println(new SimpleDateFormat("dd", Locale.US).format(new Date()));
        System.out.println(new SimpleDateFormat("HH", Locale.US).format(new Date()));
        System.out.println(new SimpleDateFormat("mm", Locale.US).format(new Date()));
        System.out.println(new SimpleDateFormat("ss", Locale.US).format(new Date()));
    };

}
