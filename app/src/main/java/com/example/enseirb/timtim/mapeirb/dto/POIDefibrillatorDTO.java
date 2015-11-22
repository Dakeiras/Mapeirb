package com.example.enseirb.timtim.mapeirb.dto;

public class POIDefibrillatorDTO extends POIDTO{

    private String typologie;
    private String address;
    private String name;
    private String telephone;
    private String installe;

    public POIDefibrillatorDTO(Double longitude, Double latitude, String typologie, String address, String name, String telephone, String installe) {
        this.setLongitude(longitude);
        this.setLatitude(latitude);
        this.typologie = typologie;
        this.address = address;
        this.name = name;
        this.telephone = telephone;
        this.installe = installe;
    }

    public String getTypologie() {
        return typologie;
    }

    public void setTypologie(String typologie) {
        this.typologie = typologie;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getInstalle() {
        return installe;
    }

    public void setInstalle(String installe) {
        this.installe = installe;
    }

}
