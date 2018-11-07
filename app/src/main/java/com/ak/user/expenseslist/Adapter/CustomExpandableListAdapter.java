package com.ak.user.expenseslist.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.ak.user.expenseslist.R;

import java.util.LinkedHashMap;
import java.util.List;


public class CustomExpandableListAdapter extends BaseExpandableListAdapter
{
    private Context context;
    private List<String> listTitle;
    private LinkedHashMap<String,List<String>> listItem;

    public CustomExpandableListAdapter(Context context, List<String> listTitle, LinkedHashMap<String, List<String>> listItem)
    {
        this.context = context;
        this.listTitle = listTitle;
        this.listItem = listItem;
    }

    @Override
    public int getGroupCount() {
        return listTitle.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listItem.get(listTitle.get(i)).size();
        //return listItem.size();
    }

    @Override
    public Object getGroup(int i) {
        return listTitle.get(i);
    }

    @Override
    public Object getChild(int groupPos, int childPos) {
        return listItem.get(listTitle.get(groupPos)).get(childPos);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int groupPos, int childPos) {
        return childPos;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPos, boolean b, View convertView, ViewGroup parent)
    {
        String title = (String)getGroup(groupPos);

        if(convertView==null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_group,null);
        }

        TextView txtTitle = (TextView)convertView.findViewById(R.id.listTitle);
        txtTitle.setTypeface(null, Typeface.BOLD);
        txtTitle.setText(title);

        return convertView;
    }

    @Override
    public View getChildView(int groupPos, int childPos, boolean b, View convertView, ViewGroup parent)
    {
        String title = (String)getChild(groupPos,childPos);

        if(convertView==null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null);
        }

        TextView txtChild = (TextView)convertView.findViewById(R.id.expandableListItem);
        txtChild.setText(title);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
