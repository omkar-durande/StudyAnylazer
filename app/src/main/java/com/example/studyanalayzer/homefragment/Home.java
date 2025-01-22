package com.example.studyanalayzer.homefragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyanalayzer.R;
import com.example.studyanalayzer.homefragment.home_page_note.homePageNotes;
import com.example.studyanalayzer.homefragment.home_page_note.homePageNotesAd;
import com.example.studyanalayzer.homefragment.home_page_note.targetDailyMonthly.targetAchiver;
import com.example.studyanalayzer.homefragment.home_page_note.targetDailyMonthly.targetDailyMonthlyAd;
import com.example.studyanalayzer.homefragment.home_page_subject.homePageSubject;
import com.example.studyanalayzer.homefragment.home_page_subject.homeSubRecycAd;
import com.example.studyanalayzer.homefragment.mcqtest.mcqTest;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {



    //it for home page Teacher score

    RecyclerView recyclerView;
    Toolbar HomeToolbar;
    Button test ;
    ArrayList<homePageSubject> arrHomePageSubjectsobj = new ArrayList<>();
    ArrayList<targetAchiver>   arrTargetAchiver = new ArrayList<>();
    //it is for home page Notes Score
    ArrayList<homePageNotes>  arrHomePageNotes = new ArrayList<>();


   private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.homeSubRecycler);
        HomeToolbar = view.findViewById(R.id.toolbar);
         test = view.findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(getContext(), mcqTest.class);
                startActivity(test);
            }
        });

        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        activity.setSupportActionBar(HomeToolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerViewTarget = view.findViewById(R.id.targetrecycle);
        recyclerViewTarget.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        targetDailyMonthlyAd  targetDailyMonthlyAdapter = new targetDailyMonthlyAd(getContext(),arrTargetAchiver);
        recyclerViewTarget.setAdapter(targetDailyMonthlyAdapter);

        arrTargetAchiver.add(new targetAchiver(95,"90%\nRemining time : 1hrs","Daily Target : 6 hrs"));
        arrTargetAchiver.add(new targetAchiver(95,"90%\nRemining Day: 2 Day","Month Target :30 Day"));




        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL ,false));
        homeSubRecycAd homeSubRecycAdapter = new homeSubRecycAd(getContext(),arrHomePageSubjectsobj);
        recyclerView.setAdapter(homeSubRecycAdapter);
        homePageSubject homePageSubjectObj = new homePageSubject();




        arrHomePageSubjectsobj.add(homePageSubjectObj);
        arrHomePageSubjectsobj.add(homePageSubjectObj);
        arrHomePageSubjectsobj.add(homePageSubjectObj);
        arrHomePageSubjectsobj.add(homePageSubjectObj);
        arrHomePageSubjectsobj.add(homePageSubjectObj);





       // View  homeNotesView = inflater.inflate(R.layout.home_page_notes,container,false);

        RecyclerView homeNotesRecycleView = view.findViewById(R.id.homeNotesRecycleView);
        homeNotesRecycleView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        homePageNotesAd homePageNotesAdapter = new homePageNotesAd(getContext(),arrHomePageNotes);
        homeNotesRecycleView.setAdapter(homePageNotesAdapter);

        arrHomePageNotes.add(new homePageNotes());
        arrHomePageNotes.add(new homePageNotes());


        return view;
    }
}