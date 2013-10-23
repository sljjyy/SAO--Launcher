package com.sljjyy.sao.launcher;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.sljjyy.sao.launcher.model.MainMenu;
import com.sljjyy.sao.launcher.view.MainMenuActivity;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.open_one_menu);
//        final DatabaseHelper helpter = new DatabaseHelper(this);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                actionDialog();
            }
        });
    }

    protected void actionDialog() {
        startActivity(new Intent(MainActivity.this, MainMenuActivity.class));
    /*    ArrayList<MainMenu> data = initData();
        Dialog alertDialog;
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.one_menu_list, (ViewGroup)findViewById(R.id.layout_myview));
        ListView oneMenuList = (ListView) layout.findViewById(R.id.layout_one_menu);
        OneMenuAdapter oneMenuAdapter = new OneMenuAdapter(this,data);
        oneMenuList.setAdapter(oneMenuAdapter);
        alertDialog = new Dialog(this, R.style.one_menu_dialog);
        alertDialog.setContentView(layout);
        alertDialog.show();*/
    }
    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_settings:
                onSetWallpaper();
                return true;
        }
        return false;
    }

    public void onSetWallpaper() {
        //生成一个设置壁纸的请求
        final Intent pickWallpaper = new Intent(Intent.ACTION_SET_WALLPAPER);
        Intent chooser = Intent.createChooser(pickWallpaper,"chooser_wallpaper");
        //发送设置壁纸的请求
        startActivity(chooser);
    }



    private ArrayList<MainMenu> initData(){
        ArrayList<MainMenu> data = new ArrayList<MainMenu>();
        data.add(MainMenu.APPLS);
        data.add(MainMenu.PHONE);
        data.add(MainMenu.SYSTEM);
        return data;
    }


}
