package com.ieeecs.arcs20;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView myrecyclerview;
    private RecyclerView myrecyclerview2;
    private RecyclerView myrecyclerview3;

    private List<Event> lstevent;
    private List<Event> lstevent2;
    private List<Event> lstevent3;

    private ImageView btn_timeline;
    private ImageView btn_convoke;
    private ImageView btn_workshop;

    View v;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);

        myrecyclerview = (RecyclerView) v.findViewById(R.id.recycler_view_timeline);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstevent);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        myrecyclerview.setAdapter(recyclerViewAdapter);

        myrecyclerview2 = (RecyclerView) v.findViewById(R.id.recycler_view_convoke);
        RecyclerViewAdapter recyclerViewAdapter2 = new RecyclerViewAdapter(getContext(),lstevent2);
        myrecyclerview2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        myrecyclerview2.setAdapter(recyclerViewAdapter2);

        myrecyclerview3 = (RecyclerView) v.findViewById(R.id.recycler_view_workshop);
        RecyclerViewAdapter recyclerViewAdapter3 = new RecyclerViewAdapter(getContext(), lstevent3);
        myrecyclerview3.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        myrecyclerview3.setAdapter(recyclerViewAdapter3);

        btn_timeline = v.findViewById(R.id.timeline_button);
        btn_convoke = v.findViewById(R.id.convoke_button);
        btn_workshop = v.findViewById(R.id.workshop_button);

        btn_timeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new FragmentTimeLine());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });




        btn_convoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new ConvokeFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btn_workshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new WorkshopFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

       /* TextView tv=v.findViewById(R.id.header);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });*/

        return v;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstevent = new ArrayList<>();
        lstevent.add(new Event("UI/UX","SJT523",R.drawable.one, R.drawable.gradient_timeline));
        lstevent.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.two, R.drawable.gradient_timeline));
        lstevent.add(new Event("MACHINE LEARNING", "TT 413", R.drawable.three, R.drawable.gradient_timeline));
        lstevent.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.four, R.drawable.gradient_timeline));
        lstevent.add(new Event("UI/UX","SJT523",R.drawable.one, R.drawable.gradient_timeline));
        lstevent.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.two, R.drawable.gradient_timeline));
        lstevent.add(new Event("MACHINE LEARNING", "TT 413", R.drawable.three, R.drawable.gradient_timeline));
        lstevent.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.four, R.drawable.gradient_timeline));

        lstevent2 = new ArrayList<>();
        lstevent2.add(new Event("UI/UX","SJT523",R.drawable.one, R.drawable.gradient_concoke));
        lstevent2.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.two,R.drawable.gradient_concoke));
        lstevent2.add(new Event("MACHINE LEARNING", "TT 413", R.drawable.three,R.drawable.gradient_concoke));
        lstevent2.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.four,R.drawable.gradient_concoke));
        lstevent2.add(new Event("UI/UX","SJT523",R.drawable.one,R.drawable.gradient_concoke));
        lstevent2.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.two, R.drawable.gradient_concoke));
        lstevent2.add(new Event("MACHINE LEARNING", "TT 413", R.drawable.three, R.drawable.gradient_concoke));
        lstevent2.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.four,R.drawable.gradient_concoke));

        lstevent3 = new ArrayList<>();
        lstevent3.add(new Event("UI/UX","SJT523",R.drawable.one, R.drawable.gradient_workshop));
        lstevent3.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.two, R.drawable.gradient_workshop));
        lstevent3.add(new Event("MACHINE LEARNING", "TT 413", R.drawable.three, R.drawable.gradient_workshop));
        lstevent3.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.four, R.drawable.gradient_workshop));
        lstevent3.add(new Event("UI/UX","SJT523",R.drawable.one, R.drawable.gradient_workshop));
        lstevent3.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.two, R.drawable.gradient_workshop));
        lstevent3.add(new Event("MACHINE LEARNING", "TT 413", R.drawable.three, R.drawable.gradient_workshop));
        lstevent3.add(new Event("CONVOKE", "ANNA AUDI", R.drawable.four, R.drawable.gradient_workshop));

    }


}
