package com.example.vudang.fitness.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.vudang.fitness.Apdater.ItemDetailAdapter;
import com.example.vudang.fitness.Model.DBHandler;
import com.example.vudang.fitness.Model.Exersice;
import com.example.vudang.fitness.Model.ItemDetail;
import com.example.vudang.fitness.Model.ItemExersice;
import com.example.vudang.fitness.Model.SubExersise;
import com.example.vudang.fitness.R;

import java.util.ArrayList;

/**
 * Created by TU on 5/12/2017.
 */

public class DetailActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DBHandler db;
    Context context;
    ArrayList<ItemExersice> arrayList=new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_detail);
        context=getApplicationContext();
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String id=bundle.getString("id");
        System.out.println("ID : "+id);
        initView(id);
    }
    public void initView(String id){
        db=new DBHandler(context);
        String[] split = id.split(",");
        ArrayList list_item = new ArrayList();
        for(int i=0;i<split.length;i++){
            SubExersise ex = db.getItemExersiseByID(Integer.parseInt(split[i]));
            list_item.add(ex);
        }
        recyclerView=(RecyclerView) findViewById(R.id.exercise_detail);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        ItemDetailAdapter itemDetailAdapter=new ItemDetailAdapter(list_item,getApplicationContext());
        recyclerView.setAdapter(itemDetailAdapter);
    }
//    public void initView(){
//        recyclerView=(RecyclerView) findViewById(R.id.exercise_detail);
//        recyclerView.setHasFixedSize(true);
//        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(layoutManager);
//        arrayList.add(new ItemDetail(R.drawable.fitness1,"Russian Twist"));
//        arrayList.add(new ItemDetail(R.drawable.fitness2,"Side Plank"));
//        arrayList.add(new ItemDetail(R.drawable.fitness3,"Medicine Ball Slam"));
//        arrayList.add(new ItemDetail(R.drawable.fitness4,"Medicine Ball V-Up"));
//        arrayList.add(new ItemDetail(R.drawable.fitness5,"Medicine Ball Toe Touch"));
//        arrayList.add(new ItemDetail(R.drawable.demogif,"Puncher's Push Up"));
//        ItemDetailAdapter itemDetailAdapter=new ItemDetailAdapter(arrayList,getApplicationContext());
//        recyclerView.setAdapter(itemDetailAdapter);
//    }
}
