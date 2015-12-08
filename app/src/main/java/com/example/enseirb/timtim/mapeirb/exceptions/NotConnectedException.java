package com.example.enseirb.timtim.mapeirb.exceptions;

/**
 * Use when the device is not connected to the internet
 */
public class NotConnectedException extends Exception{
    public NotConnectedException(String s) {
        super(s);
    }
}
