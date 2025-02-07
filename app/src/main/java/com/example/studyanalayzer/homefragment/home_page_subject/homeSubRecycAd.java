package com.example.studyanalayzer.homefragment.home_page_subject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyanalayzer.Pomodrome;
import com.example.studyanalayzer.R;
import com.example.studyanalayzer.scorecardFragemnt.Scorecard;

import java.util.ArrayList;

public class homeSubRecycAd extends RecyclerView.Adapter<homeSubRecycAd.ViewHolder> {

    Context context ;
    ArrayList<homePageSubject> hm;
    ImageView home ,note , score ,pomodrome;


    public homeSubRecycAd(Context home, ArrayList<homePageSubject> arrHomePageSubjectsobj) {
        this.context = home;
        this.hm = arrHomePageSubjectsobj;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_page_recylceview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.cardView.setOnClickListener(v -> {
            // Replace fragment when the item is clicked
            Fragment fragment = new Scorecard(); // Replace with your actual fragment class
            if (context instanceof FragmentActivity) {
                FragmentActivity activity = (FragmentActivity) context;
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null); // Optional: add to back stack
                fragmentTransaction.commit();
                score = ((FragmentActivity) context).findViewById(R.id.scoreNav);
                score.setImageResource(R.drawable.scorecarddark);
                home =((FragmentActivity) context).findViewById(R.id.homeNav);
                home.setImageResource(R.drawable.homelight);
            }
        });

    }



    @Override
    public int getItemCount() {
        return hm.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView ;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            cardView = itemView.findViewById(R.id.homePageScore);

        }
    }

}
