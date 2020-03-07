package com.vaani.event_specific;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myviewholder> {
    private ArrayList<String> list;
    private Context context;
    public RecyclerViewAdapter(ArrayList<String> data, Context context)
    {
        list = data;
        this.context = context;
    }
    @NonNull
    public myviewholder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(context).inflate(R.layout.card_view,parent,false));
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.combo.setText(list.get(position));

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class myviewholder extends RecyclerView.ViewHolder{

        public TextView combo,event1, event2,price1, price2, total ;
        public View line1,line2;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            combo = itemView.findViewById(R.id.COMBO);
            event1 = itemView.findViewById(R.id.EVENT1);
            event2 = itemView.findViewById(R.id.EVENT2);
            line1 = itemView.findViewById(R.id.hr1);
            line2 = itemView.findViewById(R.id.hr2);
            price1 = itemView.findViewById(R.id.price1);
            price2 = itemView.findViewById(R.id.price2);
            total = itemView.findViewById(R.id.TOTAL);

        }

    }
}