package com.example.vudang.fitness.Apdater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vudang.fitness.Model.SubExersise;
import com.example.vudang.fitness.R;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by TU on 5/11/2017.
 */

public class ItemDetailAdapter extends RecyclerView.Adapter<ItemDetailAdapter.ViewHolder>{
    ArrayList<SubExersise> itemDetail = new ArrayList<>();
    Context context;

    public ItemDetailAdapter(ArrayList<SubExersise> itemDetail, Context context) {
        this.itemDetail = itemDetail;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemView=layoutInflater.inflate(R.layout.item_detail,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(""+itemDetail.get(position).getNameItemExersise());
        int imageKey = context.getResources().getIdentifier(itemDetail.get(position).getImage(), "drawable", context.getPackageName());
        holder.imgHinh.setImageResource(imageKey);
    }

    @Override
    public int getItemCount() {
        return itemDetail.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        GifImageView imgHinh;
        public ViewHolder(View itemView) {
            super(itemView);
            txtName=(TextView) itemView.findViewById(R.id.txt_nameDetail);
            imgHinh=(GifImageView) itemView.findViewById(R.id.imgdetail);
        }
    }
}
