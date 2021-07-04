package org.techtown.smim_custom;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> implements OnExerciseClickListener {
    ArrayList<Exercise> items = new ArrayList<Exercise>();

    OnExerciseClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.exercise_list, viewGroup, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Exercise item = items.get(position);
        viewHolder.setItem(item);
        //viewHolder.view.setBackgroundColor(item.isSelected() ? Color.CYAN : Color.WHITE);
        //viewHolder.imageView1.setOnClickListener(new View.OnClickListener() {
         //   @Override
        //    public void onClick(View v) {
        //        item.setSelected(!item.isSelected());
        //        viewHolder.view.setBackgroundColor(item.isSelected() ? Color.CYAN : Color.WHITE);
        //    }
       // });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Exercise item) {
        items.add(item);
    }

    public void setItems(ArrayList<Exercise> items) {
        this.items = items;
    }

    public Exercise getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Exercise item) {
        items.set(position, item);
    }

    public void setOnItemClickListener(OnExerciseClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView textView1;
        TextView textView2;

        ImageView imageView1;

        public ViewHolder(View itemView, final OnExerciseClickListener listener) {
            super(itemView);

            view = itemView;
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);

            imageView1 = itemView.findViewById(R.id.imageView1);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null){
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });

        }
        //setItem 부분
        public void setItem(Exercise item) {
            textView1.setText(String.valueOf(item.getName()));
            textView2.setText(item.getPart());
            imageView1.setImageResource(item.getImageRes());
        }

    }
}
