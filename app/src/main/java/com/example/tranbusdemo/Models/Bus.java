package com.example.tranbusdemo.Models;

public class Bus {
    private int id;
    private String bus_type;
    private String vehicle_id;
    private int bus_year;
    private int max_number_of_passengers;
    private Track track;
    private Locations location;
    private ImageModel imageModel;

    public Bus(int id, String bus_type, String vehicle_id, int bus_year, int max_number_of_passengers, Track track, Locations location, ImageModel imageModel) {
        this.id = id;
        this.bus_type = bus_type;
        this.vehicle_id = vehicle_id;
        this.bus_year = bus_year;
        this.max_number_of_passengers = max_number_of_passengers;
        this.track = track;
        this.location = location;
        this.imageModel = imageModel;
    }
    public Bus(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBus_type() {
        return bus_type;
    }

    public void setBus_type(String bus_type) {
        this.bus_type = bus_type;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getBus_year() {
        return bus_year;
    }

    public void setBus_year(int bus_year) {
        this.bus_year = bus_year;
    }

    public int getMax_number_of_passengers() {
        return max_number_of_passengers;
    }

    public void setMax_number_of_passengers(int max_number_of_passengers) {
        this.max_number_of_passengers = max_number_of_passengers;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public ImageModel getImageModel() {
        return imageModel;
    }

    public void setImageModel(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", bus_type='" + bus_type + '\'' +
                ", vehicle_id='" + vehicle_id + '\'' +
                ", bus_year=" + bus_year +
                ", max_number_of_passengers=" + max_number_of_passengers +
                ", track=" + track +
                ", location=" + location +
                ", imageModel=" + imageModel +
                '}';
    }
}
