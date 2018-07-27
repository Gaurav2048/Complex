package com.example.saurav.complex;

import android.Manifest;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.saurav.complex.Playstore.PlayStoreHomeActivity;
import com.example.saurav.complex.TheHindu.HinduStartActivity;
import com.example.saurav.complex.WikiPedia.IntroWikiActivity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
TextView developer_note_intro,eveloper_note_detail,the_hindu,placceholder,wekepedia,swiggy,google_map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eveloper_note_detail= (TextView) findViewById(R.id.eveloper_note_detail);
        developer_note_intro= (TextView) findViewById(R.id.developer_note_intro);
        wekepedia= (TextView) findViewById(R.id.wekepedia);
        google_map= (TextView) findViewById(R.id.google_map);
        swiggy= (TextView) findViewById(R.id.swiggy);
        placceholder= (TextView) findViewById(R.id.placceholder);
        the_hindu= (TextView) findViewById(R.id.the_hindu);
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                 ).withListener(new MultiplePermissionsListener() {
            @Override public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */}
            @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
        }).check();
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "openSans/OpenSans-Light.ttf");
        developer_note_intro.setTypeface(typeface1);

        Typeface typeface2 = Typeface.createFromAsset(getAssets(), "openSans/OpenSans-Regular.ttf");
        eveloper_note_detail.setTypeface(typeface2);

        Typeface typeface3 = Typeface.createFromAsset(getAssets(), "openSans/OpenSans-SemiBold.ttf");
        placceholder.setTypeface(typeface3);


        Typeface typeface4 = Typeface.createFromAsset(getAssets(), "OVO/Ovo-Regular.ttf");
        wekepedia.setTypeface(typeface4);

        Typeface typeface5 = Typeface.createFromAsset(getAssets(), "openSans/OpenSans-Regular.ttf");
        swiggy.setTypeface(typeface5);

        Typeface typeface6 = Typeface.createFromAsset(getAssets(), "openSans/OpenSans-Bold.ttf");
        google_map.setTypeface(typeface6);

        Typeface typeface7 = Typeface.createFromAsset(getAssets(), "playfair/PlayfairDisplay-Regular.ttf");
        the_hindu.setTypeface(typeface7);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.wekepedia){
        startActivity(new Intent(getApplicationContext(), IntroWikiActivity.class));
        }else if (v.getId()==R.id.play_store){
            startActivity(new Intent(getApplicationContext(), PlayStoreHomeActivity.class));

        }else if (v.getId()==R.id.the_hindu){
            startActivity(new Intent(getApplicationContext(), HinduStartActivity.class));

        }
    }
}
