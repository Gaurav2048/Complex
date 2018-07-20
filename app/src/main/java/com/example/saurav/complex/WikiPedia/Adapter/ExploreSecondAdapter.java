package com.example.saurav.complex.WikiPedia.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saurav.complex.R;

/**
 * Created by saurav on 7/19/2018.
 */

public class ExploreSecondAdapter extends RecyclerView.Adapter<ExploreSecondAdapter.viwHolder> {
Context context;
    Integer [] image = new Integer[]{
            R.drawable.rename_one,
            R.drawable.rename_two,
            R.drawable.rename_three,
            R.drawable.rename_four,
            R.drawable.rename_one,
            R.drawable.rename_two,
    };
    String [] one_list = new String[]{
            "RMS Carpathia","Georg Anton Scha..",
            "Tenjano music","Tenjano music","Tenjano music",
            "Tenjano music"
    };

    String [] two_list = new String[]{
            "Suicide Attack","Sports",
            "Military","Humanity","Music",
            "Fitness"
    };
    public ExploreSecondAdapter(Context context) {
        this.context=context;
     }

    @NonNull
    @Override
    public viwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viwHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.wiki_subview_exp, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viwHolder holder, int position) {

        holder.image_card_sub.setImageResource(image[position]);
        holder.text_one.setText(one_list[position]);
        holder.text_two.setText(two_list[position]);

        if(position==0){
            holder.image_illusion.setVisibility(View.VISIBLE);
        }
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "openSans/OpenSans-Regular.ttf");
        holder.text_one.setTypeface(typeface);
        holder.text_two.setTypeface(typeface);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class viwHolder extends RecyclerView.ViewHolder{
ImageView image_card_sub;
TextView text_one;
TextView text_two;
ImageView image_illusion;

        public viwHolder(View itemView) {
            super(itemView);
            text_two = (TextView) itemView.findViewById(R.id.text_two);
            text_one = (TextView) itemView.findViewById(R.id.text_one);
            image_illusion= (ImageView) itemView.findViewById(R.id.image_illusion);
            image_card_sub= (ImageView) itemView.findViewById(R.id.image_card_sub);
        }
    }
}
