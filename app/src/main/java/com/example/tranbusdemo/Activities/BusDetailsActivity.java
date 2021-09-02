package com.example.tranbusdemo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tranbusdemo.Models.Bus;
import com.example.tranbusdemo.R;
import com.example.tranbusdemo.Util.CreateData;
import com.example.tranbusdemo.Util.Statics;

public class BusDetailsActivity extends AppCompatActivity {
Bus bus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_deatils);
        int id= Integer.parseInt(getIntent().getExtras().getString("id"));
        for(int i=0;i<24;i++){
            if(Statics.buses.get(i).getId()==id){
                bus=Statics.buses.get(i);
                break;
            }
        }
        ImageView imageView=findViewById(R.id.bus_details_main_image);
        TextView trackName=findViewById(R.id.bus_details_bus_type);
        TextView  busType=findViewById(R.id.bus_details_main_busType);
        TextView busID=findViewById(R.id.bus_details_main_id);
        TextView busYear=findViewById(R.id.bus_details_year);
        TextView passengers=findViewById(R.id.bus_details_passengers);
        Drawable res;
        if(bus.getId()<=3||(bus.getId()>=19&& bus.getId()<=21)){
         res = getResources().getDrawable(R.drawable.tlaalibus);
        }else if((bus.getId()>=4&&bus.getId()<=6)||(bus.getId()>=22)){
          res = getResources().getDrawable(R.drawable.madababus);
        }else {
          res = getResources().getDrawable(R.drawable.bus_image_toyta);
        }
        imageView.setImageDrawable(res);
        if(Statics.language)
        trackName.setText(bus.getTrack().getTrack_name_En());
        else  trackName.setText(bus.getTrack().getTrack_name_Ar());
        busType.setText(bus.getBus_type());
        busID.setText(bus.getVehicle_id());
        busYear.setText(bus.getBus_year()+"");
        passengers.setText(bus.getMax_number_of_passengers()+"");

    }

    public void goToTrackDetails(View view) {
        Intent intent=new Intent(this,MainTrackDetails.class);
        intent.putExtra("id",bus.getTrack().getId()+"");
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        CreateData createData=new CreateData();
        startActivity(new Intent(this,MainActivity.class));
    }
}