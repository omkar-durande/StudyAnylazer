package com.example.studyanalayzer.notesfragment.notechapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyanalayzer.R;

import java.util.ArrayList;

public class NotesChapteReAd extends RecyclerView.Adapter<NotesChapteReAd.ViewHolder> {


    TextView chapterName,ChapterDes;
    Button view;
    Context context;
    ArrayList<NoteChapter> arrNoteChapter;
    public NotesChapteReAd(Context context, ArrayList<NoteChapter> arrNoteChapter)
    {
        this.context = context;
        this.arrNoteChapter = arrNoteChapter;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notecubjectchpterrecycle,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrNoteChapter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(View itemView)
        {
            super(itemView);
            chapterName = itemView.findViewById(R.id.ChapterName);
            ChapterDes = itemView.findViewById(R.id.chapterDes);
            view = itemView.findViewById(R.id.view);
        }
    }
}
