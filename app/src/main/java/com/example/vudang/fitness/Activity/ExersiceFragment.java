package com.example.vudang.fitness.Activity;


import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.vudang.fitness.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExersiceFragment extends Fragment {

    TextView txt_countdown;

    public ExersiceFragment() {
        // Required empty public constructor
    }


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
        View rootView = inflater.inflate(R.layout.activity_demo, container, false);
        txt_countdown = (TextView) rootView.findViewById(R.id.txt_countdown);
        new CountDownTimer(30000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                txt_countdown.setText(""+millisUntilFinished/1000);
//
            }

            public void onFinish() {
                ExersiceFragment fragment = null;
                fragment = new ExersiceFragment();

                if (fragment != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.commit();

               //     set the toolbar title
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Excercise");
               // txt_countdown.setText("done!");
            }
            }
        }.start();
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
