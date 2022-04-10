package com.example.elethangapplication.cat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elethangapplication.R;
import com.example.elethangapplication.RequestHandler;
import com.example.elethangapplication.Response;

import java.io.IOException;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatHolder> {
    Context context;
    List<Cat>catList;

    private String url = "http://10.0.2.2:8000/api/catAdoptionLoggedin/";

    public CatAdapter(Context context, List<Cat> catList) {
        this.context = context;
        this.catList = catList;
    }

    public void setCatList(List<Cat> catList) {
        this.catList = catList;
        notifyDataSetChanged();
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
        Cat cat = catList.get(position);

        holder.btnadoption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences= context.getSharedPreferences("token", Context.MODE_PRIVATE);
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setPositiveButton("Virtuális örökbefogadás", (dialogInterface, i) -> {
                    AsyncTask<Void, Void, Response> task = new AsyncTask<Void, Void, Response>() {
                        @Override
                        protected Response doInBackground(Void... voids) {
                            Response response = null;
                            try {
                                response = RequestHandler.postAuth(url+ cat.id,"{\"adoption_type_id\":2}",sharedPreferences.getString("token",""));
                                Log.d("Response", response.getContent());
                            } catch (IOException e) {
                                Log.d("Response error", e.getMessage());
                            }
                            return response;
                        }
                    };
                    task.execute();
                });

                alert.setNegativeButton("Ált.örökbefogadás", (dialogInterface, i) -> {
                    AsyncTask<Void, Void, Response> task = new AsyncTask<Void, Void, Response>() {
                        @Override
                        protected Response doInBackground(Void... voids) {
                            Response response = null;
                            try {
                                response = RequestHandler.postAuth(url+ cat.id,"{\"adoption_type_id\":1}",sharedPreferences.getString("token",""));
                                Log.d("Response", response.getContent());
                            } catch (IOException e) {
                                Log.d("Response error", e.getMessage());
                            }
                            return response;
                        }
                    };
                    task.execute();
                });
                alert.create().show();
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
        Button btnadoption;

        public CatHolder(@NonNull View itemView) {
            super(itemView);
            catName = itemView.findViewById(R.id.catName);
            description = itemView.findViewById(R.id.description);
            pictureCat = itemView.findViewById(R.id.pictureCat);
            btnadoption = itemView.findViewById(R.id.btnadoption);
        }
    }
}
