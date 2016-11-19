package zdxh.finder;


import android.graphics.Color;

import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.youth.banner.Banner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import zdxh.finder.Image.Banner_ImageLoader;
import zdxh.finder.javabeans.Roll_Pic;


public class MainActivity extends AppCompatActivity{

    public static MainActivity mainactivity;
    List<String> images=new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainactivity = this;

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


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
                                //banner设置方法全部调用完毕时最后调用
                                banner.start();
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

}
