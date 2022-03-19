package com.example.elethangapplication.esemenyek;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elethangapplication.R;


public class EsemenyekFragment extends Fragment {
    String[] felsorolas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_esemenyek, container, false);


        return view;
    }
}