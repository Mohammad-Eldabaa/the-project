package com.example.shifaaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RViewAdapter_number extends RecyclerView.Adapter<RViewAdapter_number.Call_VHolder> {

    ArrayList<Numbers> numbers ;
    OnItemClickListener listener;

    public RViewAdapter_number(ArrayList<Numbers> numbers, OnItemClickListener listener) {
        this.numbers = numbers;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Call_VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.call_number_designe,null,false);
        Call_VHolder vHolder= new Call_VHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Call_VHolder holder, int position) {

        Numbers d = numbers.get(position);
        holder.tv_place.setText(d.getNumber() +"\n" + d.getName());
        holder.tv_name.setText("المنطقة: " + d.getSub_place());


    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }
















//___________________________________________________________________________________________________
    class Call_VHolder extends RecyclerView.ViewHolder{

        TextView tv_name;

        TextView tv_place;

// holder class for Recycler view danger
        public Call_VHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.name);
            tv_place = itemView.findViewById(R.id.number);

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
