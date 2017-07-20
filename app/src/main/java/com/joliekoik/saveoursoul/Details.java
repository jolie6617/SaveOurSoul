package com.joliekoik.saveoursoul;

import android.content.Intent;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        //String[] myStrings = intent.getStringArrayExtra("strings");
        String myStrings = intent.getStringExtra("placeName");
        int placeType = intent.getIntExtra("placeType",-1);

        Bundle bundle = new Bundle();
        bundle.putString("edittext", myStrings);
        bundle.putInt("placeType",placeType);

        Fragment fragment = new BlankFragment();
        fragment.setArguments(bundle);

        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }
}
