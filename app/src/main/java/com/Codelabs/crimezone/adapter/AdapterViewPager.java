package com.Codelabs.crimezone.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.Codelabs.crimezone.adapter.AdapterViewPager;
import com.Codelabs.crimezone.R;

/**
 * Created by irfan on 02/03/15.
 */
public class AdapterViewPager extends PagerAdapter {
    Context _context;

    int[] _flag;
    LayoutInflater _inflater;

    //Constructor
    public AdapterViewPager(Context context, int[] flag) {
        this._context = context;
        this._flag = flag;
    }


    @Override
    public int getCount() {
        return _flag.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    public float getPageWidth(int position) {
        return 1f;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imgFlag;

        _inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = _inflater.inflate(R.layout.item_viewpager, container, false);

        imgFlag = (ImageView) itemView.findViewById(R.id.flag);

        //capture position and set to imageview
        imgFlag.setImageResource(_flag[position]);

        //add viewpager item to view pager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //remove viewpager item from viewPager
        ((ViewPager) container).removeView((RelativeLayout) object);
    }
}
