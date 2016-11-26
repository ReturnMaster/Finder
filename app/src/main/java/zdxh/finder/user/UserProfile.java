package zdxh.finder.user;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.mikepenz.iconics.view.IconicsImageView;

import zdxh.finder.R;

/**
 * Created by mkind on 2016/11/26 0026.
 */

public class UserProfile extends Activity {
    private IconicsImageView iconicsImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        iconicsImageView = (IconicsImageView)findViewById(R.id.user_info);
        iconicsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this,UserInfo.class);
                startActivity(intent);
            }
        });
    }
}
