package md.mazharul.islam.jihan.reportings.Offline;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Arif on 8/4/2017.
 */

public class OfflineInfo {
    SharedPreferences sharedpreferences;
    Context context;
    public OfflineInfo(Context context){
        if(context==null){
            System.out.println("Context is null....");
        }
        this.context=context;
        sharedpreferences = context.getSharedPreferences("user_info", Context.MODE_PRIVATE);
    }

    public void saveUserName(String s){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("username",s);
        editor.commit();
    }

    public String getUserName(){
        return sharedpreferences.getString("username","");
    }


    public void clearAll(){
        sharedpreferences.edit().clear().apply();
    }
}
