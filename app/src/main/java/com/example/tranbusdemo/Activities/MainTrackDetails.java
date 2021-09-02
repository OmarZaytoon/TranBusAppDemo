package com.example.tranbusdemo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tranbusdemo.Models.Track;
import com.example.tranbusdemo.Util.DownLoadImageTask;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tranbusdemo.Activities.TrackDetailsActivity;
import com.example.tranbusdemo.R;
import com.example.tranbusdemo.Util.Statics;

public class MainTrackDetails extends AppCompatActivity {
Track track;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_track_details);
        ImageView imageView=findViewById(R.id.track_details_main_image);
        int id= Integer.parseInt(getIntent().getExtras().getString("id"));
        for(int i=0;i< Statics.tracks.size();i++){
            if(id==Statics.tracks.get(i).getId()){
                track=Statics.tracks.get(i);
            break;
            }
        }
        new DownLoadImageTask(imageView).execute(track.getImageUrl());
        TextView trackName=findViewById(R.id.track_details_main_track_name);
        TextView start=findViewById(R.id.track_details_main_startPoint);
        TextView end=findViewById(R.id.track_details_main_endPoint);
        TextView price=findViewById(R.id.track_details_main_Price);
        TextView average=findViewById(R.id.track_details_main_time);
        TextView distance=findViewById(R.id.track_details_main_distance);
        TextView acitveBuses=findViewById(R.id.track_details_main_activeBuses);
        TextView mainCity=findViewById(R.id.track_details_main_mainCity);

        if(Statics.language) {
            trackName.setText(track.getTrack_name_En());
            start.setText(track.getStart_point_En());
            end.setText(track.getEnd_point_En());
            price.setText(track.getPrice() + " JD");
            average.setText(track.getAvarage_travel_time_min() + " min");
            distance.setText(track.getTrack_distance_in_km() + " km");
            acitveBuses.setText(3 + "");
            mainCity.setText("Amman");
        }else{
            trackName.setText(track.getTrack_name_Ar());
            start.setText(track.getStart_point_Ar());
            end.setText(track.getEnd_point_Ar());
            price.setText(" دينار أردني"+track.getPrice());
            average.setText(" دقيقة"+track.getAvarage_travel_time_min());
            distance.setText("كم "+track.getTrack_distance_in_km());
            acitveBuses.setText(3 + "");
            mainCity.setText("عمان");
        }
    }

    public void goToMap(View view) {
        Intent intent=new Intent(this, TrackDetailsActivity.class);
        intent.putExtra("id",track.getId()+"");
        startActivity(intent);
    }
}