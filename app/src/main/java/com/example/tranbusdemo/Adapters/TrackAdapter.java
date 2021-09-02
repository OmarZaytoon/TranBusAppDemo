package com.example.tranbusdemo.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tranbusdemo.Models.Track;
import com.example.tranbusdemo.R;
import com.example.tranbusdemo.Util.Statics;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {
    private List<Track> tracks=new ArrayList<>();
    private TrackAdapter.OnClickListner mListner;

    @NonNull
    @NotNull
    @Override
    public TrackAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.track_card,parent,false);
        return new TrackAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull TrackAdapter.ViewHolder holder, int position) {
        Track track=tracks.get(position);
        if(Statics.language) {
            holder.trackName.setText(track.getTrack_name_En());
            holder.distance.setText(track.getTrack_distance_in_km() + " km");
            holder.time.setText("Average Travel Time" + track.getAvarage_travel_time_min() + " min");
            holder.price.setText(track.getPrice() + " JD");
            holder.start.setText(track.getStart_point_En());
            holder.end.setText(track.getEnd_point_En());
        }else {
            holder.trackName.setText(track.getTrack_name_Ar());
            holder.distance.setText(track.getTrack_distance_in_km()+" كم");
            holder.time.setText( "المعدل الزمني للرحلة "+ track.getAvarage_travel_time_min() + " دقيقة");
            holder.price.setText( " دينار "+track.getPrice());
            holder.start.setText(track.getStart_point_Ar());
            holder.end.setText(track.getEnd_point_Ar());
        }
    }
    @Override
    public int getItemCount() {
        return tracks.size();
    }
    public void setItems(ArrayList<Track> customers){
        this.tracks=customers;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView trackName;
       TextView start;
       TextView end;
       TextView distance;
       TextView time;
       TextView price;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            trackName=itemView.findViewById(R.id.track_card_name_tv);
            start=itemView.findViewById(R.id.track_card_from_tv);
            end=itemView.findViewById(R.id.track_card_to_tv);
            distance=itemView.findViewById(R.id.track_card_distance_tv);
            time=itemView.findViewById(R.id.track_card_time_tv);
            price=itemView.findViewById(R.id.track_card_price_tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getAdapterPosition();
                    if (mListner != null && index != RecyclerView.NO_POSITION) {
                        mListner.onClick(tracks.get(index));
                    }
                }
            });
        }
    }
    public interface OnClickListner {
        void onClick(Track customers);
    }

    public void OnItemClickListner(TrackAdapter.OnClickListner listner) {
        mListner = listner;
    }

    public Track getDrawerAt(int pos) {
        return tracks.get(pos);
    }
}