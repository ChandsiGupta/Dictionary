package com.example.syanym.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.syanym.R;
import com.example.syanym.model.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private  String fragmentType;
    public List<Dictionary> wordsList;
    
    public RecyclerAdapter(Context context, List<Dictionary> wordsList, String fragmentType) {
        this.wordsList = wordsList;
        this.fragmentType = fragmentType;
    }
    
    
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View layout = inflater.inflate(R.layout.list_view_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(layout);
        return myViewHolder;
    }
    
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.words.setText(wordsList.get(position).getKey()!=null?wordsList.get(position).getKey().trim()+" : " :"");
         if (fragmentType.equalsIgnoreCase("SynonymFragment")) {
            holder.syn.setText(wordsList.get(position).getSyn()!=null?wordsList.get(position).getSyn().trim():"");
        } else {
            holder.ant.setText(wordsList.get(position).getAnt()!=null?wordsList.get(position).getAnt().trim():"");
        }
    }
    
    public void updateList(List<Dictionary> wordsList)
    {
        this.wordsList = wordsList;
        notifyDataSetChanged();
        
    }
    
    @Override
    public int getItemCount() {
        return wordsList.size();
    }
    
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView words, syn, ant;
        
        public MyViewHolder(View itemView) {
            super(itemView);
            words = itemView.findViewById(R.id.key);
            syn = itemView.findViewById(R.id.syn);
            ant = itemView.findViewById(R.id.ant);
        }
    }
}
