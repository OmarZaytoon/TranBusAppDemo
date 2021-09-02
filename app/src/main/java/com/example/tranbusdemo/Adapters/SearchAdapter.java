package com.example.tranbusdemo.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tranbusdemo.Models.Track;
import com.example.tranbusdemo.R;
import com.example.tranbusdemo.Util.Statics;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private List<Track> tracks=new ArrayList<>();
    private SearchAdapter.OnClickListner mListner;

    @NonNull
    @NotNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.search_card,parent,false);
        return new SearchAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull SearchAdapter.ViewHolder holder, int position) {
        Track track=tracks.get(position);
            if(Statics.language) {
                holder.nameTV.setText(track.getTrack_name_En());
            }else {
                holder.nameTV.setText(track.getTrack_name_Ar());
            }
            holder.imageView.setImageResource(R.drawable.bus_station_search);

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
        ImageView imageView;
        TextView nameTV;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.searchCard_image);
            nameTV=itemView.findViewById(R.id.searchCard_name);
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

    public void OnItemClickListner(SearchAdapter.OnClickListner listner) {
        mListner = listner;
    }

    public Track getDrawerAt(int pos) {
        return tracks.get(pos);
    }
}