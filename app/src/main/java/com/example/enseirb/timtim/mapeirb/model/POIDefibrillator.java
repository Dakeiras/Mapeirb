package com.example.enseirb.timtim.mapeirb.model;

import com.google.android.gms.maps.model.LatLng;

public class POIDefibrillator extends POI  {

    private static final String TYPOLOGY = "- Type : ";
    private static final String ADDRESS= "- Adresse : ";
    private static final String TELEPHONE= "- Telephone : ";
    private static final String INSTALLED= "- Installé : ";
    private static final String CITY = "- Ville : ";
    private static final String POSTAL_CODE = "- Code postal : ";
    private static final String NO_NAME_DEFIBRILLATOR = "Défibrillator anonyme";

    private String typology;
    private String address;
    private String telephone;
    private Boolean installed;
    private String city;
    private int postalCode;


    public POIDefibrillator(LatLng position, String name, String address, String typology, String telephone, Boolean installed, String city, int postalCode) {
        super(position, name);
        this.typology = typology;
        this.address = address;
        this.telephone=telephone;
        this.installed = installed;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String getTitle() {
        return (getName() != null)?getName():NO_NAME_DEFIBRILLATOR;
    }

    @Override
    public String getDescription() {
        String description = "";
        if (address != null) {
            description += ADDRESS + getAddress();
        }
        if (typology != null) {
            description += TYPOLOGY + getTypology();
        }
        if (city != null) {
            description += CITY + getCity();
        }
        if (postalCode > 0) {
            description += POSTAL_CODE + getPostalCode();
        }
        description += INSTALLED + getInstalled();
        if (telephone != null) {
            description += TELEPHONE + getTelephone();
        }

        return description;
    }

    public Boolean getInstalled() {
        return installed;
    }

    public void setInstalled(Boolean installed) {
        this.installed = installed;
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

    public String getTypology() {
        return typology;
    }

    public void setTypology(String typology) {
        this.typology = typology;
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
