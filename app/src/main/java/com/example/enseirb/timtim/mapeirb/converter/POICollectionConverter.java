package com.example.enseirb.timtim.mapeirb.converter;

import com.example.enseirb.timtim.mapeirb.converter.listener.IPOICollectionConverterListener;
import com.example.enseirb.timtim.mapeirb.dao.IPOIsDAO;
import com.example.enseirb.timtim.mapeirb.dao.listener.IPOICollectionDAOListener;
import com.example.enseirb.timtim.mapeirb.dto.POICollectionDTO;
import com.example.enseirb.timtim.mapeirb.dto.POIDTO;
import com.example.enseirb.timtim.mapeirb.model.POICollection;
import com.example.enseirb.timtim.mapeirb.model.POIType;

public class POICollectionConverter implements com.example.enseirb.timtim.mapeirb.converter.IPOICollectionConverter {
    private static String CLASS_NOT_FOUND = "Class {0} does not exist";
    private static final String DAO_CLASS_PATH = "com.example.enseirb.timtim.mapeirb.dao";
    private static final String DAO_CLASS_SUFFIX = "sDAO";
    private static final String CONVERTER_CLASS_PATH = "com.example.enseirb.timtim.mapeirb.converter";
    private static final String CONVERTER_CLASS_SUFFIX = "sConverter";
    private static final String DOT_STRING = ".";

    private IPOIsDAO dao;
    private IPOIsConverter converter;

        private Object getInstanceFromClassName(String packagePath, POIType poiType, String suffix){
            String className = poiType.toString().toLowerCase();
            className = className.substring(0, 1).toUpperCase() + className.substring(1);
            String classPath = packagePath + DOT_STRING + className;
            classPath += suffix;
            Object retVal = null;
            try {
                retVal = Class.forName(classPath).newInstance();
            } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
                System.err.println(String.format(CLASS_NOT_FOUND, classPath));
                e.printStackTrace();
                System.exit(1);
            }
            return retVal;
        }

        private IPOIsDAO getDaoCollectionFromName(POIType poiType){
            return (IPOIsDAO) getInstanceFromClassName(
                    DAO_CLASS_PATH, poiType, DAO_CLASS_SUFFIX);
        }

        private IPOIsConverter getConverterCollectionFromName(POIType poiType){
            return (IPOIsConverter) getInstanceFromClassName(
                    CONVERTER_CLASS_PATH, poiType, CONVERTER_CLASS_SUFFIX);

        }



    public POICollectionConverter(POIType type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.dao = getDaoCollectionFromName(type);
        this.converter  = getConverterCollectionFromName(type);
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
