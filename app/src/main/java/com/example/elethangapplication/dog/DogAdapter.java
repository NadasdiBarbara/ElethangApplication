package com.example.elethangapplication.dog;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elethangapplication.R;
import com.example.elethangapplication.RequestHandler;
import com.example.elethangapplication.Response;

import java.io.IOException;
import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogHolder> {

    Context context;
    List<Dog> dogList;

    private String url = "http://10.0.2.2:8000/api/dogAdoptionLoggedin/";

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
        Dog dog = dogList.get(position);

        holder.btnDogAdoption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("token", Context.MODE_PRIVATE);
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setPositiveButton("Virtuális örökbefogadás", (dialogInterface, i) -> {
                    AsyncTask<Void, Void, Response> task = new AsyncTask<Void, Void, Response>(){
                        @Override
                        protected Response doInBackground(Void... voids) {
                            Response response = null;
                            try {
                                response = RequestHandler.postAuth(url+ dog.id,"{\"adoption_type_id\":2}",sharedPreferences.getString("token",""));
                                Log.d("Response", response.getContent());
                            } catch (IOException e) {
                                Log.d("Response error", e.getMessage());
                            }
                            return response;
                        }
                    };
                    task.execute();
                });
                alert.setNegativeButton("Általános Örökbefogadás", (dialogInterface, i) -> {
                    AsyncTask<Void, Void, Response> task = new AsyncTask<Void, Void, Response>(){
                        @Override
                        protected Response doInBackground(Void... voids) {
                            Response response = null;
                            try {
                                response = RequestHandler.postAuth(url+ dog.id,"{\"adoption_type_id\":1}",sharedPreferences.getString("token",""));
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
        return dogList.size();
    }

    public static class DogHolder extends RecyclerView.ViewHolder{

        TextView dogName;
        TextView dogDescription;
        ImageView dogimage;
        Button btnDogAdoption;
        public DogHolder(@NonNull View itemView) {
            super(itemView);
            dogName = itemView.findViewById(R.id.dogName);
            dogDescription = itemView.findViewById(R.id.dogDescription);
            dogimage = itemView.findViewById(R.id.pictureDog);
            btnDogAdoption = itemView.findViewById(R.id.btnDogadoption);
        }
    }
}
