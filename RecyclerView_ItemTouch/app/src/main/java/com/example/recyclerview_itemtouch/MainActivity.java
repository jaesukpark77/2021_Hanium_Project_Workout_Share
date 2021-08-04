package com.example.recyclerview_itemtouch;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    ListAdapter adapter;
    ItemTouchHelper helper;
    private Button btnAdd, btnMinus;
    private TextView tvCount;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rv = findViewById(R.id.rv);
        //RecyclerView의 레이아웃 방식을 지정
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);

        //RecyclerView의 Adapter 세팅
        adapter = new ListAdapter();
        rv.setAdapter(adapter);

        //ItemTouchHelper 생성
        helper = new ItemTouchHelper(new ItemTouchHelperCallback(adapter));
        //RecyclerView에 ItemTouchHelper 붙이기
        helper.attachToRecyclerView(rv);

        //Adapter에 데이터 추가
        Person person1 = new Person(R.drawable.image1,"파이리",1);
        Person person2 = new Person(R.drawable.image2,"피카츄",2);
        Person person3 = new Person(R.drawable.image3,"꼬부기",3);
        Person person4 = new Person(R.drawable.image4,"이상해씨",4);
        adapter.addItem(person1);
        adapter.addItem(person2);
        adapter.addItem(person3);
        adapter.addItem(person4);

        tvCount = findViewById(R.id.tv_count);
        tvCount.setText(count+"");
        btnAdd = findViewById(R.id.btn_add);
        btnMinus = findViewById(R.id.btn_minus);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                tvCount.setText(count+"");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                tvCount.setText(count+"");
            }
        });
    }
}

