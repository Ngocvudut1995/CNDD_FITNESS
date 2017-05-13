package com.example.vudang.fitness.Activity;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vudang.fitness.Apdater.ItemDetailAdapter;
import com.example.vudang.fitness.Model.DBHandler;
import com.example.vudang.fitness.Model.Exersice;
import com.example.vudang.fitness.Model.SubExersise;
import com.example.vudang.fitness.R;

import java.util.ArrayList;


public class ListExersiseFragment extends android.support.v4.app.Fragment {
    Exersice exersice;
    RecyclerView recyclerView;
    DBHandler db;
    public ListExersiseFragment() {
        // Required empty public constructor
    }
    public ListExersiseFragment(Exersice ex) {
      this.exersice = ex;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.exercise_detail, container, false);
        ArrayList list_item = new ArrayList();
        String[] split = exersice.getListIDItemExersice().split(",");
        for(int i=0;i<split.length;i++){
            SubExersise ex = db.getItemExersiseByID(Integer.parseInt(split[i]));
            list_item.add(ex);
        }
        recyclerView=(RecyclerView) rootView.findViewById(R.id.exercise_detail);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        ItemDetailAdapter itemDetailAdapter=new ItemDetailAdapter(list_item,getActivity().getApplicationContext());
        recyclerView.setAdapter(itemDetailAdapter);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        db = new DBHandler(activity);
        ((AppCompatActivity)activity).getSupportActionBar().setTitle(""+exersice.getNameExersice());
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
