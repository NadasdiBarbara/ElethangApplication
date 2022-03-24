package com.example.elethangapplication.cat;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elethangapplication.R;
import com.example.elethangapplication.RequestHandler;
import com.example.elethangapplication.Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatFragment extends Fragment {
    private class RequestTask extends AsyncTask<Void, Void, Response>{

        @Override
        protected Response doInBackground(Void... voids) {
            Response response = null;
            try {
                response = RequestHandler.get(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(Response response) {
            super.onPostExecute(response);
            if (response != null) {
                Gson converter = new Gson();
                Cat[] cats = converter.fromJson(response.getContent(), Cat[].class);
                catList.clear();
                catList.addAll(Arrays.asList(cats));
                catAdapter.setCatList(catList);
            }
        }
    }
    private RecyclerView recyclerView;
    private CatAdapter catAdapter;
    private List<Cat> catList;


    private String url = "http://10.148.149.41:8000/api/cat";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cat, container, false);
        init(view);
        recyclerView.setAdapter(catAdapter);
        return view;
    }

    public void init(View view){
        recyclerView = view.findViewById(R.id.recyclerViewCats);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        catList=new ArrayList<>();
        catAdapter= new CatAdapter(getContext(),catList);
        RequestTask task = new RequestTask();
        task.execute();
    }
}
