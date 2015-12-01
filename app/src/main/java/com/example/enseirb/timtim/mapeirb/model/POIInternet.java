package com.example.enseirb.timtim.mapeirb.model;

import com.google.android.gms.maps.model.LatLng;

public class POIInternet extends POI  {
    private String typeAccess;
    private Boolean paid;
    private String situation;
    private String typePublic;
    private String formation;
    private int postNumber;

    public POIInternet(LatLng position, String name, String typeAccess, Boolean paid, String situation, String typePublic, String formation, int postNumber) {
        super(position, name);
        this.typeAccess = typeAccess;
        this.paid = paid;
        this.situation = situation;
        this.typePublic = typePublic;
        this.formation = formation;
        this.postNumber = postNumber;
    }

    @Override
    public String getTitle() {
        return getName();
    }

    @Override
    public String getDescription() {
        return getTitle();
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

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getTypePublic() {
        return typePublic;
    }

    public void setTypePublic(String typePublic) {
        this.typePublic = typePublic;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }
}
