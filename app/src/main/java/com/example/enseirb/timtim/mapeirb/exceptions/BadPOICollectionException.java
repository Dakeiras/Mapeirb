package com.example.enseirb.timtim.mapeirb.exceptions;

/**
 * Use when the POI collection is invalid (not initialized, empty, etc.)
 */
public class BadPOICollectionException extends Exception {
    public BadPOICollectionException(String s) {
        super(s);
    }
}
