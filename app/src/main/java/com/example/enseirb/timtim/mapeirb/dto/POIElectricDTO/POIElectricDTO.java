package com.example.enseirb.timtim.mapeirb.dto.POIElectricDTO;

import com.example.enseirb.timtim.mapeirb.dto.POIDTO;

import java.util.List;

public class POIElectricDTO extends POIDTO {
    private int number;
    private String address;
    private String status;
    private String access;
    private List<CarPlaceDTO> carPlaces;


    public POIElectricDTO(Double longitude, Double latitude, String name, int number, String address, String status, String access, List<CarPlaceDTO> carPlaces) {
        super(longitude, latitude, name);
        this.number = number;
        this.address = address;
        this.status = status;
        this.access = access;
        this.carPlaces = carPlaces;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public List<CarPlaceDTO> getCarPlaces() {
        return carPlaces;
    }

    public void setCarPlaces(List<CarPlaceDTO> carPlaces) {
        this.carPlaces = carPlaces;
    }
}


