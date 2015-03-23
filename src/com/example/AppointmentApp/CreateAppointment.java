package com.example.AppointmentApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


/**
 * Created by Abi Pofahl
 */
public class CreateAppointment extends Activity implements View.OnClickListener {

    ListView serviceList;
    Button createApp;
    String [] serviceArray;
    String selected;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makeappointment);

        serviceList = (ListView) findViewById(R.id.serviceList);
        serviceArray = new String[] {"Cut", "Color", "Eyebrow Wax"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.id.stylistList, serviceArray);
        serviceList.setAdapter(arrayAdapter);

        serviceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = serviceArray [position];
            }
        });

        createApp = (Button) findViewById(R.id.createAppButton);
        createApp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == createApp) {
            Intent backToMain = new Intent(this, ClientMain.class);
            this.startActivity(backToMain);
        }
    }
}