package com.e.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class Home extends AppCompatActivity {

    //call data base class connection
    DatabaseHelper db;
    //create a listview variable
    ListView userList;
    //Create an array list variable
    ArrayList<String> ListItem;
    //create an adapter variable
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //instance DB connection
        db = new DatabaseHelper(this);
        //create an empty array
        ListItem = new ArrayList<>();
        //call listview id
        userList = findViewById(R.id.lista);
        //List users information
        viewData();

        //Events
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = userList.getItemAtPosition(i).toString();
                Toast.makeText(Home.this, "info" + text, Toast.LENGTH_SHORT).show();
                ;
            }
        });
    }

    private void viewData() {
        Cursor cursor = db.SelectUsersData();

        if (cursor.getCount() == 0) {
            Toast.makeText(this,
                    "Empty Data Base", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                ListItem.add(cursor.getString(1));
                ListItem.add(cursor.getString(2));
            }
            adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_dropdown_item, ListItem);
            userList.setAdapter(adapter);
        }
    }
}
