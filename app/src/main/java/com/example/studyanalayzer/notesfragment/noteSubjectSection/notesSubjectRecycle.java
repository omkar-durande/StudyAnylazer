package com.example.studyanalayzer.notesfragment.noteSubjectSection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyanalayzer.R;

import java.util.ArrayList;

public class notesSubjectRecycle extends RecyclerView.Adapter<notesSubjectRecycle.ViewHolder> {

    Context context;
    ArrayList<NotesSubject> arrNoteSubject;
    public notesSubjectRecycle(Context context,ArrayList<NotesSubject> arrNoteSubject)
    {
        this.context = context;
        this.arrNoteSubject = arrNoteSubject;
    }
    @Override
    public int getItemCount() {
        return arrNoteSubject.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notesrecycleview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(arrNoteSubject.get(position).image);
        holder.subjectName.setText(arrNoteSubject.get(position).subjectName);
        holder.sirName.setText(arrNoteSubject.get(position).teacherName);

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;        TextView subjectName,sirName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.subjectNotesImage);
            subjectName = itemView.findViewById(R.id.subjectName);
            sirName = itemView.findViewById(R.id.tearcherName);
        }
    }
}
