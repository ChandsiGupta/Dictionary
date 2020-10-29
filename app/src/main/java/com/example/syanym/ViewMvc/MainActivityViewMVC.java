package com.example.syanym.ViewMvc;

import android.content.Context;
import android.view.View;

public interface MainActivityViewMVC {
    Context getContext();
    
    View findViewById(int button);
    
    View getRootView();
    
}
