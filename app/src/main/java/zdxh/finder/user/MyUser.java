package zdxh.finder.user;

import cn.bmob.v3.BmobUser;

/**
 * Created by mkind on 2016/11/24 0024.
 */

public class MyUser extends BmobUser {

    private String usename;
    private String password;
    private Boolean sex;
    private String nick;
    private Integer age;
    private String wechat;

    public boolean getSex() {
        return this.sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getNick() {
        return this.nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}
