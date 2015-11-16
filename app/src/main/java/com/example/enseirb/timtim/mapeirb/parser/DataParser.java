package com.example.enseirb.timtim.mapeirb.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by air on 14/11/2015.
 */
public abstract class DataParser implements IPOICollectionParser{
    public static final String LONGITUDE = "x_long";
    public static final String LATITUDE = "y_lat";

   /* abstract public List<DataDTO> parseData();*/

    protected InputStream connectTo(String urlToParse) throws IOException {
        InputStream is;
        URL url = new URL(urlToParse);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setDoInput(true);
        conn.connect();
        is = conn.getInputStream();
        return is;
    }

    protected String requestResponseAsString(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder builder = new StringBuilder();
        String aux = "";
        while ((aux = reader.readLine()) != null) {
            builder.append(aux);
        }
        String text = builder.toString();
        return text;
    }

}
