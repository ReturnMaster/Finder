package zdxh.finder.user;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.rey.material.widget.EditText;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import zdxh.finder.MyApplication;
import zdxh.finder.R;

/**
 * Created by mkind on 2016/11/23 0023.
 */

public class Login extends Activity {

    private String username;
    private String password;
    private EditText get_username;
    private EditText get_password;
    private Button btn_login;
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

        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get_username = (EditText)findViewById(R.id.login_username);
                get_password = (EditText)findViewById(R.id.login_password);
                username = String.valueOf(get_username.getText());
                password = String.valueOf(get_password.getText());
                BmobUser bu2 = new BmobUser();
                bu2.setUsername(username);
                bu2.setPassword(password);
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
        });

    }
}
