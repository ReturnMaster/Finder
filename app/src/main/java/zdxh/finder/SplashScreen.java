package zdxh.finder;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

/**
 * Created by mkind on 2016/11/21 0021.
 */

public class SplashScreen extends Activity {
    protected boolean _active = true;
    protected int _splashTime = 2500;
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.splash);
        Thread splashTread = new Thread(){
            @Override
            public void run(){
                try{
                    int waited = 0;
                    while (_active &&(waited < _splashTime)){
                        sleep(100);
                        if (_active){
                            waited += 100;
                        }
                    }
                }catch (InterruptedException e){

                }finally {
                    finish();
                    startActivity(new Intent("zdxh.finder.MainActivity"));
                    onStop();
                }
            }
        };
        splashTread.start();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            _active = false;
        }
        return false;
    }
}
