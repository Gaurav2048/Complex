package com.example.saurav.complex.TheHindu;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.saurav.complex.R;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HinduhomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
ExpandableListView lvExp;
ExpandableListAdapter listAdapter;
TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window =  getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(HinduhomeActivity.this,R.color.black));
        setContentView(R.layout.activity_hinduhome);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        prepareListData();
        setCustomTabs();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        lvExp = (ExpandableListView) findViewById(R.id.lvExp);
        toolbar.setNavigationIcon(R.drawable.ic_hambarg);
        TextView title_bnar = (TextView) findViewById(R.id.title_bnar);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "OVO/Ovo-Regular.ttf");
        title_bnar.setTypeface(typeface);
        toolbar.inflateMenu(R.menu.the_hindu_menu);
        setSupportActionBar(toolbar);

        listAdapter = new com.example.saurav.complex.TheHindu.Adapter.ExpandableListAdapter(this, listDataHeader, listDataChild);
        lvExp.setAdapter(listAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.syncState();

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                      drawer.openDrawer(GravityCompat.START);
                 }
            }
        });
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setCustomTabs() {
    for(int i=0;i<listDataHeader.size();i++){
        TextView flater = (TextView) LayoutInflater.from(getApplicationContext()).inflate(R.layout.tabs, null);
        flater.setTypeface(Typeface.createFromAsset(getAssets(), "openSans/OpenSans-Regular.ttf"));
        flater.setText(listDataHeader.get(i));
        TabLayout.Tab tab= tabLayout.newTab();
         tab.setCustomView(flater);
         tabLayout.addTab(tab);
    }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.the_hindu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Home");
        listDataHeader.add("National");
        listDataHeader.add("International");
        listDataHeader.add("States");
        listDataHeader.add("Business");
        listDataHeader.add("Cities");
        listDataHeader.add("News in Quotes");
        listDataHeader.add("PrintPlay");
        listDataHeader.add("Sports");
        listDataHeader.add("Editorials");
        listDataHeader.add("Entertainment");
        listDataHeader.add("Social");
        listDataHeader.add("Books");
        listDataHeader.add("Life & style");
        listDataHeader.add("Technology");
        listDataHeader.add("Sci & Tech");
        listDataHeader.add("Cities");
        listDataHeader.add("Educations");
        listDataHeader.add("Multimedia");
        listDataHeader.add("thRead");
        listDataHeader.add("Special");
        listDataHeader.add("Today's paper");
        listDataHeader.add("News Digest ");
        listDataHeader.add("Archive");
        listDataHeader.add("About us");
        listDataHeader.add("Help");
        listDataHeader.add("Terms & conditions");
        listDataHeader.add("Privacy policy");
        listDataHeader.add("Updated privacy policy");
        // Adding child data
        List<String> States = new ArrayList<String>();
        States.add("Andhra Pradesh");
        States.add("Karnataka");
        States.add("Kerala");
        States.add("Tamil Nadu");
        States.add("Telangana");
        States.add("Other States");

        List<String> Business = new ArrayList<String>();
        Business.add("Economy");
        Business.add("Markets");
        Business.add("Industry");


        List<String> city = new ArrayList<String>();
        city.add("Bengalaru");
        city.add("Chennai");
        city.add("Coimbatore");
        city.add("Delhi");
        city.add("Hyderabad");
        city.add("Kochi");
        city.add("Kozikode");
        city.add("Kolkata");
        city.add("Madurai");
        city.add("Mangalaru");
        city.add("Mumbai");
        city.add("Puducherry");
        city.add("Trivandampuram");
        city.add("Tiruchirapalli");
        city.add("Vijayawada");
        city.add("Visakhapattanam");
        ArrayList<String> Sports = new ArrayList<>();
        Sports.add("Cricket");
        Sports.add("Tennis");
        Sports.add("Football");
        Sports.add("Hockey");
        Sports.add("Motorsport");
        Sports.add("Race");
        Sports.add("Atheletics");
        Sports.add("Other sports");

        ArrayList<String> Editorial = new ArrayList<>();
        Editorial.add("Editorial");
        Editorial.add("Lead");
        Editorial.add("Columns");
        Editorial.add("Comments");
        Editorial.add("Interview");
        Editorial.add("Cartoon");
        Editorial.add("Open Page");
        Editorial.add("Reader's Editor");
        Editorial.add("Lead");

        ArrayList<String> Entert = new ArrayList<>();
        Entert.add("Movies");
        Entert.add("Music");
        Entert.add("Dance");
        Entert.add("Art");
        Entert.add("REviews");
        Entert.add("Theatre");


        ArrayList<String> Social = new ArrayList<>();
        Social.add("Faith");
        Social.add("History and culture");

        ArrayList<String> Book = new ArrayList<>();
        Book.add("Reviews");
        Book.add("Authors");

        ArrayList<String> lif= new ArrayList<>();
        lif.add("Fashion");
        lif.add("Fitness");
        lif.add("Food");
        lif.add("Motoring");
        lif.add("Travel");
        lif.add("Home and gardens");

        ArrayList<String> tech = new ArrayList<>();
        tech.add("Internet");
        tech.add("Gadget");

        ArrayList<String> scit= new ArrayList<>();
        scit.add("Health");
        scit.add("Environment");
        scit.add("Agriculture");

        ArrayList<String> Education = new ArrayList<>();
        Education.add("Careers");
        Education.add("Colleges");
        Education.add("Schools");

        ArrayList<String> multmd= new ArrayList<>();
        multmd.add("Photos");
        multmd.add("Videos");
        multmd.add("Podcast");

        ArrayList<String> comingSoon= new ArrayList<>();

        listDataChild.put(listDataHeader.get(0), comingSoon); // Header, Child data
        listDataChild.put(listDataHeader.get(1), comingSoon);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), States);
        listDataChild.put(listDataHeader.get(4), Business);
        listDataChild.put(listDataHeader.get(5), city);
        listDataChild.put(listDataHeader.get(6), comingSoon);
        listDataChild.put(listDataHeader.get(7), comingSoon);
        listDataChild.put(listDataHeader.get(8), Sports);
        listDataChild.put(listDataHeader.get(9), Editorial);
        listDataChild.put(listDataHeader.get(10),Entert);
        listDataChild.put(listDataHeader.get(11), Social);
        listDataChild.put(listDataHeader.get(12), Book);
        listDataChild.put(listDataHeader.get(13), lif);
        listDataChild.put(listDataHeader.get(14), tech);
        listDataChild.put(listDataHeader.get(15), scit);
        listDataChild.put(listDataHeader.get(16), Education);
        listDataChild.put(listDataHeader.get(17), multmd);
        listDataChild.put(listDataHeader.get(18), comingSoon);
        listDataChild.put(listDataHeader.get(19), comingSoon);
        listDataChild.put(listDataHeader.get(20), comingSoon);
        listDataChild.put(listDataHeader.get(21), comingSoon);
        listDataChild.put(listDataHeader.get(22), comingSoon);
        listDataChild.put(listDataHeader.get(23), comingSoon);
        listDataChild.put(listDataHeader.get(24), comingSoon);
        listDataChild.put(listDataHeader.get(25), comingSoon);
        listDataChild.put(listDataHeader.get(26), comingSoon);
        listDataChild.put(listDataHeader.get(27), comingSoon);
        listDataChild.put(listDataHeader.get(28), comingSoon);

    }
}
