package com.joliekoik.saveoursoul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PoliceStation extends AppCompatActivity {


    String[] policeArray={"Bayan Baru Police Station","Bayan Lepas Police Station","Butterworth Police Station",
            "Dato Keramat Police Station","Jelutong Police Station","LTAB Bayan Lepas Police Station",
            "Police Contingent Office Penang", "Police Office Northeast","Pulau Tikus Police Station",
            "Queensbay Police Station","Sungai Nibong Police Station"};

    String[] policeAddress={"Jalan Tengah, Bayan Baru, 11900 Bayan Lepas, Penang, Malaysia",
            "7, Jalan Sungai Tiram 4, 11900 Bayan Lepas, Pulau Pinang, Malaysia",
            "Jalan Heng Choon Thian, Kampung Jawa, 12000 Butterworth, Pulau Pinang, Malaysia",
            "Jalan Dato Keramat, George Town, 10450 George Town, Pulau Pinang, Malaysia",
            "Jalan Tan Sri Teh Ewe Lim, 11600 Jelutong, Pulau Pinang, Malaysia",
            "Jalan Sultan Azlan Shah, 11900 Bayan Lepas, Pulau Pinang, Malaysia",
            "Jalan Penang, George Town, 10000 George Town, Pulau Pinang, Malaysia",
            "Jalan Patani, Kampung Makam, 10150 George Town, Pulau Pinang, Malaysia",
            "Jalan Burma, Pulau Tikus, 10350 George Town, Pulau Pinang, Malaysia",
            "E-32A-1, Lorong Bayan Indah 2, Bay Avenue, 11900 Bayan Lepas, Pulau Pinang, Malaysia",
            "Jalan Sultan Azlan Shah, 11900 Bayan Lepas, Pulau Pinang, Malaysia"};

    String[] policeNumber={"+604-646 1222", "+604-646 2222", "+604-332 2222", "+604-227 1422",
            " +604-282 5922", " +604-643 0900", "+604-222 1152", "+604-218 1822",
            " +604-228 0422", "+604-646 8522", "+604-643 0222" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_station);

        DPHelper array = new DPHelper(this);
        for(int i=1; i<policeArray.length; i++){
            array.addPolice(policeArray[i], policeAddress[i],policeNumber[i]);
        }

        final String[] mataArray = array.getPoliceName();

        ListView listView = (ListView) findViewById(R.id.police_list);
        MyAdapter myAdapter = new MyAdapter(this, mataArray);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = mataArray[position];
                Intent i = new Intent (PoliceStation.this, Details.class);
                i.putExtra("placeName", name);
                i.putExtra("placeType",1);
                startActivity(i);
            }
        });

    }


}

