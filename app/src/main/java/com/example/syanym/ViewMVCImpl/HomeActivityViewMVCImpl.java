package com.example.syanym.ViewMVCImpl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.syanym.R;
import com.example.syanym.adapter.RecyclerAdapter;
import com.example.syanym.model.Dictionary;

import java.util.List;

import com.example.syanym.ViewMvc.HomeActivityViewMVC;

public class HomeActivityViewMVCImpl implements HomeActivityViewMVC {
    View root;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    
    public HomeActivityViewMVCImpl(LayoutInflater inflater, ViewGroup parent) {
        root = inflater.inflate(R.layout.activity_home, parent, false);
    }
    
    private Context getContext() {
        return getRootView().getContext();
    }
    
    private View findViewById(int recycler_view) {
        return getRootView().findViewById(recycler_view);
        
    }
    
    
    @Override
    public View getRootView() {
        return root;
    }
    
    
    @Override
    public void bindData(List<Dictionary> wordsList, String fragmentType) {
        recyclerAdapter = new RecyclerAdapter(getContext(), wordsList,fragmentType);
        recyclerView.setAdapter(recyclerAdapter);
    }

}
