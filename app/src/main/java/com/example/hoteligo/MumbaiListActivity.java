package com.example.hoteligo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MumbaiListActivity extends AppCompatActivity {

    ListView list;

    String hotels[] ={
            "The St.Regis",
            "Four Seasons Hotel",
            "Sofitel Mumbai BKC",
            "Vivanta By Taj",
            "The Westin Mumbai Garden City",
            "The Oberoi",
            "The Taj Mahal Palace",
            "The Leela",
            "The Lalit",
            "The Grand Central",
            "The Maratha",
            "JW Marriott"
    };

    Integer imageId[] ={
            R.drawable.hotel_mumbai1,
            R.drawable.hotel_mumbai2,
            R.drawable.hotel_mumbai3,
            R.drawable.hotel_mumbai4,
            R.drawable.hotel_mumbai5,
            R.drawable.hotel_mumbai6,
            R.drawable.hotel_mumbai7,
            R.drawable.hotel_mumbai8,
            R.drawable.hotel_mumbai9,
            R.drawable.hotel_mumbai10,
            R.drawable.hotel_mumbai11,
            R.drawable.hotel_mumbai12,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mumbai_list);

        CustomList adapter = new CustomList(MumbaiListActivity.this,hotels,imageId);

        list = findViewById(R.id.mumbai_listview);
        list.setAdapter(adapter);
    }
}