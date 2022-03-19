package com.example.elethangapplication.cat;

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

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatHolder> {
    Context context;
    List<Cat>catList;

    public CatAdapter(Context context, List<Cat> catList) {
        this.context = context;
        this.catList = catList;
    }


    @NonNull
    @Override
    public CatAdapter.CatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_cats, parent, false);
        return new CatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatAdapter.CatHolder holder, int position) {
        holder.catName.setText(catList.get(position).getCatName());
        holder.description.setText(catList.get(position).getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Kattintás "+holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    public static class CatHolder extends RecyclerView.ViewHolder{
        TextView catName;
        TextView description;
        ImageView pictureCat;

        public CatHolder(@NonNull View itemView) {
            super(itemView);
            catName = itemView.findViewById(R.id.catName);
            description = itemView.findViewById(R.id.description);
            pictureCat = itemView.findViewById(R.id.pictureCat);
        }
    }
}
