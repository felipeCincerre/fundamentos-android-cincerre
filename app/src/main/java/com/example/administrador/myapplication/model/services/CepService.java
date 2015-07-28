package com.example.administrador.myapplication.model.services;

import com.example.administrador.myapplication.model.entities.ClientAddress;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrador on 27/07/2015.
 */
public final class CepService {
    private static final String URL = "https://correiosapi.apphb.com/cep/";
    ClientAddress clientAddress = null;
    private CepService() {
        super();
    }

    public static ClientAddress getAddressBy(String cep) {
        try {
            URL url = new URL(URL + cep);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            int responseCode = conn.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Error code: " + responseCode);
            }
            InputStream inputStream = conn.getInputStream();

            //ObjectMapper.objectMapper = new ObjectMapper();
            //clientAddress = objectMapper.readValue(inputStream, ClientAddress.class);
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return clientAddress;
        return null;
    }
}
