package com.example.hoteligo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class BangloreListActivity extends AppCompatActivity {

    ListView list;

    String hotels[] ={
            "Taj West End",
            "ITC Windsor",
            "The Oberoi",
            "Ritz Carlton",
            "ITC Royal Gardenia",
            "The Lalit Ashok",
            "The Leela Palace",
            "Radisson Blu",
            "The Zuri Whitefield",
            "Gokulam Grand Hotel & Spa",
            "Hyatt",
            "The Chanchery Pavilion",
            "Vivanta By Taj"
    };

    Integer imageId[] ={
            R.drawable.bangalore_hotel1,
            R.drawable.bangalore_hotel2,
            R.drawable.bangalore_hotel3,
            R.drawable.bangalore_hotel4,
            R.drawable.bangalore_hotel5,
            R.drawable.bangalore_hotel6,
            R.drawable.bangalore_hotel7,
            R.drawable.bangalore_hotel8,
            R.drawable.bangalore_hotel9,
            R.drawable.bangalore_hotel_10,
            R.drawable.bangalore_hotel11,
            R.drawable.bangalore_hotel12,
            R.drawable.bangalore_hotel13,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banglore_list);

        CustomList adapter = new CustomList(BangloreListActivity.this,hotels,imageId);

        list = findViewById(R.id.bangalore_listview);
        list.setAdapter(adapter);
    }
}