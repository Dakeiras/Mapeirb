package com.example.enseirb.timtim.mapeirb.model;

public class InternetPOI  extends POI  {
    public String name;
    public String typeAccess;
    public String paid;

    public InternetPOI(double longitude, double latitude, String name,
                          String typeAccess, String paid) {
        super(longitude, latitude);
        this.name = name;
        this.typeAccess = typeAccess;
        this.paid = paid;
    }

    @Override
    public String getTitle() {
        return name;
    }
}
