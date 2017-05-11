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

import com.example.vudang.fitness.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }
    private ImageButton btn_play;
    private View containerView;
    private FragmentDrawer.FragmentDrawerListener drawerListener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void setDrawerListener(FragmentDrawer.FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        btn_play = (ImageButton) rootView.findViewById(R.id.btn_play);
        btn_play.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                RestFragment fragment = null;
                String list__a = "R.drawable.fitness,R.drawable.ic_action_name";
                String[] split = list__a.split(",");
                ArrayList list_image = new ArrayList();
                list_image.add("fitness1");
                list_image.add("fitness2");
                list_image.add("fitness3");
                list_image.add("fitness4");
                list_image.add("fitness5");
                fragment = new RestFragment(list_image);

                if (fragment != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment);
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
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
