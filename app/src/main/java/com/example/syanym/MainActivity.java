package com.example.syanym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;

import com.example.syanym.ViewMvc.MainActivityViewMVC;
import com.example.syanym.ViewMVCImpl.MainActivityViewMVCImpl;

public class MainActivity extends AppCompatActivity{
    MainActivityViewMVC mainActivityViewMVC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityViewMVC = new MainActivityViewMVCImpl(LayoutInflater.from(this), null);
        setContentView(mainActivityViewMVC.getRootView());
        ((Button) mainActivityViewMVC.findViewById(R.id.synonym)).setOnClickListener(v -> {
           Intent intent = new Intent(MainActivity.this, HomeActivity.class);
           intent.putExtra("TYPE", "synonym");
           startActivity(intent);
       });
        ((Button) mainActivityViewMVC.findViewById(R.id.antonym)).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.putExtra("TYPE", "antonym");
            startActivity(intent);
        });
       
    }
        
    
        @Override
        public void onBackPressed () {
            super.onBackPressed();
        }
    
    }