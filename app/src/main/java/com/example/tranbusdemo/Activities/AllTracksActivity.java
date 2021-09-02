package com.example.tranbusdemo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tranbusdemo.Adapters.TrackAdapter;
import com.example.tranbusdemo.Models.Track;
import com.example.tranbusdemo.R;
import com.example.tranbusdemo.Util.CreateData;
import com.example.tranbusdemo.Util.Statics;

import java.util.ArrayList;

public class AllTracksActivity extends AppCompatActivity {
RecyclerView recyclerView;
TrackAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tracks);
        recyclerView=findViewById(R.id.all_track_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);


        adapter=new TrackAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setItems(Statics.tracks);
        adapter.OnItemClickListner(new TrackAdapter.OnClickListner() {
            @Override
            public void onClick(Track customers) {
                Intent intent=new Intent(getApplicationContext(),MainTrackDetails.class);
                intent.putExtra("id",customers.getId()+"");
                startActivity(intent);
            }
        });
    }

    public void back(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        CreateData createData=new CreateData();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}