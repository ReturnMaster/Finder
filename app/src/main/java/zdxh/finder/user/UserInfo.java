package zdxh.finder.user;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.iconics.view.IconicsImageView;

import zdxh.finder.MainActivity;
import zdxh.finder.R;

/**
 * Created by mkind on 2016/11/26 0026.
 */

public class UserInfo extends Activity implements View.OnClickListener {
    private IconicsImageView back;
    private TextView user_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        back = (IconicsImageView)findViewById(R.id.arrow_back);
        user_info = (TextView)findViewById(R.id.user_info);
        back.setTag(1);
        user_info.setTag(1);
        back.setOnClickListener(this);
        user_info.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int tag = (Integer) view.getTag();
        switch (tag){
            case 1:{
                finish();
            }break;
            default:{

            }break;
        }
    }
}
