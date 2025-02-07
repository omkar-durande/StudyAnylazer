package com.example.studyanalayzer.scorecardFragemnt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyanalayzer.R;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.transition.Hold;

import java.util.ArrayList;

public class TearcherScoreAd extends RecyclerView.Adapter<TearcherScoreAd.ViewHolder>
{

    Context context;
    ArrayList<tearcherScore> arrTearcherScore;

    public TearcherScoreAd(Context context, ArrayList<tearcherScore> arrTearcherScore)
    {
        this.context = context;
        this.arrTearcherScore = arrTearcherScore;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.scorecardrecycleview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull TearcherScoreAd.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return arrTearcherScore.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView ;
        ImageView image ;
        CircularProgressIndicator progressIndicator;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}