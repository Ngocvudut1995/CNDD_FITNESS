package com.example.vudang.fitness.Apdater;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vudang.fitness.Model.ItemCreate;
import com.example.vudang.fitness.R;

import java.util.ArrayList;

/**
 * Created by PC on 5/13/2017.
 */

public class ItemCreateAdapter extends RecyclerView.Adapter<ItemCreateAdapter.ViewHolder> {
    ArrayList<ItemCreate> itemCreate;
    Context context;
    public ItemCreateAdapter(ArrayList<ItemCreate> itemCreate, Context context) {
        this.itemCreate = itemCreate;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_create,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtnameCreate.setText(itemCreate.get(position).getTxtNameCreate());
        holder.imgHinhCreate.setImageResource(itemCreate.get(position).getImageCreate());
        holder.checkboxCreate.setChecked(itemCreate.get(position).getCheckboxCreate());

    }

    @Override
    public int getItemCount() {
        return itemCreate.size();
    }

    public void ClickItem(int position){
        itemCreate.add(position, itemCreate.get(position));
        notifyItemChanged(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtnameCreate;
        ImageView imgHinhCreate;
        CheckBox checkboxCreate;
        public ViewHolder(View itemView){
            super(itemView);
            txtnameCreate = (TextView) itemView.findViewById(R.id.txtnameCreate);
            imgHinhCreate = (ImageView) itemView.findViewById(R.id.imgHinhCreate);
            checkboxCreate = (CheckBox) itemView.findViewById(R.id.checkboxCreate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ClickItem(getAdapterPosition());
                    Toast.makeText(context,"Click bai tap",Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
