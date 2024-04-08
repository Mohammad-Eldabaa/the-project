package com.example.shifaaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RViewAdapter_area extends RecyclerView.Adapter<RViewAdapter_area.First_aid_VHolder> {

    ArrayList<Danger> dangers ;
    OnItemClickListener listener;

    public RViewAdapter_area(ArrayList<Danger> dangers, OnItemClickListener listener) {
        this.dangers = dangers;
        this.listener = listener;
    }

    @NonNull
    @Override
    public First_aid_VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.area_designe,null,false);
        First_aid_VHolder vHolder= new First_aid_VHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull First_aid_VHolder holder, int position) {

        Danger d = dangers.get(position);

        holder.tv_name.setText(d.getName());


    }

    @Override
    public int getItemCount() {
        return dangers.size();
    }
















//___________________________________________________________________________________________________
    class First_aid_VHolder extends RecyclerView.ViewHolder{

        TextView tv_name;


// holder class for Recycler view danger
        public First_aid_VHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_aid);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (listener != null)
                        listener.onItemClick(getAdapterPosition()+1);
                }
            });
        }
    }
//___________________________________________________________________________________________________




}
