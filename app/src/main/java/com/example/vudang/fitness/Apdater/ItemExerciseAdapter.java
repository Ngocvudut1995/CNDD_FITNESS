package com.example.vudang.fitness.Apdater;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vudang.fitness.Activity.DetailActivity;
import com.example.vudang.fitness.Activity.FriendFragment;
import com.example.vudang.fitness.Activity.ListExersiseFragment;
import com.example.vudang.fitness.Activity.RestFragment;
import com.example.vudang.fitness.MainActivity;
import com.example.vudang.fitness.Model.DBHandler;
import com.example.vudang.fitness.Model.Exersice;
import com.example.vudang.fitness.Model.ItemExercise;
import com.example.vudang.fitness.Model.SubExersise;
import com.example.vudang.fitness.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TU on 5/10/2017.
 */

public class ItemExerciseAdapter extends RecyclerView.Adapter<ItemExerciseAdapter.ViewHolder>{
    private ArrayList<Exersice> itemExercises = new ArrayList<>();
    private Context context;
    private FragmentManager manager;

    public ItemExerciseAdapter(ArrayList<Exersice> itemExercises, Context context,FragmentManager manager) {
        this.itemExercises = itemExercises;
        this.context = context;
        this.manager = manager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemView=layoutInflater.inflate(R.layout.item_select,parent,false);

        return new ViewHolder(itemView,manager);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(""+itemExercises.get(position).getNameExersice());
        holder.txtDecription.setText(""+itemExercises.get(position).getListIDItemExersice());
        holder.imgHinh.setImageResource(R.drawable.fitness1);
    }

    @Override
    public int getItemCount() {
        return itemExercises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        TextView txtDecription;
        ImageView imgHinh;
        GridLayout item_layout;
        private  Context context;
        FragmentManager manage;
        public ViewHolder(View itemView, final FragmentManager manage) {
            super(itemView);
            this.manage = manage;
            txtName=(TextView) itemView.findViewById(R.id.txt_nameExcersice);
            txtDecription=(TextView) itemView.findViewById(R.id.txt_decription);
            imgHinh=(ImageView) itemView.findViewById(R.id.imgHinh);
            item_layout = (GridLayout) itemView.findViewById(R.id.item_layout);
            context = itemView.getContext();
            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        item_layout.setBackgroundColor(ContextCompat.getColor(context, R.color.windowBackground));

                    }
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        item_layout.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));

                    }

                    return false;
                }

            });

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    int i=getAdapterPosition();

                    Exersice exersice= itemExercises.get(i);
                    ListExersiseFragment fragment = new ListExersiseFragment(exersice);
                    if (fragment != null) {
                       // FragmentManager fragmentManager = activity.getFragmentManager();
                        FragmentTransaction fragmentTransaction = manage.beginTransaction();
                        fragmentTransaction.replace(R.id.container_body, fragment).addToBackStack("fragBack");
                        fragmentTransaction.commit();

                    }

                }
            });
        }

    }
}
