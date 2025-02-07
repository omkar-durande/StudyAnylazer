package com.example.studyanalayzer.homefragment.targetDailyMonthly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyanalayzer.Pomodrome;
import com.example.studyanalayzer.notesfragment.Notes;
import com.example.studyanalayzer.R;
import com.google.android.material.progressindicator.CircularProgressIndicator;

import java.util.ArrayList;

public class targetDailyMonthlyAd extends RecyclerView.Adapter<targetDailyMonthlyAd.ViewHolder> {

    Context context;
    ArrayList<targetAchiver> arrtargetAchivers;
    ImageView home ,note , score ,pomodrome;
    public targetDailyMonthlyAd(Context context,ArrayList<targetAchiver> arrtargetAchivers)
    {
        this.arrtargetAchivers = arrtargetAchivers;
        this.context =context ;
    }
    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.targetrecycleview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewTargetDayMonth.setText(arrtargetAchivers.get(position).Daily);
        holder.remining.setText(arrtargetAchivers.get(position).achivedPercentage);
        holder.achived.setProgress(arrtargetAchivers.get(position).progess);
        holder.targetView.setOnClickListener(v -> {
            // Replace fragment when the item is clicked
            Fragment fragment = new Pomodrome(); // Replace with your actual fragment class
            if (context instanceof FragmentActivity) {
                FragmentActivity activity = (FragmentActivity) context;
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null); // Optional: add to back stack
                fragmentTransaction.commit();
                pomodrome = ((FragmentActivity) context).findViewById(R.id.pomodromeNav);
                pomodrome.setImageResource(R.drawable.pomodromedark);
                home =((FragmentActivity) context).findViewById(R.id.homeNav);
                home.setImageResource(R.drawable.homelight);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrtargetAchivers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTargetDayMonth,remining ;
        CircularProgressIndicator achived;
        CardView targetView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            targetView = itemView.findViewById(R.id.targetrecycleview);
            textViewTargetDayMonth = itemView.findViewById(R.id.textViewTargetDayMonth);
            remining = itemView.findViewById(R.id.completement);
            achived = itemView.findViewById(R.id.progressIndicator);
            

        }

        public CardView getTargetView() {
            return targetView;
        }
    }
}
