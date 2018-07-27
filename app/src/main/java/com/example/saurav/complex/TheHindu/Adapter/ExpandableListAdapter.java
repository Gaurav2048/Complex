package com.example.saurav.complex.TheHindu.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saurav.complex.R;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

/**
 * Created by saurav on 7/26/2018.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> _listDataHeader;
    private HashMap<String, List<String>> _listDataChild;
    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }
    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
          return this._listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }
        ImageView indicator = convertView.findViewById(R.id.i_view);


        if (getChildrenCount(groupPosition) == 0 ) {
            Log.e(  "getGroupView: ","gone" );
            indicator.setVisibility( View.INVISIBLE );
        }
        else {
            Log.e(  "getGroupView: ","not gone" );

            indicator.setVisibility( View.VISIBLE );
            indicator.setImageResource( isExpanded ? R.drawable.ic_minus : R.drawable.ic_plus );
        }
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        Typeface typeface = Typeface.createFromAsset(_context.getAssets(), "openSans/OpenSans-Regular.ttf");
        lblListHeader.setTypeface(typeface);
        lblListHeader.setText(headerTitle);

        return convertView;
    }



    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);
            Typeface typeface = Typeface.createFromAsset(_context.getAssets(), "openSans/OpenSans-Regular.ttf");
            txtListChild.setTypeface(typeface);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
