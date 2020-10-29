package com.example.syanym;

import android.app.Fragment;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.syanym.adapter.RecyclerAdapter;
import com.example.syanym.model.Dictionary;
import com.example.syanym.network.Networking;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class AntonymFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Dictionary> wordList = new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;
    
    public AntonymFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_synonym, container, false);;
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        setHasOptionsMenu(true); // It's important here
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Networking networking = new Networking(getActivity(),recyclerView,"AntonymFragment");
        networking.getTasks();
        return view;
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
             /*   if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(MainActivity.this, "No Match found",Toast.LENGTH_LONG).show();
                }*/
                return false;
                
            }
            
            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length()>1) {
                    String userInput = newText.toLowerCase().trim();
                    ArrayList<Dictionary> newList = new ArrayList<>();
                    for (Dictionary av : recyclerAdapter.wordsList) {
                        if (av.getKey().toLowerCase().trim().contains(userInput.trim())) {
                            newList.add(av);
                        }
                    }
                    recyclerAdapter.updateList(newList);
                }
                else
                {
                    recyclerAdapter.updateList(wordList);
                    
                }
                return true;
            }
        });
        SearchView.OnCloseListener closeListener = new SearchView.OnCloseListener(){
            
            @Override
            public boolean onClose() {
                recyclerAdapter.updateList(wordList);
                return true;
            }
        };
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        
    }
    @Subscribe
    public void onEventMainThread(List<Dictionary> dictionaries) {
        this.wordList = dictionaries;
        recyclerAdapter = new RecyclerAdapter(getActivity(),wordList,"AntonymFragment");
        recyclerView.setAdapter(recyclerAdapter);
        //bind data
    }
    
}