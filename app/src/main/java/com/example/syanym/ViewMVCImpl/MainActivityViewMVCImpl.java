package com.example.syanym.ViewMVCImpl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.syanym.R;

import com.example.syanym.ViewMvc.MainActivityViewMVC;


public class MainActivityViewMVCImpl implements MainActivityViewMVC {
    View root;
    
    public MainActivityViewMVCImpl(LayoutInflater inflater, ViewGroup parent) {
        root = inflater.inflate(R.layout.activity_main, parent, false);
    }
    
    @Override
    public Context getContext() {
        return getRootView().getContext();
    }
    
    @Override
    public View findViewById(int button) {
        return getRootView().findViewById(button);
        
    }
    
    
    @Override
    public View getRootView() {
        return root;
    }
    
}
