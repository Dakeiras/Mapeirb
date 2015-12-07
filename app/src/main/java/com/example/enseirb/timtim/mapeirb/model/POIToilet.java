package com.example.enseirb.timtim.mapeirb.model;

import com.google.android.gms.maps.model.LatLng;

public class POIToilet extends POI  {

    private static final String TYPE = "- Type : ";
    private static final String ADDRESS = "- Adresse : ";
    private static final String NEIGHBOURHOOD = "- Quartier : ";
    private static final String OPTION = "- Option : ";

    private static final String NO_NAME_TOILET = "Toilette anonyme";

    private String type;
    private String address;
    private String neighbourhood;
    private String option;

    public POIToilet(String name, LatLng position, String type, String address, String neighbourhood, String option) {
        super(position, name);
        this.type = type;
        this.address = address;
        this.neighbourhood = neighbourhood;
        this.option = option;
    }

    @Override
    public String getTitle() {
        return (getName() != null)?getName():NO_NAME_TOILET;
    }

    @Override
    public String getDescription() {
        String description = "";
        if (address != null) {
            description += ADDRESS + getAddress();
        }
        if (type != null) {
            description += TYPE + getType();
        }
        if (neighbourhood != null) {
            description += NEIGHBOURHOOD + getNeighbourhood();
        }
        if (option != null) {
            description += OPTION + getOption();
        }
        return description;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
