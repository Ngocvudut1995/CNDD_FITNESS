package com.example.vudang.fitness;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.SeekBar;
import android.widget.TextView;

<<<<<<< HEAD
import com.example.vudang.fitness.Model.DBHandler;
import com.example.vudang.fitness.Model.Exersice;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoActivity extends AppCompatActivity {
   // private Chronometer chronometer;
    TextView txt_countdown;
    private static final String FORMAT = "%02d";

    int seconds , minutes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_demo);
//      txt_countdown = (TextView) findViewById(R.id.txt_countdown);
//        new CountDownTimer(30000, 1000) { // adjust the milli seconds here
//
//            public void onTick(long millisUntilFinished) {
//                txt_countdown.setText(""+millisUntilFinished/1000);
////                txt_countdown.setText(""+String.format(FORMAT,
////                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
////                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
////                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
////                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
////                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
//            }
//
//            public void onFinish() {
//                txt_countdown.setText("done!");
//            }
//        }.start();
        DBHandler db = new DBHandler(this);
        // Reading all shops
        //db.addExersice(new Exersice(0,"Full Body","1,2,3,4,5"));
      //  db.addExersice(new Exersice(0,"Stretch Easy","1,2,3,4,5"));
        Log.d("Reading: ", "Reading all shops..");
        List<Exersice> list = db.getAllExersice();

        for (Exersice item : list) {
            String log = "Id: " + item.getIDExersice() + " ,Name: " + item.getNameExersice() + " ,Address: " + item.getListIDItemExersice();
// Writing shops to log
            Log.d("Exersice: : ", log);
        }
=======
import com.example.vudang.fitness.Apdater.ItemExerciseAdapter;
import com.example.vudang.fitness.Model.ItemExercise;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DemoActivity extends AppCompatActivity {
    RecyclerView recyclerView;
   @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.framgment_select);
       initView();
   }
    public void initView(){
        recyclerView=(RecyclerView) findViewById(R.id.select_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<ItemExercise> arrayList=new ArrayList<>();
        arrayList.add(new ItemExercise(R.drawable.output_zczmrt,"Russian Twist","Một bài tập tuyệt vời cho cơ bụng. Nó cũng thúc đẩy các cơ bắp khác hoạt động. Nếu bạn vẫn còn là một người mới bắt đầu hoặc không có sức khoẻ và độ bền cơ bắp bài tập này sẽ giúp bạn thúc đẩy sức khỏe, kích thích việc ăn uống giúp bạn tăng cân và xây dựng cơ bắp như ý muốn."));
        arrayList.add(new ItemExercise(R.drawable.sideplank_only,"Side Plank","Bài tập này là vũ khí bí mật giúp thắt chặt vòng eo của bạn. Nó hoạt động vào các cơ bắp nằm sâu dưới bụng."));
        arrayList.add(new ItemExercise(R.drawable.output,"Medicine Ball Slam","Đây là một bài tập đơn giản và dễ dàng thực hiện"));
        arrayList.add(new ItemExercise(R.drawable.output_3rd,"Medicine Ball V-Up","Đây là một bài tập thể dục tăng cường nhắm vào toàn bộ khu vực cốt lõi, nhấn mạnh vào các cơ bụng dưới và hông."));
        arrayList.add(new ItemExercise(R.drawable.output_4,"Medicine Ball Toe Touch","Đây là động tác dễ dàng đối với hầu hết phụ nữ. Nếu bạn muốn nhìn thấy kết quả tốt hơn và một bài tập tác động đến toàn bộ cơ thể đây là động tác phù hợp. "));
        arrayList.add(new ItemExercise(R.drawable.output_8,"Puncher's Push Up","Giữ cơ bụng của bạn để ổn định cơ thể. Đây là biến thể của động tác chống đẩy giúp thúc đẩy những cơ bắp cốt lõi."));
        ItemExerciseAdapter itemExerciseAdapter=new ItemExerciseAdapter(arrayList,getApplicationContext());
        recyclerView.setAdapter(itemExerciseAdapter);
>>>>>>> origin/master
    }


}
