package com.example.studyanalayzer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class homeSubRecycAd extends RecyclerView.Adapter<homeSubRecycAd.ViewHolder> {

    Context context ;
    ArrayList<homePageSubject> hm;


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


    }



    @Override
    public int getItemCount() {
        return hm.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
