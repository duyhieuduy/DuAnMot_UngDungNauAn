package com.example.cookingapp.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.ProgressBar;

import com.example.cookingapp.Menu_Activity;
import com.example.cookingapp.R;

public class WaitActivity extends AppCompatActivity {
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setIndeterminate(true);

        Thread thread = new Thread(new Runnable()  {

            @Override
            public void run() {
                // Update interface
                handler.post(new Runnable() {
                    public void run() {

                    }
                });
                // Do something ... (Update database,..)
                SystemClock.sleep(1000); // Sleep 5 seconds.

                progressBar.setIndeterminate(false);
                progressBar.setMax(1);
                progressBar.setProgress(1);

                // Update interface
                handler.post(new Runnable() {
                    public void run() {
                    startActivity(new Intent(WaitActivity.this, Menu_Activity.class));
                    }
                });
            }
        });
        thread.start();
    }
}