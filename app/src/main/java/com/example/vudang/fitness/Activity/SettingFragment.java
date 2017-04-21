package com.example.vudang.fitness.Activity;

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
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.vudang.fitness.R;

/**

 */
public class SettingFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private SeekBar bar_time_burning, bar_break_time;
    private TextView txt_time_buring, txt_break_time;

    public SettingFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_setting, container, false);
        bar_time_burning = (SeekBar) rootView.findViewById(R.id.seekBar_time);
        txt_time_buring = (TextView) rootView.findViewById(R.id.txt_time);
        txt_time_buring.setText("30");
        bar_break_time = (SeekBar) rootView.findViewById(R.id.seekBar_breaktime);
        txt_break_time = (TextView) rootView.findViewById(R.id.txt_breaktime);
        txt_break_time.setText("10");
        bar_time_burning.setOnSeekBarChangeListener(this);
        bar_time_burning.setProgress(30);
        bar_break_time.setProgress(10);
        bar_break_time.setOnSeekBarChangeListener(this);
        bar_time_burning.setProgress(30);
        bar_break_time.setProgress(10);
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
    int process = 0;
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        switch (seekBar.getId()) {
            case R.id.seekBar_time:
                process = i;
                txt_time_buring.setText(""+i);
//                TextView t = (TextView) getActivity().findViewById(R.id.txt_time);
//                t.setText(process);
                break;
            case R.id.seekBar_breaktime:
                txt_break_time.setText(""+i);
                //txt_break_time.setText(process);
               // txt_break_time.setText(process);
                break;
            default:break;
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
