package com.example.studyanalayzer.homefragment.home_page_note.targetDailyMonthly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyanalayzer.R;
import com.google.android.material.progressindicator.CircularProgressIndicator;

import java.util.ArrayList;

public class targetDailyMonthlyAd extends RecyclerView.Adapter<targetDailyMonthlyAd.ViewHolder> {

    Context context;
    ArrayList<targetAchiver> arrtargetAchivers;
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

    }

    @Override
    public int getItemCount() {
        return arrtargetAchivers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTargetDayMonth,remining ;
        CircularProgressIndicator achived;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTargetDayMonth = itemView.findViewById(R.id.textViewTargetDayMonth);
            remining = itemView.findViewById(R.id.completement);
            achived = itemView.findViewById(R.id.progressIndicator);
        }
    }
}
