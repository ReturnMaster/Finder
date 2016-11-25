package zdxh.finder.user;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import zdxh.finder.MyApplication;
import zdxh.finder.R;

/**
 * Created by mkind on 2016/11/23 0023.
 */

public class Login extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        BmobUser bu2 = new BmobUser();
        bu2.setUsername("lucky");
        bu2.setPassword("123456");
        bu2.login(new SaveListener<BmobUser>() {

            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if(e==null){
                    Toast.makeText(MyApplication.getContext(),"登录成功:",Toast.LENGTH_SHORT).show();
                    //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
                    //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                }else{
                    Log.d("LoginError：", String.valueOf(e));
                }
            }
        });



    }
}
