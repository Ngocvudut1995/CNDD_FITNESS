package com.example.vudang.fitness.Activity;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vudang.fitness.Apdater.ItemExerciseAdapter;
import com.example.vudang.fitness.Model.DBHandler;
import com.example.vudang.fitness.Model.Exersice;
import com.example.vudang.fitness.R;

import java.util.ArrayList;


public class SelectFragment extends android.support.v4.app.Fragment {
    public SelectFragment() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    TextView txtName;
    DBHandler db;

    private ArrayList<Exersice> exersicesList=new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.framgment_select, container, false);
        txtName=(TextView) rootView.findViewById(R.id.txt_nameExcersice);
        recyclerView=(RecyclerView) rootView.findViewById(R.id.select_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        exersicesList=(ArrayList<Exersice>) db.getAllExersice();
        //System.out.println(exersicesList.get(0).getIDExersice());
        ItemExerciseAdapter itemDetailAdapter=new ItemExerciseAdapter(exersicesList,getActivity().getApplicationContext(),getFragmentManager());
        recyclerView.setAdapter(itemDetailAdapter);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        db=new DBHandler(activity);
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
