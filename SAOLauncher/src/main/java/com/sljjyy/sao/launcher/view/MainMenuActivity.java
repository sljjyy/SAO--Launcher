package com.sljjyy.sao.launcher.view;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.sljjyy.sao.launcher.Controller.OneMenuAdapter;
import com.sljjyy.sao.launcher.R;
import com.sljjyy.sao.launcher.model.MainMenu;

import java.util.ArrayList;

/**
 * Created by Administrator on 13-9-27.
 */
public class MainMenuActivity extends ListActivity {

    ListView oneMenu;
    OneMenuAdapter oneMenuAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        final DatabaseHelper helpter = new DatabaseHelper(this);
        oneMenuAdapter = new OneMenuAdapter(this, getData());
        setListAdapter(oneMenuAdapter);
    }


    private ArrayList<MainMenu> getData(){
        ArrayList<MainMenu> data = new ArrayList<MainMenu>();
        data.add(MainMenu.SYSTEM);
        data.add(MainMenu.PHONE);
        return data;
    }


}
