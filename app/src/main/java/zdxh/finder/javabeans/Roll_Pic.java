package zdxh.finder.javabeans;

import java.io.Serializable;

/**
 * Created by mkind on 2016/11/18 0018.
 */

public class Roll_Pic implements Serializable {
    public String pic_url1;
    public String pic_url2;
    public String pic_url3;
    public String pic_url4;

    public Roll_Pic(){

    }
    public String getPic_url2() {
        return pic_url2;
    }

    public void setPic_url2(String pic_url2) {
        this.pic_url2 = pic_url2;
    }

    public String getPic_url3() {
        return pic_url3;
    }

    public void setPic_url3(String pic_url3) {
        this.pic_url3 = pic_url3;
    }

    public String getPic_url4() {
        return pic_url4;
    }

    public void setPic_url4(String pic_url4) {
        this.pic_url4 = pic_url4;
    }

    public Roll_Pic(String pic_url1){
        this.pic_url1 = pic_url1;
    }


    public String getPic_url1() {
        return pic_url1;
    }

    public void setPic_url1(String pic_url1) {
        this.pic_url1 = pic_url1;
    }


}

