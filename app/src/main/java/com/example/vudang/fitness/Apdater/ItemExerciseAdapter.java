package com.example.vudang.fitness.Apdater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vudang.fitness.Activity.DetailActivity;
import com.example.vudang.fitness.Model.DBHandler;
import com.example.vudang.fitness.Model.Exersice;
import com.example.vudang.fitness.Model.ItemExercise;
import com.example.vudang.fitness.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TU on 5/10/2017.
 */

public class ItemExerciseAdapter extends RecyclerView.Adapter<ItemExerciseAdapter.ViewHolder>{
    private ArrayList<Exersice> itemExercises = new ArrayList<>();
    private Context context;

    public ItemExerciseAdapter(ArrayList<Exersice> itemExercises, Context context) {
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
        private final Context context;
        public ViewHolder(final View itemView) {
            super(itemView);
            txtName=(TextView) itemView.findViewById(R.id.txt_nameExcersice);
            txtDecription=(TextView) itemView.findViewById(R.id.txt_decription);
            imgHinh=(ImageView) itemView.findViewById(R.id.imgHinh);
            context= itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DBHandler db=new DBHandler(context);
                    int i=getAdapterPosition()+1;
                    Exersice exersice= db.getExersiceByID(i);
                    String str=exersice.getListIDItemExersice();
                    Intent intent=new Intent(context,DetailActivity.class);
                    intent.putExtra("id",str);
                    context.startActivity(intent);
                }
            });
        }

    }
}
