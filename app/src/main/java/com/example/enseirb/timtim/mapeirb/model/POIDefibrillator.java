package com.example.enseirb.timtim.mapeirb.model;

public class POIDefibrillator extends POI  {

    private String typologie;
    private String address;
    private String name;
    private String telephone;
    private Boolean installe;


    public POIDefibrillator(Double longitude, Double latitude, String typologie, String address, String name, String telephone, Boolean installe) {
        super(longitude, latitude);
        this.longitude = longitude;
        this.latitude = latitude;
        this.typologie = typologie;
        this.address = address;
        this.name = name;
        this.telephone=telephone;
        this.installe = installe;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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




    @Override
    public String getTitle() {
        return null;
    }
}
