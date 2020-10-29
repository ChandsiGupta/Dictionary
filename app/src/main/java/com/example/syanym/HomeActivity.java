package com.example.syanym;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Objects;

import com.example.syanym.ViewMvc.HomeActivityViewMVC;
import com.example.syanym.ViewMVCImpl.HomeActivityViewMVCImpl;

public class HomeActivity extends AppCompatActivity {
    private Fragment fragment;
    HomeActivityViewMVC homeActivityViewMVC;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeActivityViewMVC = new HomeActivityViewMVCImpl(LayoutInflater.from(this), null);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setContentView(homeActivityViewMVC.getRootView());
        openFragment();
    }
    
    private void openFragment() {
        Intent intent = getIntent();
        String type = intent.getStringExtra("TYPE");
        assert type != null;
        if (type.equalsIgnoreCase("synonym")) {
            fragment = new SynonymFragment();
            
        } else {
            fragment = new AntonymFragment();
        }
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment); // give your fragment container id in first parameter
        transaction.commit();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
