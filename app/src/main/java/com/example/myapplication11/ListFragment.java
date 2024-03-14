package com.example.myapplication11;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {


    public ListFragment() {
        super(R.layout.fragment_list);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Toast.makeText(getContext(), "ListView", Toast.LENGTH_LONG).show();
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ListView listView = view.findViewById(R.id.listView);
        List<Item> listItems = new ArrayList<>();
        for(int i = 0; i < 200; i ++){
            listItems.add(new Item(R.drawable.clock, String.valueOf(i+1)));
        }
        ListAdapter adapter = new ListAdapter(getContext(), R.layout.list_item, listItems);
        listView.setAdapter(adapter);
        view.findViewById(R.id.returnFromList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, new StartFragment()).addToBackStack(null).commit();
            }
        });
        return view;
    }
}