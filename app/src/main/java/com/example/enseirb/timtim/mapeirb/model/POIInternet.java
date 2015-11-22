package com.example.enseirb.timtim.mapeirb.model;

public class POIInternet extends POI  {
    private String name;
    private String typeAccess;
    private Boolean paid;

    public POIInternet(double longitude, double latitude, String name, String typeAccess, Boolean paid) {
        super(longitude, latitude);
        this.name = name;
        this.typeAccess = typeAccess;
        this.paid = paid;
    }

    @Override
    public String getTitle() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeAccess() {
        return typeAccess;
    }

    public void setTypeAccess(String typeAccess) {
        this.typeAccess = typeAccess;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
