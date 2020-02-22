package com.ieeecs.arcs20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter_combo extends RecyclerView.Adapter<RecyclerViewAdapter_combo.MyViewHolder> {

    Context mContext;
    List<Combo_prof> mData;

    public RecyclerViewAdapter_combo(Context mContext, List<Combo_prof> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter_combo.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_combo_profilie, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter_combo.MyViewHolder holder, int position) {
        holder.tname.setText(mData.get(position).getCombotype());
        holder.event1.setText(mData.get(position).getEvent1());
        holder.event2.setText(mData.get(position).getEvent2());
        holder.event1val.setText("Rs.".concat(Float.toString(mData.get(position).getEvent1price())));
        holder.event2val.setText("Rs.".concat(Float.toString(mData.get(position).getEvent2price())));
        holder.total.setText("Rs.".concat(Float.toString(mData.get(position).getTotal())));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tname,event1,event2,event1val,total,event2val;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tname= itemView.findViewById(R.id.COMBO);
            event1=itemView.findViewById(R.id.EVENT1);
            event2=itemView.findViewById(R.id.EVENT2);
            total=itemView.findViewById(R.id.TOTALval);
            event1val=itemView.findViewById(R.id.EVENT1val);
            event2val=itemView.findViewById(R.id.EVENT2val);


        }
    }
}
