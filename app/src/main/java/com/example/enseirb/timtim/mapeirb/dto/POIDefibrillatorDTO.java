package com.example.enseirb.timtim.mapeirb.dto;

public class POIDefibrillatorDTO extends POIDTO{

    private String typologie;
    private String address;
    private String telephone;
    private String installe;
    private String city;
    private int postalCode;

    public POIDefibrillatorDTO(Double longitude, Double latitude, String name, String typologie, String address, String telephone, String installe, String city, int postalCode) {
        super(longitude, latitude, name);
        this.typologie = typologie;
        this.address = address;
        this.telephone = telephone;
        this.installe = installe;
        this.city = city;
        this.postalCode = postalCode;
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
}
