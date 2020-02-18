package com.ieeecs.arcs20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Event> mData;

    public RecyclerViewAdapter(Context mContext, List<Event> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_timeline, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.event.setText(mData.get(position).getEvent());
        holder.venue.setText(mData.get(position).getVenue());
        holder.image.setImageResource(mData.get(position).getImage());
        holder.gradient.setBackgroundResource(mData.get(position).getGradient());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public View gradient;
        private RelativeLayout item;
        private TextView event;
        private TextView venue;
        private ImageView image ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item = (RelativeLayout) itemView.findViewById(R.id.layout_item);
            event = (TextView) itemView.findViewById(R.id.event);
            venue = (TextView) itemView.findViewById(R.id.venue);
            image = (ImageView) itemView.findViewById(R.id.relative_back);
            gradient = (View) itemView.findViewById(R.id.gradient_view);


        }
    }
}
