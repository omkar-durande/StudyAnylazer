package com.example.studyanalayzer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyanalayzer.R;
import com.google.android.material.progressindicator.CircularProgressIndicator;

import java.util.Locale;

public class
Pomodrome extends Fragment {

    Button startToFocus;
    boolean clockIsStart = false;
    TextView timerText;
    CircularProgressIndicator timeProgress;

    private CountDownTimer countDownTimer;
    private static final long START_TIME_IN_MILLIS = 1500000; // 25 minutes in milliseconds
    private long timeLeftInMillis = START_TIME_IN_MILLIS; // Remaining time

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pomodrome, container, false);

        // Initialize views
        startToFocus = view.findViewById(R.id.starttoFocus);
        timerText = view.findViewById(R.id.text);
        timeProgress = view.findViewById(R.id.timeProgress);

        RecyclerView recyclerView = view.findViewById(R.id.recycletime);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize progress indicator
        timeProgress.setMax((int) (START_TIME_IN_MILLIS / 1000));
        timeProgress.setProgress((int) (timeLeftInMillis / 1000));

        // Set up start button
        startToFocus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clockIsStart) {
                    startTimer();
                    startToFocus.setText("Pause");
                } else {
                    pauseTimer();
                    startToFocus.setText("Start");
                }
                clockIsStart = !clockIsStart;
            }
        });

        updateTimerText();
        return view;
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimerText();
                timeProgress.setProgress((int) (timeLeftInMillis / 1000));
            }

            @Override
            public void onFinish() {
                clockIsStart = false;
                startToFocus.setText("Start");
                timeLeftInMillis = START_TIME_IN_MILLIS; // Reset timer
                timeProgress.setProgress((int) (START_TIME_IN_MILLIS / 1000));
                updateTimerText();
            }
        }.start();
    }

    private void pauseTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void updateTimerText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timerText.setText(timeFormatted);
    }
}
