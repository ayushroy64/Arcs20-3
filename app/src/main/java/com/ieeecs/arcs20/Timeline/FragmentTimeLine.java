package com.ieeecs.arcs20.Timeline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;


import com.ieeecs.arcs20.DayOneAdapter;
import com.ieeecs.arcs20.NonScrollListView;
import com.ieeecs.arcs20.R;
import com.ieeecs.arcs20.TimelineDataModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentTimeLine extends Fragment {

    List<TimelineDataModel> timelineList, timelineList1;
    ListView listView1, listView2, listView3;


    NonScrollListView nonScrollListView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_time_line, container, false);

        timelineList = new ArrayList<>();
        timelineList1 = new ArrayList<>();
        listView1 = view.findViewById(R.id.timeline_list_view_one);
        listView2 = view.findViewById(R.id.timeline_list_view_two);
        listView3 = view.findViewById(R.id.timeline_list_view_three);


        timelineList.add(new TimelineDataModel(R.drawable.ic_rectangle_purple, "12 pm", "UI/UX", "SJT301"));
        timelineList.add(new TimelineDataModel(R.drawable.ic_rectangle_purple, "1 pm", "UI", "SJT302"));
        timelineList.add(new TimelineDataModel(R.drawable.ic_rectangle_purple, "2 pm", "UI/UX", "SJT303"));


        timelineList1.add(new TimelineDataModel(R.drawable.ic_rectangle_purple, "12 pm", "UI/UX", "SJT304"));
        timelineList1.add(new TimelineDataModel(R.drawable.ic_rectangle_purple, "12 pm", "UI/UX", "SJT305"));
        timelineList1.add(new TimelineDataModel(R.drawable.ic_rectangle_purple, "12 pm", "UI/UX", "SJT306"));


        DayOneAdapter adapter = new DayOneAdapter(getActivity(), R.layout.day_one_adapter, timelineList);

        listView1.setAdapter(adapter);
        listView2.setAdapter(adapter);
        listView3.setAdapter(adapter);



        return view;


    }
}
