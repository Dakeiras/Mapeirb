package com.example.enseirb.timtim.mapeirb.dto;


public class POIInternetAccessDTO extends POIDTO {
    private String accessType;
    private String paid;
    private String situation;
    private String typePublic;
    private String formation;
    private int postNumber;


    public POIInternetAccessDTO(Double longitude, Double latitude, String name, String accessType, String paid, String situation, String typePublic, String formation, int postNumber) {
        super(longitude, latitude, name);
        this.accessType = accessType;
        this.paid = paid;
        this.situation = situation;
        this.typePublic = typePublic;
        this.formation = formation;
        this.postNumber = postNumber;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
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
