package com.example.vudang.fitness.Activity;


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.vudang.fitness.R;

import java.io.File;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExersiceFragment extends Fragment {

    TextView txt_countdown,text_exersice;
    ImageView view_exersice;
    MediaPlayer mp;
    static int id_exersice;
    static ArrayList<String> list_image = new ArrayList<>();
    String text_exer;
    public ExersiceFragment(ArrayList list) {
        this.id_exersice = 0;
        this.list_image = list;

        // Required empty public constructor
    }

    public ExersiceFragment(int id_exersice, String text) {
        this.id_exersice = id_exersice;
        this.text_exer = text;
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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exersice, container, false);
        txt_countdown = (TextView) rootView.findViewById(R.id.txt_countdown);
        text_exersice = (TextView) rootView.findViewById(R.id.text_exersice);
        mp = MediaPlayer.create(this.getActivity(),R.raw.track1);
        mp.start();
        String text = getContext().getPackageName();
        text_exersice.setText("Hello"+id_exersice);
        int imageKey = getResources().getIdentifier(list_image.get(id_exersice), "drawable", getContext().getPackageName());
        view_exersice =(ImageView) rootView.findViewById(R.id.image_exersice);
       view_exersice.setImageResource(imageKey);
        new CountDownTimer(31000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                txt_countdown.setText(""+millisUntilFinished/1000);
//
            }

            public void onFinish() {
                mp.stop();
                RestFragment fragment = null;
                if(id_exersice == list_image.size()-1){
                    txt_countdown.setText("done!");
                    return;
                }
                id_exersice = id_exersice + 1;
                Drawable img = getResources().getDrawable(R.drawable.fitness);
                String pathImage = img.toString();
                String path = Environment.getExternalStorageDirectory()+File.separator+ "/Images/test.jpg";
                fragment = new RestFragment(id_exersice,path);

                if (fragment != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.commit();

               //     set the toolbar title
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Rest");
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
