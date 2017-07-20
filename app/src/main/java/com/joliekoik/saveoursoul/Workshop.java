package com.joliekoik.saveoursoul;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Workshop extends AppCompatActivity {


    String[] workshopArray = {"A'Automobile Body Works Sdn Bhd", "Ah Teong Auto Repair", "Beng San Auto Car Repair",
            "Black Bears Workshop","Chew Auto Repair Sdn Bhd", "Chin Soon Workshop Sdn Bhd", "Federal Motor Auto Windscreen Specialist",
            "Jit Seng Auto Repair", "Jsar Jaya sdn Bhd", "Kean Hin Spray Painting & Auto Car Repair", "LHCG Auto Services Sdn Bhd",
            "PG Leong Car-Body Repairs Sdn Bhd", "Shell Helix Service Centre", "Sky Auto Workshop",
            "Soon Hin Service & Repair sdn Bhd", "Sungai Pinang Workshop", "Tenggara Workshop Sdn Bhd",
            "Western Auto Repair Sdn Bhd", "Yan Kee Auto Glass Sdn Bhd"};

    String[] workshopAddress={"322, JALAN TANJUNG TOKONG, 10470 George Town, Penang, Malaysia",
            "5, Lorong Helang 2, Desa Permai Indah, Sungai Dua, Penang, 11700, Gelugor, Pulau Pinang, 11700, Malaysia",
            "54, Jalan Dunlop, Georgetown, Penang, 10400, Pulau Pinang, Pulau Pinang, 10400, Malaysia",
            "No. 12, Lorong Maju Jaya 1, Pusat Perniagaan Maju Jaya, Bukit Mertajam, Penang, 14000, Bukit Mertajam, Pulau Pinang, 14000, Malaysia",
            "1, Solok Sungai Pinang 4, Sungai Pinang, 11600, Jelutong, Pulau Pinang, 11600, Malaysia",
            "Lot 17315, 17317, Jalan Song Ban Keng, Mukim 15, Pulau Pinang, 14000 Bukit Mertajam, Malaysia",
            "77 & 77A, Lorong Kulit, 11600 George Town, Penang, Malaysia",
            "No. 40M, Jalan Macalister, Pulau Pinang, 10400 George Town, Malaysia",
            "40-M Macalister Road, George Town, 10400, Pulau Pinang, Pulau Pinang, 11400, Malaysia",
            "MK 13, Lot 1656, Jalan Relau, 11900 Bayan Lepas, Pulau Pinang, Malaysia",
            "Lorong Birch, George Town, 10250 George Town, Pulau Pinang, Malaysia",
            "No. 25G, PTN Jalan Osman Bin Kadir Lit Georgetown, 10150, Pulau Pinang, Pulau Pinang, 10150, Malaysia",
            "345, Jalan Jelutong, 11600, Jelutong, Pulau Pinang, 11600, Malaysia",
            "21-G, PSN Mahsuri 1/3, Sunway Tunas, Bayan Lepas, 11900, Bayan Lepas, Pulau Pinang, Malaysia",
            "91-K, Jalan Trusan, George Town, 10150 George Town, Pulau Pinang, Malaysia",
            "30, Jalan Trusan, 10150, Pulau Pinang, Pulau Pinang, 10150, Malaysia",
            "829, Jalan Paya Terubong, 11900 Bayan Lepas, Pulau Pinang, Malaysia",
            "3, Jalan Pantai Molek, Tanjung Tokong, 10470 George Town, Pulau Pinang, Malaysia",
            "89-I, Jalan P. Ramlee, Penang, 10460, Pulau Pinang, Pulau Pinang, 10460 Georgetown, Malaysia"};

    String[] workshopNumber={"+604-891 3333","+6012-451 7698", "+6012-452 4037","+60 12-233 3387", "+604-281 7107", "+604-538 6761",
            "+6012-421 1318", " +604-226 1511", "+604-226 1511", "+604-644 5729", "+6016-456 7788",
            "+604-282 8914", "+604-283 8845", "+604-646 4992", "+604-282 8426", " +604-283 6694",
            "+60 4-644 4240", "+604-890 2867", "+604-281 3378"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);

        DPHelper array = new DPHelper(this);
        for(int i=1; i<workshopArray.length; i++){
            array.addWorkshop(workshopArray[i],workshopAddress[i],workshopNumber[i]);
        }

        final String[] workArray = array.getWorkshopName();

        ListView listView = (ListView) findViewById(R.id.workshop_list);
        MyAdapter myAdapter = new MyAdapter(this, workArray);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = workArray[position];
                Intent i = new Intent (Workshop.this, Details.class);
                i.putExtra("placeName", name);
                i.putExtra("placeType",2);
                startActivity(i);
            }
        });



    }


}

