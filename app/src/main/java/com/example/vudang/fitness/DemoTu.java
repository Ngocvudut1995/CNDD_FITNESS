package com.example.vudang.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vudang.fitness.Activity.DetailActivity;
import com.example.vudang.fitness.Apdater.ItemExerciseAdapter;
import com.example.vudang.fitness.Model.DBHandler;
import com.example.vudang.fitness.Model.Exersice;
import com.example.vudang.fitness.Model.ItemExercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TU on 5/12/2017.
 */

public class DemoTu extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView txtName;
    DBHandler db;
//    private ArrayList<ItemExercise> arrayList=new ArrayList<>();
    private ArrayList<Exersice> exersicesList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framgment_select);
        txtName=(TextView) findViewById(R.id.txt_nameExcersice);
        initView();
    }
    public void initView(){
        recyclerView=(RecyclerView) findViewById(R.id.select_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        db=new DBHandler(this);
        exersicesList=(ArrayList<Exersice>) db.getAllExersice();
        //System.out.println(exersicesList.get(0).getIDExersice());
      //  ItemExerciseAdapter itemDetailAdapter=new ItemExerciseAdapter(exersicesList,getApplicationContext());
       // recyclerView.setAdapter(itemDetailAdapter);

    }
//    public void initView(){
//        recyclerView=(RecyclerView) findViewById(R.id.select_view);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager layoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(layoutManager);
//        arrayList=new ArrayList<>();
//        arrayList.add(new ItemExercise(R.drawable.fitness1,"Russian Twist","Giam mo hieu qua"));
//        arrayList.add(new ItemExercise(R.drawable.fitness2,"Side Plank","Giam mo hieu qua"));
//        arrayList.add(new ItemExercise(R.drawable.fitness3,"Medicine Ball Slam","Giam mo hieu qua"));
//        arrayList.add(new ItemExercise(R.drawable.fitness4,"Medicine Ball V-Up","Giam mo hieu qua"));
//        arrayList.add(new ItemExercise(R.drawable.fitness5,"Medicine Ball Toe Touch","Giam mo hieu qua"));
//        arrayList.add(new ItemExercise(R.drawable.demogif,"Puncher's Push Up","Giam mo hieu qua"));
//        ItemExerciseAdapter itemDetailAdapter=new ItemExerciseAdapter(arrayList,getApplicationContext());
//        recyclerView.setAdapter(itemDetailAdapter);
//    }
    public void getDetail(View view){
        Intent intent=new Intent(this, DetailActivity.class);
        txtName.getText();
        System.out.println(txtName.getText());
        startActivity(intent);
    }
}
