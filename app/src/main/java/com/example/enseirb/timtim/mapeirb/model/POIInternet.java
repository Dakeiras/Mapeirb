package com.example.enseirb.timtim.mapeirb.model;

import com.google.android.gms.maps.model.LatLng;

public class POIInternet extends POI  {

    private static final String ACCESS_TYPE = "- Type d'accès : ";
    private static final String PAID = "- Coût : ";
    private static final String SITUATION = "- Situation : ";
    private static final String PUBLIC_TYPE = "- Public : ";
    private static final String FORMATION = "- Formation : ";
    private static final String POSTAL_CODE = "- Code postal : ";

    private static final String NO_NAME_INTERNET = "Point d'accès anonyme";

    private String accessType;
    private Boolean paid;
    private String situation;
    private String publicType;
    private String formation;
    private int postalCode;

    public POIInternet(LatLng position, String name, String accessType, Boolean paid, String situation, String publicType, String formation, int postalCode) {
        super(position, name);
        this.accessType = accessType;
        this.paid = paid;
        this.situation = situation;
        this.publicType = publicType;
        this.formation = formation;
        this.postalCode = postalCode;
    }

    @Override
    public String getTitle() {
        return (getName() != null)?getName():NO_NAME_INTERNET;
    }

    @Override
    public String getDescription() {
        String description = "";
        if (accessType != null) {
            description += ACCESS_TYPE + getAccessType();
        }
        description += PAID + getPaid();
        if (situation != null) {
            description += SITUATION + getSituation();
        }
        if (publicType != null) {
            description += PUBLIC_TYPE + getPublicType();
        }
        if (formation != null) {
            description += FORMATION + getFormation();
        }
        if (postalCode > 0) {
            description += POSTAL_CODE + getPostalCode();
        }
        return description;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getPublicType() {
        return publicType;
    }

    public void setPublicType(String publicType) {
        this.publicType = publicType;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
