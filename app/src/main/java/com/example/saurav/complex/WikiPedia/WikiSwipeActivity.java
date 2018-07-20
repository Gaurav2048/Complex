package com.example.saurav.complex.WikiPedia;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saurav.complex.R;
import com.example.saurav.complex.WikiPedia.Adapter.SliderAdapter;

public class WikiSwipeActivity extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout linearLayout;
    Button pButton, NButton;
    int currentPage =0;
    private TextView[] nDots;
    int level = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_wiki_swipe);

        viewPager = (ViewPager) findViewById(R.id.pager);
        linearLayout = (LinearLayout) findViewById(R.id.layout_linear);
        pButton= (Button) findViewById(R.id.pButton);
        NButton = (Button) findViewById(R.id.NButton);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        final SliderAdapter adapter= new SliderAdapter(getApplicationContext());
        viewPager.setAdapter(adapter);
        level=0;
        addDotsIndicator(0);

        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(level!=0)
                {
                    startActivity(new Intent(getApplicationContext(), WikiHomeActivity.class));
                finish();
                }
            }
        });

        NButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level!=3){
                    viewPager.setCurrentItem(level+1);
                }else {
                    startActivity(new Intent(getApplicationContext(), WikiHomeActivity.class));
                    finish();
                }




            }
        });

        ViewPager.OnPageChangeListener viewLIstner = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addDotsIndicator(position);
                currentPage = position;
                if (position ==0) {

                    NButton.setEnabled(true);
                    NButton.setVisibility(View.VISIBLE);
                    NButton.setText("NEXT");
                    pButton.setVisibility(View.GONE);
                    pButton.setEnabled(false);
                    level = position;


                }else if (position==1){
                    NButton.setEnabled(true);
                    pButton.setEnabled(true);
                    NButton.setText("NEXT");
                    NButton.setVisibility(View.VISIBLE);
                    pButton.setVisibility(View.VISIBLE);
                    level = position;



                }else if (position==2){
                    NButton.setEnabled(true);
                    pButton.setEnabled(true);
                    NButton.setText("NEXT");
                    NButton.setVisibility(View.VISIBLE);
                    pButton.setVisibility(View.VISIBLE);
                    level = position;



                }else if(position==3){
                    NButton.setEnabled(true);
                    pButton.setVisibility(View.INVISIBLE);
                    NButton.setText("FINISH");
                    pButton.setEnabled(false);
                    level=position;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        viewPager.addOnPageChangeListener(viewLIstner);
    }
    public void addDotsIndicator(int position){
        nDots= new TextView[4];
        linearLayout.removeAllViews();
        for(int i =0;i<nDots.length; i++){
            nDots[i] = new TextView(this);
            nDots[i].setText(Html.fromHtml("&#8226;"));
            nDots[i].setTextSize(35);
            nDots[i].setTextColor(getResources().getColor(R.color.ColorTransperentWhite));

            linearLayout.addView(nDots[i]);
        }
        if (nDots.length>0){
            nDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

}
