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

import com.example.studyanalayzer.homefragment.Home;

public class Fregment_holder extends AppCompatActivity {

    ImageView home, note , pomodrome , scorecard ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fregment_holder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top+50, systemBars.right, systemBars.bottom);
            return insets;
        });

        home = findViewById(R.id.homeNav);
        note = findViewById(R.id.notesNav);
        pomodrome = findViewById(R.id.pomodromeNav);
        scorecard = findViewById(R.id.scoreNav);

        //default
        loadFragment(new Home(),home,R.drawable.homedark);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new Home(),home ,R.drawable.homedark);

            }
        });



        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new Notes(),note ,R.drawable.notesdark);

            }
        });

        pomodrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Pomodrome(),pomodrome,R.drawable.pomodromedark);

            }
        });

        scorecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Scorecard(),scorecard,R.drawable.scorecarddark);

            }
        });

    }
    public void loadFragment(Fragment fragment,ImageView view,int image) {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (currentFragment != null && currentFragment.getClass().equals(fragment.getClass())) {
            return; // Fragment is already loaded
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);


        resetNavigationButton();

        loadNavigationButton(view,image);
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