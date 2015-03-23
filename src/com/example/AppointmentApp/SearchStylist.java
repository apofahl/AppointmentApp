package com.example.AppointmentApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by Abi Pofahl
 */
public class SearchStylist extends Activity implements View.OnClickListener{

    Button searchButton;
    Button nameButtom;
    Button locButton;
    EditText nameSearch;
    EditText locSearch;
    ListView stylistList;
    Button chooseButton;
    ArrayList <String> stylistArray;
    String selected = "";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findstylist);

        nameButtom = (Button) findViewById(R.id.nameButton);
        nameButtom.setOnClickListener(this);
        locButton = (Button) findViewById(R.id.locationButton);
        locButton.setOnClickListener(this);
        searchButton = (Button) findViewById(R.id.searchButton);
        searchButton.setOnClickListener(this);
        nameSearch = (EditText) findViewById(R.id.nameSearch);
        locSearch = (EditText) findViewById(R.id.locSearch);
        stylistList = (ListView) findViewById(R.id.stylistList);
        chooseButton = (Button) findViewById(R.id.chooseButton);
        chooseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == nameButtom) {
            nameSearch.setVisibility(View.VISIBLE);
            searchButton.setVisibility(View.VISIBLE);

            if (locSearch.getVisibility() == View.VISIBLE) {
                locSearch.setVisibility(View.GONE);
            }
        } else if (v == locButton) {
            locSearch.setVisibility(View.VISIBLE);
            searchButton.setVisibility(View.VISIBLE);

            if (nameSearch.getVisibility() == View.VISIBLE) {
                nameSearch.setVisibility(View.GONE);
            }
        } else if (v == searchButton) {
            if (nameSearch.getVisibility() == View.VISIBLE) {
                if (nameSearch.getText() == null || nameSearch.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter name to search by.", Toast.LENGTH_SHORT).show();
                } else {
                    searchName(nameSearch.getText().toString());
                    stylistList.setVisibility(View.VISIBLE);
                    chooseButton.setVisibility(View.VISIBLE);
                }
            } else if (locSearch.getVisibility() == View.VISIBLE) {
                if (locSearch.getText() == null || locSearch.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter name to search by.", Toast.LENGTH_SHORT).show();
                } else {
                    searchLocation(locSearch.getText().toString());
                    stylistList.setVisibility(View.VISIBLE);
                    chooseButton.setVisibility(View.VISIBLE);
                }
            }
        } else if (v == chooseButton) {
            // use selected stylist to pass to next page
            if (selected.equals("")) {
                Toast.makeText(getApplicationContext(), "Choose stylist from list.", Toast.LENGTH_SHORT).show();
            } else {
                Intent stylistConnect = new Intent(this, ClientMain.class);  // put class we want opened
                stylistConnect.putExtra("stylist", selected);
                this.startActivity(stylistConnect);
            }

        }
    }

    private void searchName(String name) {
        stylistArray = new ArrayList<String>();

        // query to look up stylist by name
        stylistArray.add("Anna Green");
        stylistArray.add("Josie Wolf");
        stylistArray.add("Mary Jones");

        setSelectItem();
    }

    private void searchLocation(String location) {
        stylistArray = new ArrayList<String>();

        // query to look up stylist by zip
        stylistArray.add("Anna Green");
        stylistArray.add("Josie Wolf");
        stylistArray.add("Mary Jones");

        setSelectItem();
    }

    private void setSelectItem() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.id.stylistList, stylistArray);
        stylistList.setAdapter(arrayAdapter);

        stylistList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = stylistArray.get(position);
            }
        });
    }
}