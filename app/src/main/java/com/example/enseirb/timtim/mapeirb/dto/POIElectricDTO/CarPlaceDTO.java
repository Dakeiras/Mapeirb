package com.example.enseirb.timtim.mapeirb.dto.POIElectricDTO;

public class CarPlaceDTO {
    private int number;
    private String status;

    public CarPlaceDTO(int number, String status) {
        this.number = number;
        this.status = status;
    }

    public CarPlaceDTO() {

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
