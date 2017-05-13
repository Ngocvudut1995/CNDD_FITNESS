package com.example.vudang.fitness.Activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vudang.fitness.MainActivity;
import com.example.vudang.fitness.Model.DBHandler;
import com.example.vudang.fitness.Model.ItemExercise;
import com.example.vudang.fitness.Model.MyApp;
import com.example.vudang.fitness.Model.SubExersise;
import com.example.vudang.fitness.R;

import java.io.File;
import java.util.ArrayList;


public class RestFragment extends Fragment {

    static int id_exersice;
    static ArrayList<SubExersise> list_item = new ArrayList<>();
    SubExersise ex;
    public RestFragment(ArrayList<SubExersise> list) {
        // Required empty public constructor
        this.id_exersice =0;
        this.list_item = list;
        ex = list_item.get(id_exersice);
        ExersiseFragment fragment = new ExersiseFragment(list.size());
    }

    public RestFragment(int id_exersice) {
        this.id_exersice = id_exersice;
        ex = list_item.get(id_exersice);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    TextView number_text;
    Button button_coundown,btn_exersice;
    ImageView view_exersice;
    MediaPlayer mp;
    MyApp myapp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_rest, container, false);

        myapp = (MyApp) getActivity().getApplicationContext();
        button_coundown = (Button) rootView.findViewById(R.id.button_coundown);
        number_text = (TextView) rootView.findViewById(R.id.number_text);
        btn_exersice = (Button) rootView.findViewById(R.id.btn_exersice);
        mp = MediaPlayer.create(this.getActivity(),R.raw.track1);
        //mp.start();
        String text = getContext().getPackageName();
        number_text.setText(""+(id_exersice+1)+"/"+list_item.size());
        btn_exersice.setText(""+ex.getNameItemExersise());
        int imageKey = getResources().getIdentifier(""+ex.getImage(), "drawable", getContext().getPackageName());
        view_exersice =(ImageView) rootView.findViewById(R.id.imageView);
        view_exersice.setImageResource(imageKey);
        new CountDownTimer(myapp.getSetting().getTime_break()*1000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                button_coundown.setText(""+millisUntilFinished/1000);
            }

            public void onFinish() {
                mp.stop();

                ExersiseFragment fragment = null;
                Drawable img = getResources().getDrawable(R.drawable.fitness1);
                String pathImage = img.toString();
                String path = Environment.getExternalStorageDirectory()+ File.separator+ "/Images/test.jpg";
                fragment = new ExersiseFragment(id_exersice,ex);
                if (fragment != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.commit();
                    //     set the toolbar title
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Exersice");
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
