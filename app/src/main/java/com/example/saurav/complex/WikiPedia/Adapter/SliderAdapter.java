package com.example.saurav.complex.WikiPedia.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.saurav.complex.R;
import com.example.saurav.complex.WikiPedia.LanguageActivity;

/**
 * Created by saurav on 5/16/2018.
 */

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slide_images={
            R.drawable.intro_wiki_one,
            R.drawable.intro_wiki_two,
            R.drawable.wiki_intro_three,
            R.drawable.intro_wiki_four

    };



    @Override
    public int getCount() {
        return slide_images.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view== (ImageView) object ;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ImageView view = (ImageView) inflater.inflate(R.layout.wiki_intro_slide, container,false);

        view.setImageResource(slide_images[position]);

        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==3){
                    context.startActivity(new Intent(context, LanguageActivity.class));
                }
            }
        });
        return view;
    };

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }
}
