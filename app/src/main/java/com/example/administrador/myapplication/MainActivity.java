package com.example.administrador.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         List<String> clientName = new ArrayList<>();
        clientName.add("Renan");
        clientName.add("Venilton");
        clientName.add("Marcolino");
        clientName.add("Lindalva");
        clientName.add("Naza");

        ListView listViewClients = (ListView) findViewById(R.id.listViewClients);

       ArrayAdapter<String> clientAdapter =  new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, clientName.toArray(new String[]{}));
        listViewClients.setAdapter(clientAdapter);
    }
}
