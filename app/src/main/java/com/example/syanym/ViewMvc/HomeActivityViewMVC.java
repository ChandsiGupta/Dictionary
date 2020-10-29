package com.example.syanym.ViewMvc;

import android.view.View;

import com.example.syanym.model.Dictionary;

import java.util.List;

public interface HomeActivityViewMVC {
    View getRootView();
    
    void bindData(List<Dictionary> wordsList, String fragmentType);
}
