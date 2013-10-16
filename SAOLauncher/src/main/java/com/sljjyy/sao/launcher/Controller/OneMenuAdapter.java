package com.sljjyy.sao.launcher.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sljjyy.sao.launcher.R;
import com.sljjyy.sao.launcher.model.MainMenu;

import java.util.ArrayList;

/**
 * Created by Administrator on 13-10-14.
 */
public class OneMenuAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<MainMenu> dateList;


    public OneMenuAdapter(Context context, ArrayList<MainMenu> list){
        this.mInflater = LayoutInflater.from(context);
        dateList = list;
    }

    @Override
    public int getCount() {
        return dateList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Cache mm;
        if(view == null) {
            mm = new Cache();
            view = mInflater.inflate(R.layout.one_menu_item,null);
            mm.iv = (ImageView) view.findViewById(R.id.one_menu_ico);
            view.setTag(mm);
        } else {
            mm = (Cache) view.getTag();
        }
        mm.iv.setImageResource(dateList.get(i).getIco());

        return view;
    }

    protected class Cache{
        ImageView iv;
    }
}
