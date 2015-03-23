package com.example.AppointmentApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Abi Pofahl
 */
public class ClientMain extends Activity implements View.OnClickListener {

    Button connectButton;
    Button createAppButton;
    Button viewAppButton;
    Button exitButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.clientmenu);

        // Set up buttons
        connectButton = (Button) findViewById(R.id.connectStylist);
        connectButton.setOnClickListener(this);
        createAppButton = (Button) findViewById(R.id.createAppointment);
        createAppButton.setOnClickListener(this);
        viewAppButton = (Button) findViewById(R.id.viewAppointment);
        viewAppButton.setOnClickListener(this);
        exitButton = (Button) findViewById(R.id.clientExit);
        exitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == connectButton) {
            Intent findStylist = new Intent(this, SearchStylist.class);
            this.startActivity(findStylist);
        } else if (v == createAppButton) {
            Intent findStylist = new Intent(this, CreateAppointment.class);
            this.startActivity(findStylist);
        } else if (v == viewAppButton) {
            // shows upcoming appointments
        } else  if (v == exitButton) {
            // close app
        }
    }
}