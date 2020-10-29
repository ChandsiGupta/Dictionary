package com.example.syanym.network;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import androidx.recyclerview.widget.RecyclerView;

import com.example.syanym.adapter.RecyclerAdapter;
import com.example.syanym.database.DatabaseClient;
import com.example.syanym.database.DatabaseHelper;
import com.example.syanym.model.Dictionary;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class Networking {
    private Context context;
    private RecyclerView recyclerView;
    DatabaseHelper db;
    private String id;
    private String key;
    private String syn;
    private String ant;
    private String fragmentType;
    private RecyclerAdapter recyclerAdapter;
    public static ArrayList<Dictionary> data = new ArrayList<>();
    
    public Networking(Context context, RecyclerView recyclerView, String fragmentType) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.fragmentType = fragmentType;
    }
    
    public void getTasks() {
        class GetTasks extends AsyncTask<Void, Void, List<Dictionary>> {
            
            @Override
            protected List<Dictionary> doInBackground(Void... voids) {
                List<Dictionary> taskList = DatabaseClient
                        .getInstance(context).dictionaryDao().getAll();
                return taskList;
//                db = new DatabaseHelper(context);
//                try {
//
//                    db.createDataBase();
//                    db.openDataBase();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

//                int ii;
//                SQLiteDatabase sd = db.getReadableDatabase();
//                Cursor cursor = sd.query("dictionary", new String[]{"id", "key", "syn", "ant"}, null, null, null, null, "key");
//                ii = cursor.getColumnIndex("id");
//                while (cursor.moveToNext()) {
//                    id = cursor.getString(cursor.getColumnIndex("id"));
//                    key = cursor.getString(cursor.getColumnIndex("key"));
//                    syn = cursor.getString(cursor.getColumnIndex("syn"));
//                    ant = cursor.getString(cursor.getColumnIndex("ant"));
////			data.add(cursor.getString(ii), cursor.getString(cursor.getColumnIndex("key")));
//                    data.add(new Dictionary(syn, ant,key));
//                }
            }
            
            @Override
            protected void onPostExecute(List<Dictionary> wordsList) {
                super.onPostExecute(wordsList);
                EventBus.getDefault().post(wordsList);
            }
        }
        
        GetTasks gt = new GetTasks();
        gt.execute();
    }
 
}
