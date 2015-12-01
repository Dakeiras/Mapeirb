package com.example.enseirb.timtim.mapeirb.model.POIElectric;

public class CarPlace {

    private int number;
    private String status;

    public CarPlace(int number, String status) {
        this.number = number;
        this.status = status;
    }

    public CarPlace() {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
