package com.ieeecs.arcs20;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WorkshopAdapter extends RecyclerView.Adapter<WorkshopAdapter.CustomViewHolder>{

    private ArrayList<WorkshopClass> dataList;
    private Context context;

    public WorkshopAdapter(Context context, ArrayList<WorkshopClass> dataList) {
        this.context=context;
        this.dataList=dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private CardView workshopRoot;
        private ImageView image;
        private ProgressBar progressBar;
        private TextView name;

        //private TextView name;
        public CustomViewHolder(View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progress_bar);
            workshopRoot = itemView.findViewById(R.id.workshop_root_layout);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.workshop_image);

        }
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.workshop_items, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int i) {
        //Glide.with(holder.itemView.getContext()).load(dataList.get(i).getImage()).into(holder.image);
        /*GlideApp.with(holder.itemView.getContext()).load(dataList.get(i).getImage()).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                holder.progressBar.setVisibility(View.GONE);
                holder.image.setVisibility(View.VISIBLE);
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                holder.progressBar.setVisibility(View.GONE);
                holder.image.setVisibility(View.VISIBLE);
                return false;
            }
        }).into(holder.image);
        //holder.name.setText(dataList.get(i).getName());
        // Opening Sponsor's website via browser
        holder.sponsor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(dataList.get(i).getsDesc()));
                context.startActivity(intent);
            }
        });*/

        holder.name.setText(dataList.get(i).getName());


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
