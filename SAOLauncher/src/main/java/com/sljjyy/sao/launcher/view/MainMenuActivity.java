package com.sljjyy.sao.launcher.view;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.sljjyy.sao.launcher.MainActivity;
import com.sljjyy.sao.launcher.controller.OneMenuAdapter;
import com.sljjyy.sao.launcher.R;
import com.sljjyy.sao.launcher.model.MainMenu;

import java.util.ArrayList;

/**
 * Created by Administrator on 13-9-27.
 */
public class MainMenuActivity extends ListActivity {

    OneMenuAdapter oneMenuAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setAttributes(initCoord());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_menu_list);
//        final DatabaseHelper helpter = new DatabaseHelper(this);
        oneMenuAdapter = new OneMenuAdapter(this, getData());
        setListAdapter(oneMenuAdapter);

    }

    private WindowManager.LayoutParams initCoord(){
        WindowManager.LayoutParams params = getWindow().getAttributes();
        Intent intent = getIntent();
        params.x = intent.getIntExtra("coord_x", 0) - MainActivity.width / 2;
        params.y = intent.getIntExtra("coord_y", 0) - MainActivity.height / 2;
        Log.e("tag", "x,y = " + params.x + "," + params.y);
        return params;
    }

    private ArrayList<MainMenu> getData(){
        ArrayList<MainMenu> data = new ArrayList<MainMenu>();
        data.add(MainMenu.APPLS);
        data.add(MainMenu.SYSTEM);
        data.add(MainMenu.PHONE);
        return data;
    }


}
