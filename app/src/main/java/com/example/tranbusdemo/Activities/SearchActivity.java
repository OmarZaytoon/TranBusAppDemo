package com.example.tranbusdemo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.tranbusdemo.Adapters.SearchAdapter;
import com.example.tranbusdemo.Adapters.TrackAdapter;
import com.example.tranbusdemo.Models.Track;
import com.example.tranbusdemo.R;
import com.example.tranbusdemo.Util.CreateData;
import com.example.tranbusdemo.Util.Statics;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
RecyclerView recyclerView;
SearchAdapter adapter;
EditText editText;
ArrayList<Track> tracks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView=findViewById(R.id.searchScreen_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);

        editText=findViewById(R.id.searchScreen_search_ed);


       tracks= Statics.tracks;

        adapter=new SearchAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setItems(tracks);
        adapter.OnItemClickListner(new SearchAdapter.OnClickListner() {
            @Override
            public void onClick(Track customers) {
                Intent intent=new Intent(getApplicationContext(),MainTrackDetails.class);
                intent.putExtra("id",customers.getId()+"");
                startActivity(intent);
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(Statics.language) {
                    adapter.setItems(findEn(charSequence.toString()));
                }else  adapter.setItems(findAr(charSequence.toString()));

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(Statics.language) {
                    adapter.setItems(findEn(editable.toString()));
                }else  adapter.setItems(findAr(editable.toString()));

            }
        });
    }
    public ArrayList<Track> findAr(String data){
        ArrayList<Track>list=new ArrayList<>();
        for(int i=0;i<tracks.size();i++){
            if(tracks.get(i).getTrack_name_Ar().contains(data)|| tracks.get(i).getStart_point_Ar().contains(data)
                || tracks.get(i).getEnd_point_Ar().contains(data)){
                list.add(tracks.get(i));
            }
        }
        return list;
    }
    public ArrayList<Track> findEn(String data){
        ArrayList<Track>list=new ArrayList<>();
        for(int i=0;i<tracks.size();i++){
            if(tracks.get(i).getTrack_name_En().contains(data)|| tracks.get(i).getStart_point_En().contains(data)
                    || tracks.get(i).getEnd_point_En().contains(data)){
                list.add(tracks.get(i));
            }
        }
        return list;
    }

    @Override
    public void onBackPressed() {
        CreateData createData=new CreateData();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}