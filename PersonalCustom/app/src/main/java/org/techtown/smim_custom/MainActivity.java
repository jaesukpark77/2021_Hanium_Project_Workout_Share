package org.techtown.smim_custom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Exercise> mExerciseList;
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;

    RecyclerView recyclerView;
    ExerciseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ExerciseAdapter adapter = new ExerciseAdapter();

        adapter.addItem(new Exercise("푸시업", "가슴", R.drawable.push_up));
        adapter.addItem(new Exercise("풀업", "등", R.drawable.pull_up));
        adapter.addItem(new Exercise("플랭크", "복부", R.drawable.plank));
        adapter.addItem(new Exercise("덤벨 숄더 프레스", "어깨", R.drawable.dumbbell_shoulder_press));
        adapter.addItem(new Exercise("덤벨 레터럴 레이즈", "어깨", R.drawable.dumbbell_lateral_raise));
        adapter.addItem(new Exercise("벤트오버 덤벨 레터럴 레이즈", "어깨", R.drawable.dumbbell_bentover_lateral_raise));
        adapter.addItem(new Exercise("덤벨 컬", "팔(이두)", R.drawable.dumbbell_curl));
        adapter.addItem(new Exercise("덤벨 삼두 익스텐션", "팔(삼두)", R.drawable.triceps_dumbbell_extension));
        adapter.addItem(new Exercise("에어 스쿼트", "하체", R.drawable.squat));
        adapter.addItem(new Exercise("덤벨 런지", "하체", R.drawable.dumbbell_lunge));


        recyclerView.setAdapter(adapter);


        Button imageButton = (Button) findViewById(R.id.customplan);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExerciseMerge.class);
                startActivity(intent);
            }
        });





    }
}