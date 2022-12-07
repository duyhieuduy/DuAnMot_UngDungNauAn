package com.example.cookingapp.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.cookingapp.R;

public class Waitlm extends Fragment {
    Handler handler = new Handler();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.waitfrag, container, false);

        final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
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
                SystemClock.sleep(500); // Sleep 5 seconds.

                progressBar.setIndeterminate(false);
                progressBar.setMax(1);
                progressBar.setProgress(1);

                // Update interface
                handler.post(new Runnable() {
                    public void run() {
                        FragmentManager fragmentManager =getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.containerloaimon, new LoaiMonFragment(), null);
                        fragmentTransaction.commit();
                    }
                });
            }
        });
        thread.start();

        return view;
    }
}
