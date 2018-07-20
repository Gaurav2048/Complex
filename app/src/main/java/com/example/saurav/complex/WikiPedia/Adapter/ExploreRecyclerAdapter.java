package com.example.saurav.complex.WikiPedia.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saurav.complex.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by saurav on 7/19/2018.
 */

public class ExploreRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  ArrayList<Integer> holderCount;
  Context context;
    public ExploreRecyclerAdapter(Context context,ArrayList<Integer> holderCount) {
this.context =context;
this.holderCount= holderCount;
    }

    @Override
    public int getItemViewType(int position) {
        return  holderCount.get(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==0){
            return new positionOneHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.wiki_viewtype_one, parent, false));
        }else if (viewType==1){
            return new positionTwoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.wiki_viewtype_two, parent, false));

        }else if (viewType==2){
            return new positionOneHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.wiki_viewtype_three, parent, false));
        }else if (viewType==3){
            return new positionOneHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.wiki_viewtype_four, parent, false));
        }else if (viewType==4){
            return new positionOneHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.wiki_viewtype_five, parent, false));
        }else if (viewType==5){
            return new positionSixHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.wiki_viewtype_six, parent, false));
        }
        else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "openSans/OpenSans-Regular.ttf");
        Typeface typeface1 = Typeface.createFromAsset(context.getAssets(), "OVO/Ovo-Regular.ttf");

        if(holder.getItemViewType()==0){
    positionOneHolder oneHolder = (positionOneHolder) holder;

}else if (holder.getItemViewType()==1){

    positionTwoHolder twoHolder = (positionTwoHolder) holder;
twoHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
twoHolder.recyclerView.setAdapter(new ExploreSecondAdapter(context));
twoHolder.date_detail.setTypeface(typeface1);
twoHolder.year.setTypeface(typeface);

}else if(holder.getItemViewType()==5){
            positionSixHolder sixHolder = (positionSixHolder) holder;

            sixHolder.textView_one.setTypeface(typeface1);
            sixHolder.textView_two.setTypeface(typeface);
            sixHolder.textView_three.setTypeface(typeface);
        }
    }

    @Override
    public int getItemCount() {
        return holderCount.size();
    }
    public class positionOneHolder extends RecyclerView.ViewHolder{

        public positionOneHolder(View itemView) {
            super(itemView);
        }
    }
    public class positionSixHolder extends RecyclerView.ViewHolder{
        TextView textView_one, textView_two,textView_three;
        public positionSixHolder(View itemView) {
            super(itemView);
            textView_one = (TextView) itemView.findViewById(R.id.text_one_one);
            textView_two = (TextView) itemView.findViewById(R.id.text_one_two);
            textView_three = (TextView) itemView.findViewById(R.id.text_one_three);
        }
    }
    public class positionTwoHolder extends RecyclerView.ViewHolder{
RecyclerView recyclerView;
TextView date_detail,year;
        public positionTwoHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_type_two_wiki);
            date_detail= (TextView) itemView.findViewById(R.id.date_detail);
            year= (TextView) itemView.findViewById(R.id.year);


        }
    }
}
