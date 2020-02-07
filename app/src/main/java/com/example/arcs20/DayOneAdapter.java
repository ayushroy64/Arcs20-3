package com.example.arcs20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import java.util.List;

public class DayOneAdapter extends ArrayAdapter<TimelineDataModel> {

    List<TimelineDataModel> myList;
    Context context;
    int resource;

    public DayOneAdapter(Context context, int resource, List<TimelineDataModel> myList) {
        super(context, resource, myList);
        this.context = context;
        this.resource = resource;
        this.myList = myList;
    }


    @NonNull
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(R.layout.day_one_adapter, null, false);

        //getting the view elements of the list from the view
        ImageView img = view.findViewById(R.id.d1_imageView);
        TextView tx1 = view.findViewById(R.id.d1_tv1);
        TextView tx2 = view.findViewById(R.id.d1_textView2);
        TextView tx3 = view.findViewById(R.id.d1_textView);

        TimelineDataModel timelineDataModel = myList.get(position);

        img.setImageDrawable(context.getResources().getDrawable(timelineDataModel.getImage()));
        tx1.setText(timelineDataModel.getEta());
        tx2.setText(timelineDataModel.getVenue());
        tx3.setText(timelineDataModel.getEvent());


        return view;

    }


}
