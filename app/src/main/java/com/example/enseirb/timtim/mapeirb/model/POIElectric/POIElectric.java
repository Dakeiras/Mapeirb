package com.example.enseirb.timtim.mapeirb.model.POIElectric;

import com.example.enseirb.timtim.mapeirb.model.POI;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class POIElectric extends POI {

    private static final String ADDRESS = "Adresse : ";
    private static final String STATUS = "Statut : ";
    private static final String ACCESS = "Accessibilité : ";
    private static String PLACES_FREE = "Places : {0} (dont {1} libres)";

    private int number;
    private String address;
    private Boolean status;
    private String access;
    private List<CarPlace> carPlaces;

    public POIElectric(LatLng position, String name, String address, Boolean status, int number, String access, List<CarPlace> carPlaces) {
        super(position, name);
        this.address = address;
        this.status = status;
        this.number = number;
        this.access = access;
        this.carPlaces = carPlaces;
    }

    @Override
    public String getTitle() {
        return getName() + address;
    }

    @Override
    public String getDescription() {
        String description = "";
        if (address != null) {
            description += ADDRESS + getAddress();
        }
        if (status != null) {
            description += STATUS + getStatus();
        }
        if (access != null) {
            description += ACCESS + getAccess();
        }
        if (carPlaces != null) {
            description += String.format(PLACES_FREE, getCarPlaces().size(), carPlacesFree());
        }
        return description;
    }

    private int carPlacesFree() {
        int cpt = 0;
        for (CarPlace cp : getCarPlaces()){
            cpt += cp.isFree()?1:0;
        }
        return cpt;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public List<CarPlace> getCarPlaces() {
        return carPlaces;
    }

    public void setCarPlaces(List<CarPlace> carPlaces) {
        this.carPlaces = carPlaces;
    }
}
