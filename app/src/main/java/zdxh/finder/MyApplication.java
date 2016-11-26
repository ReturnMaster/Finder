package zdxh.finder;

import android.app.Application;
import android.content.Context;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.context.IconicsContextWrapper;



/**
 * Created by mkind on 2016/11/18 0018.
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate(){
        context = getApplicationContext();
        Iconics.init(getApplicationContext());
        //register custom fonts like this (or also provide a font definition file)
        //Iconics.registerFont(new CustomFont());
    }
    public static Context getContext(){
        return context;
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(IconicsContextWrapper.wrap(base));
    }
}
