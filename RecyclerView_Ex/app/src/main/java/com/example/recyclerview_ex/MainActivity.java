package com.example.recyclerview_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText name_et,age_et;
    Button add_bt;
    RecyclerView rv;
    ListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_et = findViewById(R.id.name_et);
        age_et = findViewById(R.id.age_et);
        add_bt = findViewById(R.id.add_bt);
        add_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //EditText 입력된 값 가져오기
                String name = name_et.getText().toString();
                int age = Integer.parseInt(age_et.getText().toString());

                //이미지 값 세팅
                int image;
                switch (name){
                    case "파이리" :{
                    image = R.drawable.image1;
                    break;
                    }
                    case "피카츄" :{
                        image = R.drawable.image2;
                        break;
                    }
                    case "꼬부기" :{
                        image = R.drawable.image3;
                        break;
                    }
                    default: image = R.drawable.ic_launcher_background;
                }

                //Person 객체 생성, 값 세팅
                Person person = new Person();
                person.setName(name);
                person.setAge(age);
                person.setImage(image);

                //ListAdapter에 객체 추가
                adapter.addItem(person);
                adapter.notifyDataSetChanged();

                //EditText 초기화
                name_et.setText("");
                age_et.setText("");

                //데이터 추가 확인 토스트 띄우기
                Toast.makeText(MainActivity.this, "목록에 추가되었습니다", Toast.LENGTH_SHORT).show();
                name_et.requestFocus();

            }
        });


        rv = findViewById(R.id.rv);
        //RecyclerView의 레이아웃 방식을 지정
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);

        //RecyclerView의 Adapter 세팅
        adapter = new ListAdapter();
        rv.setAdapter(adapter);



    }
}