package zdxh.finder.TextWatcher;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.rey.material.widget.EditText;

/**
 * Created by mkind on 2016/11/26 0026.
 */

public class Text_Username implements TextWatcher {
    private Context context;
    private String str;

    private EditText editText = null;
    private int minLength = 0;


    public Text_Username(Context context,EditText editText,int minLength){
        this.context = context;
        this.editText = editText;
        this.minLength = minLength;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


    }

    @Override
    public void afterTextChanged(Editable editable) {

        //待加入：检查用户名是否被使用

        editable = editText.getText();
        str = String.valueOf(editable);
        char[] strChar = str.toCharArray();
        for(int i=0;i<editable.length();i++) {
            if(strChar[i]==' '){
                editText.setError("抱歉，用户名不能包含空格");
            }
        }
        int length = editable.length();
        if(length < minLength){
            editText.setError("用户名最少需要5个字符");
        }else {
            editText.clearError();
        }
    }
}
