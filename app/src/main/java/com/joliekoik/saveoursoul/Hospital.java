package com.joliekoik.saveoursoul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Hospital extends AppCompatActivity {

    // Array of strings...
    String[] hospitalArray = {"Penang General Hospital", "Hospital Sungai Bakap","Hospital Bukit Mertajam","Hospital Balik Pulau",
            "Hospital Seberang Jaya","Hospital Kepala Batas","Mount Miriam Cancer Hospital",
            "Penang Adventist Hospital", "Carl Corrynton Hospital Penang", "Lam Wah Ee Hospital","Pantai Hospital",
            "Island Hospital", "Loh Guan Lye Specialists Centre", "Gleneagles Medical Centre", "KPJ Penang Specialist Hospital",
            "Bagan Specailist Hospital"};

    String[] hosAddress={"Jalan Residensi, 10990 George Town, Pulau Pinang, Malaysia",
            "Besar, 14200 Sungai Petani, Pulau Pinang, Malaysia",
            "Jalan Kulim, 14000 Bukit Mertajam, Pulau Pinang, Malaysia",
            "Jalan Balik Pulau, 11000 Balik Pulau, Pulau Pinang, Malaysia",
            "Jalan Tun Hussein Ong, 13700 Prai, Penang, Malaysia",
            "Jalan Bertam 2, 13200 Kepala Batas, Pulau Pinang, Malaysia",
            "23, Jalan Bulan, Tanjong Takong, 11200 Tanjung Tokong, Pulau Pinang, Malaysia",
            "465, Jalan Burma, George Town, 10350 George Town, Pulau Pinang, Malaysia",
            "12-A, Jalan Masjid Negeri, 11600 George Town, Penang, Malaysia",
            "No. 141, Jalan Tan Sri Teh Ewe Lim, Jelutong, 11600 George Town, Pulau Pinang, Malaysia",
            "82, Jalan Tengah, 11900 Bayan Lepas, Pulau Pinang, Malaysia",
            "308, Jalan Macalister, 10450 George Town, Pulau Pinang, Malaysia",
            "238, Jalan Macalister, 10400 George Town, Pulau Pinang, Malaysia",
            "1, Jalan Pangkor, Pulau Tikus, 10050 George Town, Pulau Pinang, Malaysia",
            "570, Jalan Perda Utama, Bandar Baru Perda, 14000 Bukit Mertajam, Pulau Pinang, Malaysia",
            "Jalan Bagan 1, Taman Bagan, 13400 Butterworth, Pulau Pinang, Malaysia"};

    String[] hosNumber={"+60 4-222 5333"," +60 4-582 4333", "+60 4-549 7333", "+60 4-866 9333"," +60 4-382 7333",
            "+60 4-579 3333", "+60 4-892 3999", "+60 4-222 7200", "+60 4-829 9188", "+60 4-652 8888",
            "+60 4-442 8888", "+60 4-228 8222", "+60 4-238 8888", " +60 4-222 9111",
            "+60 4-548 6688", "+60 4-332 2800"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        final DPHelper array = new DPHelper(this);
        for(int i=1; i<hospitalArray.length; i++){
            array.addHospital(hospitalArray[i], hosAddress[i],hosNumber[i]);
        }

        final String[] hosArray = array.getHospitalName();

        ListView listView = (ListView) findViewById(R.id.hospital_list);
        MyAdapter myAdapter = new MyAdapter(this, hosArray);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = hosArray[position];
                Intent i = new Intent (Hospital.this, Details.class);
                i.putExtra("placeName", name);
                i.putExtra("placeType",0);
                startActivity(i);
            }
        });

    }

}
