package com.example.saurav.complex.WikiPedia;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurav.complex.R;
import com.example.saurav.complex.WikiPedia.fragments.ExploreFragment;
import com.example.saurav.complex.WikiPedia.fragments.HistoryFragment;
import com.example.saurav.complex.WikiPedia.fragments.ListFragment;
import com.example.saurav.complex.WikiPedia.fragments.MapFragment;

public class WikiHomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDarkWikiPedia));

        setContentView(R.layout.fragment_explore);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new ExploreFragment() ).commit();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView
                .setOnNavigationItemSelectedListener(new
                                                             BottomNavigationView.OnNavigationItemSelectedListener() {
                                                                 @Override
                                                                 public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                                                     switch (item.getItemId()){
                                                                         case R.id.nav_explore :

                                                                              getSupportFragmentManager().beginTransaction().replace(R.id.container,new ExploreFragment() ).commit();
                                                                              return true;
                                                                         case R.id.nav_my_list :

                                                                               getSupportFragmentManager().beginTransaction().replace(R.id.container, new ListFragment()).commit();



                                                                             return true;
                                                                         case R.id.nav_history :

                                                                             getSupportFragmentManager().beginTransaction().replace(R.id.container, new HistoryFragment()).commit();

                                                                             return true;
                                                                         case R.id.nav_near_by:
                                                                              getSupportFragmentManager().beginTransaction().replace(R.id.container,new MapFragment()).commit();
                                                                             //   getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
                                                                             // expe



                                                                             return true;

                                                                     }
                                                                     return false;
                                                                 }
                                                             });



    }


}
