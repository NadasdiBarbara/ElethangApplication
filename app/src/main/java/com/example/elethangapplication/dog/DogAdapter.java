package com.example.elethangapplication.dog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elethangapplication.R;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogHolder> {

    Context context;
    List<Dog> dogList;

    public DogAdapter(Context context, List<Dog> dogList) {
        this.context = context;
        this.dogList = dogList;
    }
    public void setDogList(List<Dog> dogList){
        this.dogList = dogList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DogAdapter.DogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_dogs, parent, false);
        return new DogHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogAdapter.DogHolder holder, int position) {
        holder.dogName.setText(dogList.get(position).getDogName());
        holder.dogDescription.setText(dogList.get(position).getDogDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Kattaintás "+holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }

    public static class DogHolder extends RecyclerView.ViewHolder{

        TextView dogName;
        TextView dogDescription;
        ImageView dogimage;
        public DogHolder(@NonNull View itemView) {
            super(itemView);
            dogName = itemView.findViewById(R.id.dogName);
            dogDescription = itemView.findViewById(R.id.dogDescription);
            dogimage = itemView.findViewById(R.id.pictureDog);
        }
    }
}
