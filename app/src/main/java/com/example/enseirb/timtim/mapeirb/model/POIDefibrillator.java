package com.example.enseirb.timtim.mapeirb.model;

import com.google.android.gms.maps.model.LatLng;

public class POIDefibrillator extends POI  {

    private String typologie;
    private String address;
    private String telephone;
    private Boolean installe;
    private String city;
    private int postalCode;


    public POIDefibrillator(LatLng position, String typologie, String address, String name, String telephone, Boolean installe, String city, int postalCode) {
        super(position, name);
        this.typologie = typologie;
        this.address = address;
        this.telephone=telephone;
        this.installe = installe;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Boolean getInstalle() {
        return installe;
    }

    public void setInstalle(Boolean installe) {
        this.installe = installe;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypologie() {
        return typologie;
    }

    public void setTypologie(String typologie) {
        this.typologie = typologie;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String getTitle() {
        return getName() + address;
    }

    @Override
    public String getDescription() {
        return getTitle();
    }
}
