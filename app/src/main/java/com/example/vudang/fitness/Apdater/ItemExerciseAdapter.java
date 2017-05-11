package com.example.vudang.fitness.Apdater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vudang.fitness.Model.ItemExercise;
import com.example.vudang.fitness.R;

import java.util.ArrayList;

/**
 * Created by TU on 5/10/2017.
 */

public class ItemExerciseAdapter extends RecyclerView.Adapter<ItemExerciseAdapter.ViewHolder>{
    ArrayList<ItemExercise> itemExercises = new ArrayList<>();
    Context context;

    public ItemExerciseAdapter(ArrayList<ItemExercise> itemExercises, Context context) {
        this.itemExercises = itemExercises;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemView=layoutInflater.inflate(R.layout.item_select,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(""+itemExercises.get(position).getName());
        holder.txtDecription.setText(""+itemExercises.get(position).getDecription());
        holder.imgHinh.setImageResource(itemExercises.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return itemExercises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        TextView txtDecription;
        ImageView imgHinh;
        public ViewHolder(View itemView) {
            super(itemView);
            txtName=(TextView) itemView.findViewById(R.id.txt_nameExcersice);
            txtDecription=(TextView) itemView.findViewById(R.id.txt_decription);
            imgHinh=(ImageView) itemView.findViewById(R.id.imgHinh);
        }
    }
}
