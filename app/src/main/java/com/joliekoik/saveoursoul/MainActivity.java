package com.joliekoik.saveoursoul;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    protected Button mHospitalButton;
    protected Button mPoliceStationButton;
    protected Button mWorkshopButton;
    protected Button mFireStationButton;
    protected Button mButtonCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHospitalButton = (Button) findViewById(R.id.button);
        mHospitalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Hospital.class);
                startActivity(intent);
            }
        });

        mPoliceStationButton = (Button) findViewById(R.id.button2);
        mPoliceStationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, PoliceStation.class);
                startActivity(intent);
            }
        });

        mWorkshopButton = (Button) findViewById(R.id.button3);
        mWorkshopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, Workshop.class);
                startActivity(intent);
            }
        });

        mFireStationButton = (Button) findViewById(R.id.button4);
        mFireStationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, FireStation.class);
                startActivity(intent);
            }
        });

        mButtonCall = (Button) findViewById(R.id.buttonCall);


        mButtonCall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:999"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
            }
        });


    }

}

