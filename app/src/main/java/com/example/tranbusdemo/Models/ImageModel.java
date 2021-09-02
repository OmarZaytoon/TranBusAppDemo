package com.example.tranbusdemo.Models;

public class ImageModel {
    private int id;
    private String name;
    private int width;
    private int height;
    private String url;

    public ImageModel (){}

    public ImageModel(int id, String name, int width, int height, String url) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImageModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", url='" + url + '\'' +
                '}';
    }
}
