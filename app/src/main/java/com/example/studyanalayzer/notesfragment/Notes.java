package com.example.studyanalayzer.notesfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studyanalayzer.R;
import com.example.studyanalayzer.notesfragment.noteSubjectSection.NotesSubject;
import com.example.studyanalayzer.notesfragment.noteSubjectSection.notesSubjectRecycle;
import com.example.studyanalayzer.notesfragment.notechapter.NoteChapter;
import com.example.studyanalayzer.notesfragment.notechapter.NotesChapteReAd;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Notes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Notes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    ArrayList<NotesSubject> arrNotesSubject = new ArrayList<>(); ;
    ArrayList<NoteChapter> arrNoteChapter = new ArrayList<>();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Notes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Notes.
     */
    // TODO: Rename and change types and number of parameters
    public static Notes newInstance(String param1, String param2) {
        Notes fragment = new Notes();
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





        View view =inflater.inflate(R.layout.fragment_notes, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.noteContainer);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        notesSubjectRecycle notesSubjectRecycleadpator = new notesSubjectRecycle(getContext(),arrNotesSubject);
        recyclerView.setAdapter(notesSubjectRecycleadpator);

        arrNotesSubject.add(new NotesSubject(R.drawable.java ,"Java Notes" ,"Mr Mane Sir"));
        arrNotesSubject.add(new NotesSubject(R.drawable.java ,"c++ Notes" ,"Mr shinde Sir"));

        RecyclerView recyclerViewChapter = view.findViewById(R.id.chapterContainer);
        recyclerViewChapter.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        NotesChapteReAd notesChapteReAd = new NotesChapteReAd(getContext(),arrNoteChapter);
        recyclerViewChapter.setAdapter(notesChapteReAd);

        arrNoteChapter.add(new NoteChapter());
        arrNoteChapter.add(new NoteChapter());
        arrNoteChapter.add(new NoteChapter());


        return view;
    }
}