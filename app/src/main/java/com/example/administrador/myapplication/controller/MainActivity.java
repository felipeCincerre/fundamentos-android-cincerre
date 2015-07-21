package com.example.administrador.myapplication.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.administrador.myapplication.model.entities.Client;
import com.example.administrador.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Client> clients = getClients();

        ListView listViewClients = (ListView) findViewById(R.id.listViewClients);

        //ArrayAdapter<String> clientAdapter =  new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, clientName.toArray(new String[]{}));
        ClientListAdapter clientListAdapter = new ClientListAdapter(MainActivity.this, clients);
        listViewClients.setAdapter(clientListAdapter);
    }


    private List<Client> getClients(){
        List<Client> clients = new ArrayList<>();
        Client ze = new Client();
        ze.setName("José");
        ze.setAge(20);
        clients.add(ze);

        Client marcolino = new Client();
        marcolino.setName("Marcolino");
        marcolino.setAge(20);
        clients.add(marcolino);
        return clients;
    }
}
