package com.example.shifaaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RViewAdapter_doctors extends RecyclerView.Adapter<RViewAdapter_doctors.Call_VHolder> {

    ArrayList<Doctors> doctors ;
    OnItemClickListener listener;

    public RViewAdapter_doctors(ArrayList<Doctors> doctors, OnItemClickListener listener) {
        this.doctors = doctors;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RViewAdapter_doctors.Call_VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctors_names,null,false);
        RViewAdapter_doctors.Call_VHolder vHolder= new RViewAdapter_doctors.Call_VHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RViewAdapter_doctors.Call_VHolder holder, int position) {

        Doctors d = doctors.get(position);
        holder.tv_place.setText(d.getPlace());
        holder.tv_name.setText(d.getName());
        holder.tv_partion.setText(d.getPartion());


    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }
















//___________________________________________________________________________________________________

    class Call_VHolder extends RecyclerView.ViewHolder{

        TextView tv_name;

        TextView tv_partion;
        TextView tv_place;

        // holder class for Recycler view danger
        public Call_VHolder(@NonNull View itemView) {
            super(itemView);

            tv_partion = itemView.findViewById(R.id.doctor_partion);
            tv_name = itemView.findViewById(R.id.doctor_name);
            tv_place = itemView.findViewById(R.id.doctor_place);

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



