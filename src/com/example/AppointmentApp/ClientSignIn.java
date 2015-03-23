package com.example.AppointmentApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransport;

public class ClientSignIn extends Activity implements View.OnClickListener {

    TextView newUser;
    Button signIn;
    TextView errorMessage;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        newUser = (TextView) findViewById(R.id.newUserLink);
        signIn = (Button) findViewById(R.id.signInButton);
        errorMessage = (TextView) findViewById(R.id.signInError);
        newUser.setOnClickListener(this);
        signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == newUser) {
            Intent sendMe = new Intent(this, NewClient.class);
            this.startActivity(sendMe);
        } else {
            // Declare variables
            EditText password = (EditText) findViewById(R.id.signInPass);
            EditText userText = (EditText) findViewById(R.id.signInEmail);

            // Check that userName and password are not empty
            if (password.getText() == null || password.getText().toString().equals("")) {
                errorMessage.setText("Please enter password.");
                errorMessage.setVisibility(View.VISIBLE);
            } else if (userText.getText() == null || userText.getText().toString().equals("")) {
                errorMessage.setText("Please enter email.");
                errorMessage.setVisibility(View.VISIBLE);
            } else {
                // Check user email and password against database
                String userEmail = userText.getText().toString();
                String userPass = password.getText().toString();

                // Move on if credentials are correct
                Intent next = new Intent(this, ClientMain.class);
                next.putExtra("user", userEmail);
                this.startActivity(next);
            }
        }

    }

}
