package com.example.vudang.fitness.Activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.vudang.fitness.Model.DBHandler;
import com.example.vudang.fitness.Model.Exersice;
import com.example.vudang.fitness.Model.SubExersise;
import com.example.vudang.fitness.R;

import java.util.ArrayList;
import java.util.Collections;


public class HomeFragment extends Fragment {
    public HomeFragment() {

    }
    public HomeFragment(Exersice ex) {
        this.exersice = ex;
        // Required empty public constructor
    }
    Exersice exersice;
    private ImageButton btn_play;
    private Button btn_exersise;
    private View containerView;
    private FragmentDrawer.FragmentDrawerListener drawerListener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void setDrawerListener(FragmentDrawer.FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }
    DBHandler db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
//        if(exersice == null){
//            db = new DBHandler(getActivity());
//            exersice = db.getExersiceByID(1);
//        }

        btn_exersise = (Button)rootView.findViewById(R.id.btn_exersice);
        btn_exersise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectFragment fragment = new SelectFragment();

                if (fragment != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment).addToBackStack("fragBack");
                    fragmentTransaction.commit();

                    // set the toolbar title
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Exersise");
                }
            }
        });
        btn_exersise.setText(""+exersice.getNameExersice());
        btn_play = (ImageButton) rootView.findViewById(R.id.btn_play);
        btn_play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                RestFragment fragment = null;
                String list_itemExersice = exersice.getListIDItemExersice();
                String[] split = list_itemExersice.split(",");
                ArrayList list_item = new ArrayList();
                for(int i=0;i<split.length;i++){
                    SubExersise ex = db.getItemExersiseByID(Integer.parseInt(split[i]));
                    list_item.add(ex);
                }
                fragment = new RestFragment(list_item);

                if (fragment != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment).addToBackStack("fragBack");
                    fragmentTransaction.commit();

                    // set the toolbar title
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Excercise");
                }
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        db = new DBHandler(activity);
        exersice = db.getExersiceByID(1);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
