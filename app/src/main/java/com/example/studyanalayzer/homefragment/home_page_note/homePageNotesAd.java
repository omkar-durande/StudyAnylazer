package com.example.studyanalayzer.homefragment.home_page_note;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyanalayzer.R;
import com.example.studyanalayzer.notesfragment.Notes;

import java.util.ArrayList;

public class homePageNotesAd extends RecyclerView.Adapter<homePageNotesAd.ViewHolder> {


    Context context;
    ImageView home ,note , score ,pomodrome;
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
        holder.homePageNote.setOnClickListener(v -> {
            // Replace fragment when the item is clicked
            Fragment fragment = new Notes(); // Replace with your actual fragment class
            if (context instanceof FragmentActivity) {
                FragmentActivity activity = (FragmentActivity) context;
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null); // Optional: add to back stack
                fragmentTransaction.commit();
                note = ((FragmentActivity) context).findViewById(R.id.notesNav);
                note.setImageResource(R.drawable.notesdark);
                home =((FragmentActivity) context).findViewById(R.id.homeNav);
                home.setImageResource(R.drawable.homelight);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homePageNotes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView homePageNote;
        public ViewHolder(View itemView)
        {
            super(itemView);
            homePageNote = itemView.findViewById(R.id.homeNotesCardView);
        }


    }
}
