package com.example.tranbusdemo.Models;

public class Track {
    private int id;
    private String track_name_Ar;
    private String track_name_En;
    private String start_point_Ar;
    private String end_point_Ar;
    private String start_point_En;
    private String end_point_En;
    private float track_distance_in_km;
    private float avarage_travel_time_min;
    private float price;
    private  ImageModel imageModel;
    private String imageUrl;
    public Track(){}

    public Track(int id, String track_name_Ar, String track_name_En, String start_point_Ar, String end_point_Ar, String start_point_En, String end_point_En, float track_distance_in_km, float avarage_travel_time_min, float price) {
        this.id = id;
        this.track_name_Ar = track_name_Ar;
        this.track_name_En = track_name_En;
        this.start_point_Ar = start_point_Ar;
        this.end_point_Ar = end_point_Ar;
        this.start_point_En = start_point_En;
        this.end_point_En = end_point_En;
        this.track_distance_in_km = track_distance_in_km;
        this.avarage_travel_time_min = avarage_travel_time_min;
        this.price = price;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrack_name_Ar() {
        return track_name_Ar;
    }

    public void setTrack_name_Ar(String track_name_Ar) {
        this.track_name_Ar = track_name_Ar;
    }

    public String getTrack_name_En() {
        return track_name_En;
    }

    public void setTrack_name_En(String track_name_En) {
        this.track_name_En = track_name_En;
    }

    public String getStart_point_Ar() {
        return start_point_Ar;
    }

    public void setStart_point_Ar(String start_point_Ar) {
        this.start_point_Ar = start_point_Ar;
    }

    public String getEnd_point_Ar() {
        return end_point_Ar;
    }

    public void setEnd_point_Ar(String end_point_Ar) {
        this.end_point_Ar = end_point_Ar;
    }

    public String getStart_point_En() {
        return start_point_En;
    }

    public void setStart_point_En(String start_point_En) {
        this.start_point_En = start_point_En;
    }

    public String getEnd_point_En() {
        return end_point_En;
    }

    public void setEnd_point_En(String end_point_En) {
        this.end_point_En = end_point_En;
    }

    public float getTrack_distance_in_km() {
        return track_distance_in_km;
    }

    public void setTrack_distance_in_km(float track_distance_in_km) {
        this.track_distance_in_km = track_distance_in_km;
    }

    public float getAvarage_travel_time_min() {
        return avarage_travel_time_min;
    }

    public void setAvarage_travel_time_min(float avarage_travel_time_min) {
        this.avarage_travel_time_min = avarage_travel_time_min;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ImageModel getImageModel() {
        return imageModel;
    }

    public void setImageModel(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", track_name_Ar='" + track_name_Ar + '\'' +
                ", track_name_En='" + track_name_En + '\'' +
                ", start_point_Ar='" + start_point_Ar + '\'' +
                ", end_point_Ar='" + end_point_Ar + '\'' +
                ", start_point_En='" + start_point_En + '\'' +
                ", end_point_En='" + end_point_En + '\'' +
                ", track_distance_in_km=" + track_distance_in_km +
                ", avarage_travel_time_min=" + avarage_travel_time_min +
                ", price=" + price +
                '}';
    }
}
