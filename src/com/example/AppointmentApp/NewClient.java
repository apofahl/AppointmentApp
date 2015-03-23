package com.example.AppointmentApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Abi Pofahl
 */
public class NewClient extends Activity implements View.OnClickListener {
    EditText fName;
    EditText lName;
    EditText pass;
    EditText passCheck;
    EditText email;
    EditText zipCode;
    CheckBox textOk;
    TextView error;
    Button create;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newuser);

        create = (Button) findViewById(R.id.create);
        create.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        fName = (EditText) findViewById(R.id.firstName);
        lName = (EditText) findViewById(R.id.lastName);
        pass = (EditText) findViewById(R.id.password);
        passCheck = (EditText) findViewById(R.id.rePass);
        email = (EditText) findViewById(R.id.email);
        zipCode = (EditText) findViewById(R.id.zipCode);
        textOk = (CheckBox) findViewById(R.id.sendText);

        // Check valid info, set error message ??use toast
        String errorString = checkInfo();

        if (errorString.equals("")) {
            // Add to DB
            // Open main menu
            Intent next = new Intent(this, ClientMain.class);
            next.putExtra("user", email.getText().toString());
            this.startActivity(next);
        } else {
            error = (TextView) findViewById(R.id.newUserError);
            error.setText(errorString);
            error.setVisibility(View.VISIBLE);
        }
    }

    private String checkInfo() {
        String check = "";

        // Check name
        if (fName.getText() == null || fName.getText().toString().equals("") || lName.getText() == null || lName.getText().toString().equals("")) {
            check += "\nPlease enter name.";
        }

        // Check password --- Requirement???
        if (pass.getText() == null || pass.getText().toString().equals("") || passCheck.getText() == null || passCheck.getText().toString().equals("")) {
            check += "\nPlease enter password.";
        } else if (!pass.getText().toString().equals(passCheck.getText().toString())) {
            check += "\nPassword check does not match.";
        }

        // Check email
        if (email.getText() == null || email.getText().toString().equals("")) {
            check += "\nPlease enter email.";
        } else if (!email.getText().toString().contains("@")) {
            check += "\nEmail not valid.";
        }

        return check;
    }
}