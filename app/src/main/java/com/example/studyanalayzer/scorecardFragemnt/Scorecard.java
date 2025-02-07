package com.example.studyanalayzer.scorecardFragemnt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studyanalayzer.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Scorecard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Scorecard extends Fragment {

    ArrayList<tearcherScore> arrTeacherScore = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Scorecard() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Scorecard.
     */
    // TODO: Rename and change types and number of parameters
    public static Scorecard newInstance(String param1, String param2) {
        Scorecard fragment = new Scorecard();
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
        View view = inflater.inflate(R.layout.fragment_scorecard, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.ScoreRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        TearcherScoreAd tearcherScoreAd = new TearcherScoreAd(getContext(),arrTeacherScore);
        recyclerView.setAdapter(tearcherScoreAd);

        arrTeacherScore.add(new tearcherScore(22,"Shital mam","Java"));
        arrTeacherScore.add(new tearcherScore(21,"Shita222l mam","Java"));
        return  view ;
    }
}