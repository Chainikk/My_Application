package com.example.myapplication11;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RecyclerFragment extends Fragment {


    public RecyclerFragment() {
        super(R.layout.fragment_recycler);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        List<Item> listItems = new ArrayList<>();
        for(int i = 0; i < 200; i ++){
            listItems.add(new Item(R.drawable.clock, String.valueOf(i+1)));
        }
        RecycleAdapter adapter = new RecycleAdapter(getContext(), listItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        view.findViewById(R.id.returnFromRecycle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, new StartFragment()).addToBackStack(null).commit();
            }
        });
        return view;
    }

}