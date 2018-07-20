package com.example.saurav.complex.WikiPedia.fragments;


import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.saurav.complex.R;
import com.example.saurav.complex.WikiPedia.Adapter.ExploreRecyclerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment {

    TextView editText;
     RecyclerView recycler_main_one;ArrayList<Integer> holderc= new ArrayList<>();
     ExploreRecyclerAdapter adapter;
    public ExploreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_wiki_home, container, false);
holderc.add(0);
holderc.add(1);
        holderc.add(2);
        holderc.add(3);holderc.add(4);
        holderc.add(5);
        recycler_main_one= (RecyclerView) view.findViewById(R.id.recycler_main_one);

        recycler_main_one.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new ExploreRecyclerAdapter(getContext(), holderc);
        recycler_main_one.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        recycler_main_one = (RecyclerView) view.findViewById(R.id.recycler_main_one);
        editText = (TextView) view.findViewById(R.id.editText);
        TextView textView = toolbar.findViewById(R.id.toolbar_title);
        TextView textView1 = toolbar.findViewById(R.id.toolbar_title1);
        TextView textView2 = toolbar.findViewById(R.id.toolbar_title2);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "OVO/Ovo-Regular.ttf");
        textView.setTypeface(typeface);
        textView1.setTypeface(typeface);
        textView2.setTypeface(typeface);

          toolbar.inflateMenu(R.menu.main_menu);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recycler_main_one); //set swipe to recylcerview
return view;
    }
    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction) {
            final int position = viewHolder.getAdapterPosition(); //get position which is swipe

            if (direction == ItemTouchHelper.RIGHT) {    //if swipe left

                holderc.remove(position);
                adapter.notifyDataSetChanged();


            }
        }
    };

}
