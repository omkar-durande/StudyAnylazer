package com.example.studyanalayzer.home_page_note;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyanalayzer.R;

import java.util.ArrayList;

public class homePageNotesAd extends RecyclerView.Adapter<homePageNotesAd.ViewHolder> {


    Context context;
    ArrayList<homePageNotes> homePageNotes ;
    public  homePageNotesAd(Context context,ArrayList<homePageNotes> homePageNotes)
    {
        this.context = context;
        this.homePageNotes = homePageNotes;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(context).inflate(R.layout.home_page_notes,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return homePageNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView)
        {
            super(itemView);
        }


    }
}
