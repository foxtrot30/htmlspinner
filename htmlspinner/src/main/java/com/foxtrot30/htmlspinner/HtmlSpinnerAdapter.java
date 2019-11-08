package com.foxtrot30.htmlspinner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HtmlSpinnerAdapter extends BaseAdapter {
    private ArrayList<HtmlSpinnerModel> list;
    private Context context;
    private LayoutInflater inflater;

    public HtmlSpinnerAdapter(Context context, ArrayList<HtmlSpinnerModel> list) {
        this.list = list;
        this.context = context;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null)
            view = inflater.inflate(R.layout.spinner_item, null);

        ((TextView) view.findViewById(R.id.tview_spinner)).setText(list.get(position).getValue());
        return view;
    }

    public String val(int pos) {
        return list.get(pos).getValue();
    }

    public String key(int pos) {
        return list.get(pos).getKey();
    }
}
