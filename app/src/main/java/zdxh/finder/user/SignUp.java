package zdxh.finder.user;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.rey.material.widget.EditText;
import com.rey.material.widget.ProgressView;

import java.util.Objects;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import zdxh.finder.R;
import zdxh.finder.TextWatcher.Password_confirm;
import zdxh.finder.TextWatcher.Text_Username;

/**
 * Created by mkind on 2016/11/24 0024.
 */

public class SignUp extends Activity {

    private String username;
    private String password;
    private String password_confirm;
    private String p_w_c;
    private EditText get_username;
    private EditText get_password;
    private EditText get_password_confirm;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        get_username = (EditText)findViewById(R.id.sign_username);
        get_password = (EditText)findViewById(R.id.sign_password);
        get_password_confirm = (EditText)findViewById(R.id.sign_password_confirm);

        get_username.addTextChangedListener(new Text_Username(SignUp.this,get_username,5));
        get_password_confirm.addTextChangedListener(new Password_confirm(SignUp.this,get_password,get_password_confirm));


        Button btn_signup = (Button)findViewById(R.id.btn_sign_up);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = String.valueOf(get_username.getText());
                password = String.valueOf(get_password.getText());
                password_confirm = String.valueOf(get_password_confirm.getText());

                    BmobUser bu = new BmobUser();
                    Log.d("username",username);
                    Log.d("password",password_confirm);
                    bu.setUsername(username);
                    bu.setPassword(password_confirm);
                    //bu.setEmail("s11endm@163.com"); //注意：不能用save方法进行注册
                    //bu.setMobilePhoneNumber();
                    bu.signUp(new SaveListener<MyUser>() {
                        @Override
                        public void done(MyUser s, BmobException e) {
                            if (e == null) {
                                Toast.makeText(SignUp.this, "注册成功:" + s.toString(), Toast.LENGTH_SHORT).show();
                            } else {
                                Log.d("注册错误", String.valueOf(e));

                            }
                        }
                });
                }
        });


    }




}
