package com.joliekoik.saveoursoul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class FireStation extends AppCompatActivity {

    String[] firestationArray = {"Ayer Itam Fire Station","Bagan Jermal Fire Station", "Bayan Lepas Fire Station", "Bukit Mertajam Fire Station",
            "Butterworth Fire station", "Centre Fire Station", "Jalan Perak Fire Station",
            "Kepala Batas Fire Station", "Nibong Tebal Fire Station","Perai Fire station"};

    String[] fireAddress={"Jalan Kluang, Taman Upc, 86100 Ayer Hitam, Johor, Malaysia",
            "Jalan Tanjong Tokong, Pulau Tikus, 10470 Tanjung Tokong, Pulau Pinang, Malaysia",
            "Jalan Tengah, 11900 Bayan Lepas, Pulau Pinang, Malaysia",
            "Jalan Aston, 14000 Bukit Mertajam, Pulau Pinang, Malaysia",
            "Kampung Jawa, 12000 Butterworth, Penang, Malaysia",
            "Gat Lebuh Chulia, George Town, 10300 George Town, Pulau Pinang, Malaysia",
            "Jalan Perak, Jelutong, 11600 George Town, Pulau Pinang, Malaysia",
            "Jln Tun Hamdan Sheikh Tahir, 13200 Kepala Batas, Penang, Malaysia",
            "Jalan Atas, 14300 Nibong Tebal, Pulau Pinang, Malaysia",
            "Jalan Besar, Taman Iks, Simpang Ampat 14100, Pulau Pinang, Malaysia"};

    String[] fireNumber={"+607-758 2206", "+604-890 7335", " +604-643 4444","+60 4-538 4444", "+604-331 4444",
            "+604-261 4444", "+604-282 5544", "+604-575 4444", "+604-593 1444", "+604-587 4797"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_station);

        DPHelper array = new DPHelper(this);
        for(int i=1; i<firestationArray.length; i++){
            array.addFire(firestationArray[i],fireAddress[i],fireNumber[i]);
        }

        final String[] fireArray = array.getFireName();

        ListView listView = (ListView) findViewById(R.id.fire_list);
        MyAdapter myAdapter = new MyAdapter(this, fireArray);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = fireArray[position];
                Intent i = new Intent (FireStation.this, Details.class);
                i.putExtra("placeName", name);
                i.putExtra("placeType",3);
                startActivity(i);
            }
        });




    }


}

