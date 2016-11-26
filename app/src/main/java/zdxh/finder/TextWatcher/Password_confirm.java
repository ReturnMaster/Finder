package zdxh.finder.TextWatcher;

import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.rey.material.widget.EditText;

import java.util.Objects;

/**
 * Created by mkind on 2016/11/26 0026.
 */

public class Password_confirm implements TextWatcher {

    private Context context;
    private EditText editText = null;
    private EditText editText2 = null;


    public Password_confirm(Context context, EditText editText,EditText editText2){
        this.context = context;
        this.editText = editText;
        this.editText2=editText2;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {


        editable = editText.getText();
        Editable editable1 = editText2.getText();

        String str = String.valueOf(editable);
        char[] strChar = str.toCharArray();
        for(int i=0;i<str.length();i++) {
            if(strChar[i]==' '){
                editText.setError("抱歉，密码不能包含空格");
            }
        }
        if(!Objects.equals(String.valueOf(editable),String.valueOf(editable1))){
            editText2.setError("密码不一致");
            Log.d("editable",String.valueOf(editable));
            Log.d("pass",String.valueOf(editable1));
            //editText.setError(editable);
            //editText.requestFocus();
        }else{
            editText2.clearError();
        }

    }
}
