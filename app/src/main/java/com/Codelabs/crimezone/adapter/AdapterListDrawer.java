package com.Codelabs.crimezone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.Codelabs.crimezone.R;
import com.Codelabs.crimezone.model.ModelAdapterListNav;

import java.util.ArrayList;

public class AdapterListDrawer extends BaseAdapter {

    private ImageView imgItem;
    private TextView titleItem;
    private ArrayList<ModelAdapterListNav> item;
    private Context context;

    public AdapterListDrawer(ArrayList<ModelAdapterListNav> item,
                                Context context) {
        this.item = item;
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflateLayout = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflateLayout.inflate(R.layout.list_item_drawer, null);
        }

        declareView(v);

        imgItem.setImageResource(item.get(position).getImageId());
        titleItem.setText(item.get(position).getTitleItem());

        return v;
    }

    private void declareView(View view) {
        imgItem = (ImageView) view.findViewById(R.id.img_item_drawer);
        titleItem = (TextView) view.findViewById(R.id.txt_item_drawer);
    }
}
