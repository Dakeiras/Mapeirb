package com.example.enseirb.timtim.mapeirb.converter;

import com.example.enseirb.timtim.mapeirb.converter.listener.IPOICollectionConverterListener;
import com.example.enseirb.timtim.mapeirb.dao.IPOIsDAO;
import com.example.enseirb.timtim.mapeirb.dao.listener.IPOICollectionDAOListener;
import com.example.enseirb.timtim.mapeirb.dto.POICollectionDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIDTO;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.model.POIType;

public class POICollectionConverter implements com.example.enseirb.timtim.mapeirb.converter.IPOICollectionConverter {
    private IPOIsDAO dao;
    private IPOIsConverter converter;

        /**
         * Return a new innstance of the wanted class given its type.
         * @param packagePath The path of the package in which the class is
         * @param poiType The type of the POI
         * @param suffix The suffix of the className. Can whether be "CollectionConverter" or "CollectionDAO"
         * @return an instance of the wanted class
         */
        private Object getInstanceFromClassName(String packagePath, POIType poiType, String suffix){
            String className = poiType.toString().toLowerCase();
            className = className.substring(0, 1).toUpperCase() + className.substring(1);
            String classPath = packagePath + "." + className;
            classPath += suffix;
            Object retVal = null;
            try {
                retVal = Class.forName(classPath).newInstance();
            } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
                System.err.println("Class " + classPath + " does not exist");
                e.printStackTrace();
                System.exit(1);
            }
            return retVal;
        }

        private IPOIsDAO getDaoCollectionFromName(POIType poiType){
            return (IPOIsDAO) getInstanceFromClassName(
                    "com.example.enseirb.timtim.mapeirb.dao", poiType, "sDAO");
        }

        private IPOIsConverter getConvertercollectionFromName(POIType poiType){
            return (IPOIsConverter) getInstanceFromClassName(
                    "com.example.enseirb.timtim.mapeirb.converter", poiType, "sConverter");

        }



    public POICollectionConverter(POIType type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.dao = getDaoCollectionFromName(type);
        this.converter  =getConvertercollectionFromName(type);
    }
    public void retrievePOICollection(final POIType type, final IPOICollectionConverterListener listener){
        dao.retrievePOICollection(new IPOICollectionDAOListener() {

            @Override
            public void onSuccess(POICollectionDTO poiCollectionDTO) {
                listener.onSuccess(convert(poiCollectionDTO));
            }

            @Override
            public void onError(String message) {
                listener.onError(message);
            }
        });
    }

    public POICollection convert(POICollectionDTO collectionDTO){
        POICollection poiCollection = new POICollection();
        for (POIDTO poi : collectionDTO.getPoiCollection()){
            poiCollection.add(converter.convertDTO(poi));
        }

        return poiCollection;
    }
}
