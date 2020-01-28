package com.example.arcs20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentTimeLine extends Fragment {

    List<TimelineDataModel> timelineList;
    ListView listView1, listView2, listView3;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_time_line, container, false);

        timelineList=new ArrayList<>();
        listView1=view.findViewById(R.id.timeline_list_view_one);
        listView2=view.findViewById(R.id.timeline_list_view_two);
        listView3=view.findViewById(R.id.timeline_list_view_three);

        timelineList.add(new TimelineDataModel(R.drawable.ic_rectangle,"12 pm", "UI/UX", "SJT301"));
        timelineList.add(new TimelineDataModel(R.drawable.ic_rectangle,"12 pm", "UI/UX", "SJT301"));
        timelineList.add(new TimelineDataModel(R.drawable.ic_rectangle,"12 pm", "UI/UX", "SJT301"));


        DayOneAdapter adapter = new DayOneAdapter(getActivity(),R.layout.day_one_adapter,timelineList);

        listView1.setAdapter(adapter);
        listView2.setAdapter(adapter);
        listView3.setAdapter(adapter);






        return  view;



    }
}
