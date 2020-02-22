package com.ieeecs.arcs20;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {
    View v;
    private RecyclerView myrecyclerview;
    private RecyclerView myrecyclerview1;

    private List<Event> lstevent;
    private List<Combo_prof> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_profile, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.recyclerview2);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstevent);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        myrecyclerview.setAdapter(recyclerViewAdapter);

        myrecyclerview1 = (RecyclerView) v.findViewById(R.id.recyclerview1);
        RecyclerViewAdapter_combo recyclerViewAdapter_combo = new RecyclerViewAdapter_combo(getContext(),list);
        myrecyclerview1.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        myrecyclerview1.setAdapter(recyclerViewAdapter_combo);

        return v;
    }
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstevent = new ArrayList<>();
        lstevent.add(new Event("UI/UX", "SJT523", R.drawable.one, R.drawable.gradient_timeline));
        lstevent.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.two, R.drawable.gradient_timeline));
        lstevent.add(new Event("MACHINE LEARNING", "TT 413", R.drawable.three, R.drawable.gradient_timeline));
        lstevent.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.four, R.drawable.gradient_timeline));
        lstevent.add(new Event("UI/UX", "SJT523", R.drawable.one, R.drawable.gradient_timeline));
        lstevent.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.two, R.drawable.gradient_timeline));
        lstevent.add(new Event("MACHINE LEARNING", "TT 413", R.drawable.three, R.drawable.gradient_timeline));
        lstevent.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.four, R.drawable.gradient_timeline));

        list=new ArrayList<>();
        list.add((new Combo_prof("Combo1","UI/UX","ML",10,11)));
        list.add((new Combo_prof("Combo2","UI/UX","CONVOKE",10,11)));

    }

}
