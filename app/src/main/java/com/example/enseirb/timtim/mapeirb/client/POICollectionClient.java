package com.example.enseirb.timtim.mapeirb.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class POICollectionClient implements IPOICollectionClient {

    private static final int READ_TIMEOUT = 10000;
    private static final int CONNECTION_TIMEOUT = 10000;
    private static final String HTTP_GET_METHOD = "GET";
    private static final String URL_MALFORMED = "Malformed URL";
    private static final String PROTOCOL_ERROR = "Protocol error";
    private static final String ENCODING = "UTF-8";
    private static final String DELIMITER_STRING_INPUT_STREAM = "\\A";

    @Override
    public String retrievePOICollection(String url) {
        InputStream is = null;
        try{
            is = connectTo(url);
            return (parseResponse(is));
        } catch (MalformedURLException e) {
            System.err.println(URL_MALFORMED);
            e.printStackTrace();
            return null;
        }catch (ProtocolException e){
            System.err.println(PROTOCOL_ERROR);
            e.printStackTrace();
            return null;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally{
            if (is != null){
                closeInputStream(is);
            }
        }
    }

    private String parseResponse(InputStream is) {
        return new Scanner(is,ENCODING).useDelimiter(DELIMITER_STRING_INPUT_STREAM).next();
    }

    private void closeInputStream(InputStream is) {
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream connectTo(String urlToParse) throws IOException {
        InputStream is;
        URL url = new URL(urlToParse);
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setReadTimeout(READ_TIMEOUT);
        connect.setConnectTimeout(CONNECTION_TIMEOUT);
        connect.setRequestMethod(HTTP_GET_METHOD);
        connect.setDoInput(true);
        connect.connect();
        is = connect.getInputStream();
        return is;

    }

}
