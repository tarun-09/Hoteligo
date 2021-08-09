package com.example.hoteligo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class DelhiListActivity extends AppCompatActivity {

    ListView list;

    String hotels[] = {
            "The Leela Palace",
            "Taj Mahal Hotel",
            "The Oberoi",
            "The Lodhi",
            "The Imperial",
            "ITC Grand Bharat",
            "ITC Maurya",
            "The Roseate",
            "Taj Palace Hotel",
            "Radisson Blu Hotel",
            "Vivanta By Taj",
            "WelcomHotel",
            "Eros Hotel",
            "The Claridges",
            "The Lalit",
            "Shangri-La's Eros Hotel"};

    Integer[] imageId = {
            R.drawable.delhi_hotel1,
            R.drawable.delhi_hotel2,
            R.drawable.delhi_hotel3,
            R.drawable.delhi_hotel4,
            R.drawable.delhi_hotel5,
            R.drawable.delhi_hotel6,
            R.drawable.delhi_hotel7,
            R.drawable.delhi_hotel8,
            R.drawable.delhi_hotel9,
            R.drawable.delhi_hotel10,
            R.drawable.delhi_hotel11,
            R.drawable.delhi_hotel12,
            R.drawable.delhi_hotel13,
            R.drawable.delhi_hotel14,
            R.drawable.delhi_hotel15,
            R.drawable.delhi_hotel16,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhi_list);

        CustomList adapter = new CustomList(DelhiListActivity.this,hotels,imageId);

        list = findViewById(R.id.delhi_listview);
        list.setAdapter(adapter);

    }
}