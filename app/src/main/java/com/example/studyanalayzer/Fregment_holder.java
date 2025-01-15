package com.example.studyanalayzer;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Fregment_holder extends AppCompatActivity {

    ImageView home, note , pomodrome , scorecard ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fregment_holder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, 0, systemBars.right, 0);
            return insets;
        });


        home = findViewById(R.id.homeNav);
        note = findViewById(R.id.notesNav);
        pomodrome = findViewById(R.id.pomodromeNav);
        scorecard = findViewById(R.id.scoreNav);

        //default
        loadFragment(new Home());
        home.setImageResource(R.drawable.homedark);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNavigationButton();
                loadFragment(new Home());
                loadNavigationButton(home ,R.drawable.homedark);
            }
        });



        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNavigationButton();
                loadFragment(new Notes());
                loadNavigationButton(note ,R.drawable.notesdark);
            }
        });

        pomodrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNavigationButton();
                loadFragment(new Pomodrome());
                loadNavigationButton(pomodrome,R.drawable.pomodromedark);
            }
        });

        scorecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNavigationButton();
                loadFragment(new Scorecard());
                loadNavigationButton(scorecard,R.drawable.scorecarddark);
            }
        });

    }
    public  void loadFragment(Fragment fragament)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,fragament);
        fragmentTransaction.commit();
    }
    public  void loadNavigationButton(ImageView view,int image)
    {
        view.setImageResource(image);

    }
    public void resetNavigationButton()
    {
        note.setImageResource(R.drawable.noteslight);
        home.setImageResource(R.drawable.homelight);
        scorecard.setImageResource(R.drawable.scorecardlight);
        pomodrome.setImageResource(R.drawable.pomodromelight);
    }
}