package zdxh.finder;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import zdxh.finder.Image.Banner_ImageLoader;
import zdxh.finder.setting.Settings;
import zdxh.finder.user.Login;
import zdxh.finder.user.SignUp;
import zdxh.finder.user.UserProfile;


public class MainActivity extends Activity {


    public static MainActivity mainactivity;
    List<String> images=new ArrayList<String>();



    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.setting: {
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
            }break;
            case R.id.search:{
                Toast.makeText(MainActivity.this,"search",Toast.LENGTH_SHORT).show();
            }break;
            default:
                break;
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainactivity = this;


        Bmob.initialize(this, "5de6647da9b4f2149db58256e716ef15");

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        Button btn = (Button)findViewById(R.id.test_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
        Button btn2 = (Button)findViewById(R.id.test_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });

        Button btn3 = (Button)findViewById(R.id.test_btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,UserProfile.class);
                startActivity(intent);
            }
        });




        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://trailer-10049747.cos.myqcloud.com/data.json", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                                Banner banner = (Banner) findViewById(R.id.banner);
                                //设置图片加载器
                                banner.setImageLoader(new Banner_ImageLoader());
                                images.add(jsonObject2.getString("pic1"));
                                images.add(jsonObject2.getString("pic2"));
                                images.add(jsonObject2.getString("pic3"));
                                images.add(jsonObject2.getString("pic4"));
                                //设置图片集合
                                banner.setImages(images);
                                //设置轮播时间
                                banner.setDelayTime(5000);
                                //banner设置方法全部调用完毕时最后调用
                                banner.setOnBannerClickListener(new OnBannerClickListener() {
                                    @Override
                                    public void OnBannerClick(int position) {
                                        switch(position){
                                            case 1:
                                                Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();break;
                                            case 2:
                                                Toast.makeText(MainActivity.this,"2",Toast.LENGTH_SHORT).show();break;
                                            case 3:
                                                Toast.makeText(MainActivity.this,"3",Toast.LENGTH_SHORT).show();break;
                                            case 4:
                                                Toast.makeText(MainActivity.this,"4",Toast.LENGTH_SHORT).show();break;
                                            default:
                                                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();break;
                                        }
                                    }
                                });
                                banner.start();
                                RelativeLayout r_up = (RelativeLayout)findViewById(R.id.hover_layout_up);
                                RelativeLayout r_down = (RelativeLayout)findViewById(R.id.hover_layout_down);
                                r_up.setVisibility(View.VISIBLE);
                                r_down.setVisibility(View.VISIBLE);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        RequestQueue mQueue = Volley.newRequestQueue(MainActivity.mainactivity);
        mQueue.add(jsonObjectRequest);
    }


    /**
     *
     */

}
