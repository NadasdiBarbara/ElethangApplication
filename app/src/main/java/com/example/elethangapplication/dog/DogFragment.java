package com.example.elethangapplication.dog;

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
import com.example.elethangapplication.cat.Cat;
import com.example.elethangapplication.cat.CatAdapter;

import java.util.ArrayList;
import java.util.List;

public class DogFragment extends Fragment {
    private RecyclerView recyclerView;
    private DogAdapter dogAdapter;
    private List<Dog> dogList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dog, container, false);
        init(view);
        recyclerView.setAdapter(dogAdapter);
        return view;
    }
    public void init(View view){
        recyclerView = view.findViewById(R.id.recyclerViewDogs);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        dogList=new ArrayList<>();
        dogList.add(new Dog("Kutya", "Kutyoooooooooooooooooooooooooooooooooooooooooooooooooo"));
        dogList.add(new Dog("Kutya", "Kutyoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"));
        dogList.add(new Dog("Kutya", "Kutyoooooooooooooooooooooooooooooooooooooooooooooooooo"));
        dogList.add(new Dog("Kutya", "Kutyoooooooooooooooooooooooooooooooooooooooooooooooooo"));
        dogList.add(new Dog("Kutya", "Kutyooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"));

        dogAdapter = new DogAdapter(getContext(), dogList);
    }

}
