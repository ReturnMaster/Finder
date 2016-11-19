package zdxh.finder;

import android.app.Application;
import android.content.Context;

/**
 * Created by mkind on 2016/11/18 0018.
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate(){
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
