package com.sljjyy.sao.launcher.model;

import android.content.pm.ResolveInfo;

/**
 * Created by Administrator on 13-9-27.
 */
public class SubMenu {
    private int id;
    private MainMenu top;
    private int superId;
    private int index;
    private String name;
    private boolean isDir;
    private ResolveInfo app;

    public SubMenu(int id, MainMenu top, int superId, int index, String name, boolean dir, ResolveInfo app) {
        this.id = id;
        this.top = top;
        this.superId = superId;
        this.index = index;
        this.name = name;
        isDir = dir;
        this.app = app;
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

    public MainMenu getTop() {
        return top;
    }

    public void setTop(MainMenu top) {
        this.top = top;
    }

    public int getSuperId() {
        return superId;
    }

    public void setSuperId(int superId) {
        this.superId = superId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean dir) {
        isDir = dir;
    }

    public ResolveInfo getApp() {
        return app;
    }

    public void setApp(ResolveInfo app) {
        this.app = app;
    }
}
