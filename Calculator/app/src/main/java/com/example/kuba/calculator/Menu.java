package com.example.kuba.calculator;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button basicButton, advancedButton, aboutButton,exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        basicButton = (Button) findViewById(R.id.basicCalButton);
        advancedButton = (Button) findViewById(R.id.advancedCalButton);
        aboutButton = (Button) findViewById(R.id.aboutButton);
        exitButton = (Button) findViewById(R.id.exitButton);

        basicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                openBasicCalc();
            }
        });

        advancedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                openAdvancedCalc();
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                openAbout();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate();
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
    private void openBasicCalc() {
        Intent intent = new Intent(getApplicationContext(), BasicCalc.class);
        startActivity(intent);
    }

    private void openAdvancedCalc() {
        Intent intent = new Intent(getApplicationContext(), AdvancedCalc.class);
        startActivity(intent);
    }

    private void openAbout(){
        Intent intent = new Intent(getApplicationContext(),About.class);
        startActivity(intent);
    }

    void vibrate(){
        Vibrator vb = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vb.vibrate(5);
    }

}


//TODO negativ 0
//TODO