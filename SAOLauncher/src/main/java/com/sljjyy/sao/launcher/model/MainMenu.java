package com.sljjyy.sao.launcher.model;

import android.widget.ImageView;

import com.sljjyy.sao.launcher.R;

/**
 * Created by Administrator on 13-9-27.
 */
public class MainMenu {
    private int id;
    private int index;
    private String name;
    private int ico;
    private int ico2;

    public final static MainMenu SYSTEM;
    public final static MainMenu PHONE;
    static {
        SYSTEM = new MainMenu(0,0,"System", R.drawable.system_hover,R.drawable.system_normal);
        PHONE = new MainMenu(1,1,"Phone",R.drawable.phone_hover,R.drawable.phone_normal);
    }

    public MainMenu() {

    }
    public MainMenu(int id, int index, String name, int ico, int ico2) {
        this.id = id;
        this.index = index;
        this.name = name;
        this.ico = ico;
        this.ico2 = ico2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIco() {
        return ico;
    }

    public void setIco(int ico) {
        this.ico = ico;
    }

    public int getIco2() {
        return ico2;
    }

    public void setIco2(int ico2) {
        this.ico2 = ico2;
    }
}
