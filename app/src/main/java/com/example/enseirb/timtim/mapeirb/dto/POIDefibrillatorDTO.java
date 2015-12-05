package com.example.enseirb.timtim.mapeirb.dto;

public class POIDefibrillatorDTO extends POIDTO{

    private String typology;
    private String address;
    private String telephone;
    private String installed;
    private String city;
    private int postalCode;

    public POIDefibrillatorDTO(Double longitude, Double latitude, String name, String typology, String address, String telephone, String installed, String city, int postalCode) {
        super(longitude, latitude, name);
        this.typology = typology;
        this.address = address;
        this.telephone = telephone;
        this.installed = installed;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getTypology() {
        return typology;
    }

    public void setTypology(String typology) {
        this.typology = typology;
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

    public String getInstalled() {
        return installed;
    }

    public void setInstalled(String installed) {
        this.installed = installed;
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
