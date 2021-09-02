package com.example.tranbusdemo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.tranbusdemo.R;
import com.example.tranbusdemo.Util.CreateData;
import com.example.tranbusdemo.Util.Statics;

import java.util.Locale;

public class SplashScreen extends AppCompatActivity {
    private ProgressBar mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if(Locale.getDefault().getLanguage().compareTo("ar")==0){
            Statics.language=false;
        }else Statics.language=true;

        mProgress = (ProgressBar) findViewById(R.id.simpleProgressBar);

        new Thread(new Runnable() {
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();

    }
    private void doWork() {

        for (int progress=0; progress<100; progress+=40) {
            try {
                Thread.sleep(1000);
                mProgress.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void startApp() {
        CreateData createData=new CreateData();
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
    }
}