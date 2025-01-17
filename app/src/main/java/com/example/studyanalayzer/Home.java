package com.example.studyanalayzer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {



    ArrayList<homePageSubject> arrHomePageSubjectsobj = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
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
        RecyclerView recyclerView = view.findViewById(R.id.recyclerContainer);
        RecyclerView recyclerView_second = view.findViewById(R.id.recyclerContainer2);
        recyclerView_second.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL ,false));
        homePageSubject homePageSubjectObj = new homePageSubject();
        arrHomePageSubjectsobj.add(homePageSubjectObj);
        arrHomePageSubjectsobj.add(homePageSubjectObj);
        arrHomePageSubjectsobj.add(homePageSubjectObj);
        arrHomePageSubjectsobj.add(homePageSubjectObj);
        arrHomePageSubjectsobj.add(homePageSubjectObj);

        homeSubRecycAd adpater = new homeSubRecycAd(getContext() ,arrHomePageSubjectsobj);
        recyclerView.setAdapter(adpater);
        recyclerView_second.setAdapter(adpater  );

        return view;
    }
}