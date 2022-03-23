package com.example.elethangapplication.cat;

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

import java.util.ArrayList;
import java.util.List;

public class CatFragment extends Fragment {
    private RecyclerView recyclerView;
    private CatAdapter catAdapter;
    private List<Cat> catList;

    private String url = "http://10.0.2.2:8000/api/cat";
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
        catList.add(new Cat("Cica", "Cicsssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        catList.add(new Cat("Cica", "Cicsssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        catList.add(new Cat("Cica", "Cicsssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        catList.add(new Cat("Cica", "Cicsssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        catList.add(new Cat("Cica", "Cicsssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        catAdapter= new CatAdapter(getContext(),catList);
    }
}
