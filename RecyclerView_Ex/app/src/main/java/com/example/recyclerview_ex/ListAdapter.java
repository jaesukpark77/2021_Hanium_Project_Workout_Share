package com.example.recyclerview_ex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemViewHolder> {
    ArrayList<Person> items = new ArrayList<>();
    public ListAdapter(){
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)

    {
        //LayoutInflater를 이용해서 원하는 레이아웃을 띄워줍니다.
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        //ItemViewHolder가 생성되고 넣어야할 코드들을 넣어줍다.
        // 보통 onBind 함수 안에 모두 넣어줍니다.
        holder.onBind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Person person){
        //items에 Person객체 추가
        items.add(person);
        // 추가후 Adapter에 데이터가 변경된것을 알림
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView list_name,list_age;
        ImageView list_image;

        public ItemViewHolder(View itemView) {
            super(itemView);
            list_name = itemView.findViewById(R.id.list_name);
            list_age = itemView.findViewById(R.id.list_age);
            list_image = itemView.findViewById(R.id.list_image);
        }

        public void onBind(Person person) {
            list_name.setText(person.getName());
            list_age.setText(String.valueOf(person.getAge()));
            list_image.setImageResource(person.getImage());
        }
    }
}

