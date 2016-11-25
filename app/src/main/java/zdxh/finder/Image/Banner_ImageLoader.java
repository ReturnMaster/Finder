package zdxh.finder.Image;

import android.content.Context;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.youth.banner.loader.ImageLoader;

import static zdxh.finder.Image.M_ImageLoader.initImageLoader;           //static,666

/**
 * Created by mkind on 2016/11/19 0019.
 */

public class Banner_ImageLoader extends ImageLoader {
       
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            initImageLoader(context);
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .build();
            Uri uri = Uri.parse((String) path);
            com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(String.valueOf(uri),imageView,options);
        }



}
