package com.sljjyy.sao.launcher;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.FrameLayout;

import com.sljjyy.sao.launcher.view.MainMenuActivity;


public class MainActivity extends Activity implements OnTouchListener, OnGestureListener {
    private Button button = null;
    GestureDetector detector;
    public static int width = 0;
    public static int height = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;

        setContentView(R.layout.activity_main);
        FrameLayout layout = (FrameLayout) findViewById(R.id.layout_main);
        button = (Button) findViewById(R.id.open_one_menu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionDialog();
            }
        });
        //new GestureDetector(this)的构造方法已经过时了 不要再用了
        detector = new GestureDetector(this, this);
        layout.setOnTouchListener(this);
        layout.setLongClickable(true);
    }

    protected void actionDialog() {
        Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
        startActivity(intent);

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

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //记得定义一个全局变量
        return detector.onTouchEvent(motionEvent);
    }


    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float v, float v2) {
        // motionEvent11 触摸的起始位置，motionEvent12 触摸的结束位置
        // v X轴每一秒移动的像素速度 v 是Y
        if (motionEvent2.getY() - motionEvent1.getY()>50) {
            //Y轴(纵坐标)移动50(大概是像素吧)后触发
            Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
            intent.putExtra("coord_x", (int)motionEvent1.getX());
            intent.putExtra("coord_y", (int)motionEvent1.getY());
            startActivity(intent);
        }
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }
}